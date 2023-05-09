import java.text.DecimalFormat;
// import java.util.ArrayList;
// import java.util.List;

public class PopulationCSVParser {
    public long getTotalPopulation(String[] lines) {
        long total = 0;
        for (String line : lines) {
            String[] parts = line.split(",");
            if (parts.length >= 5) { // Check index 5 for population value
                String populationStr = parts[4].trim();
                try {
                    long population = Long.parseLong(populationStr);
                    total += population;
                } catch (NumberFormatException ex) {
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

