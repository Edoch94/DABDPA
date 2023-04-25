package it.polito.bigdata.hadoop.lab;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import it.polito.bigdata.hadoop.lab.DriverBigData.COUNTERS;

/* Set the proper data types for the (key,value) pairs */
class MapperBigData extends Mapper<
                    Text, 			// Input key type
                    Text,    // Input value type
                    Text,         	// Output key type
                    Text> {	// Output value type
    
	String prefix;
	
	protected void setup(Context context) {
		prefix = context.getConfiguration().get("initialLetters").toString();
	}
	
    protected void map(
		Text key,   			// Input key type
		Text value,      // Input value type
        Context context) throws IOException, InterruptedException {
	
		if(key.toString().startsWith(prefix)) {
            context.write(key, value);
            context.getCounter(COUNTERS.SELECTED_WORDS).increment(1);
		} else {
			context.getCounter(COUNTERS.DISCARDED_WORDS).increment(1);
		}
    }
}
