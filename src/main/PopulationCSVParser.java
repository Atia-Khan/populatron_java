import java.text.DecimalFormat;
import java.util.ArrayList;

public class PopulationCSVParser {
    public List<Long> getTotalPopulation(List<String> lines) {
        List<Long> total = new ArrayList<>();
        for(String line : lines) {
            String[] parts = line.split(",");
            if(parts.length >= 4) {
                String populationStr = parts[4].trim();
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

