public class PopulationCounterApp {
    public static void main(String[] args) {
        if(args.length != 1) {
            System.out.println("Usage: PopulationCounter <input file>");
            System.exit(1);
        }

        PopulationFileReader fileReader = new PopulationFileReader();
        PopulationCSVParser csvParser = new PopulationCSVParser();

        try {
            String filePath = args[0];
            String[] lines = fileReader.readFile(filePath).toArray(new String[0]);
            long totalPopulation = csvParser.getTotalPopulation(lines);
            String formattedTotal = csvParser.formatPopulation(totalPopulation);
            System.out.println("World population is: " + formattedTotal);
        } catch(IOException ex) {
            System.err.println("Error reading file: " + ex.getMessage());
        }
    }
}

