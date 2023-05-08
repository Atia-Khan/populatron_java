import java.text.DecimalFormat;

public class PopulationCSVParser {
    public long getTotalPopulation(String[] lines) {
        long total = 0;
        for(String line : lines) {
            String[] parts = line.split(",");
            if(parts.length >= 4) {
                String populationStr = parts[3].trim();
                try {
                    long population = Long.parseLong(populationStr);
                    total += population;
                } catch(NumberFormatException ex) {
                    System.err.println("Error parsing population in line: " + line);
                }
            }
        }
        return total;
    }

    public String formatPopulation(long population) {
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(population);
    }
}

