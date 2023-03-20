# DABDPA
This repository containes the notes collected from the lectures and  of "Distributed architectures for big data processing and analytics" (**DABDPA**), hold at the Master Degree in Data Science and Engineering course (2022-2023) of Politecnico di Torino.

## Initial setup
### 1. Install Quarto
Quarto is "an open-source scientific and technical publishing system built on Pandoc", mainly maintained by Posit (formerly named RStudio). Find more info [here](https://quarto.org/).

To use Quarto, find the installer/package at [this link](https://quarto.org/docs/get-started/). Download and install the one compatible with OS in use.

To test if Quarto is correctly installed, use the following command in the terminal

```bash
quarto --version
```

### 2. Clone this repository
Install git and move to a target folder, then clone this repository in the local machine using the following command

```bash
git clone https://github.com/Edoch94/DABDPA.git
```

### 3. Create the conda environment
Install Miniconda (see [here](https://docs.conda.io/en/latest/miniconda.html) for instructions and download), and create a new environment for this project, using the `environment.yml` configuration file as a "blueprint".

- Move to the local folder where the DABDPA repository was cloned
- Create the environment based on `environment.yml`

```bash
conda env create -f environment.yml
```

## How to use
This repository is structured as a Quarto project. The configuration file of this project is `./qproject/_quarto.yml`. 

After performing changes on the Quarto files (`.qmd` files), the project has to be re-rendered to reflect the changes in the `.html` output files. To render the entire project, follow these steps:

1. Move to the local folder where the DABDPA repository was cloned
2. Activate the conda environment

```bash
conda activate DABDPA
```

3. Launch the Quarto project render

```bash
quarto render qproject
```

Notice that the output of the project is a series of `.html` files, saved in the `./qproject/output` folder. The output type can be changed to Microsoft Word (`.docx`) or PDF (`.pdf`) files in the `format` section of the `./qproject/_quarto.yml` configuration file.