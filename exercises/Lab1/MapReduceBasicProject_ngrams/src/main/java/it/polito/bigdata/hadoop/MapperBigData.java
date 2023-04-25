package it.polito.bigdata.hadoop;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


/**
 * Basic MapReduce Project - Mapper
 */
class MapperBigData extends Mapper<
                    LongWritable, // Input key type
                    Text,         // Input value type
                    Text,         // Output key type
                    IntWritable> {// Output value type
    
    protected void map(
        LongWritable key,   // Input key type
        Text value,         // Input value type
        Context context) throws IOException, InterruptedException {

        // Split each sentence in words. Use whitespace(s) as delimiter 
		// (=a space, a tab, a line break, or a form feed)
		// The split method returns an array of strings
	
        String[] words = value.toString().split("\\s+");

        int n = 2;
        
        // Iterate over the set of words
        for(int i = 0; i < words.length - n + 1; i++) {
            String ngram = "";
            
            for(int j = 0; j < n; j++) {
            	ngram += (j > 0 ? " ":"") + words[i+j].toLowerCase();
            }

            context.write(new Text(ngram),
            		      new IntWritable(1));
        }
    }
}
