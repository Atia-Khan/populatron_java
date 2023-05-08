// import java.nio.charset.StandardCharsets;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.text.NumberFormat;
// import java.util.List;
// import java.util.Locale;

// public class PopulationCounter {
//     public static void main(String[] args) throws Exception {
//         long sum = 0;
//         String path = args[0];
//         List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.ISO_8859_1);
//         for(int i = 1; i < lines.size(); i++) {
//             String line = lines.get(i);
//             String[] terms = line.split(",");
//             String popText = terms[4];
//             if(popText.length() == 0) {
//                 continue;
//             }
//             long population = Integer.parseInt(popText);
//             sum += population;
//         }
//         String num = NumberFormat.getInstance(Locale.getDefault()).format(sum);
//         System.out.printf("World population is: %s\n", num);
//     }
// }

// import java.io.BufferedReader;
// import java.io.FileReader;
// import java.io.IOException;
// import java.text.DecimalFormat;

// public class PopulationCounter {
//     public static void main(String[] args) {
//         if(args.length != 1) {
//             System.out.println("Usage: PopulationCounter <input file>");
//             System.exit(1);
//         }

//         try(BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
//             long total = 0;
//             String line;
//             while((line = reader.readLine()) != null) {
//                 String[] parts = line.split(",");
//                 if(parts.length >= 4) {
//                     String populationStr = parts[3].trim();
//                     try {
//                         long population = Long.parseLong(populationStr);
//                         total += population;
//                     } catch(NumberFormatException ex) {
//                         System.err.println("Error parsing population in line: " + line);
//                     }
//                 }
//             }

//             DecimalFormat formatter = new DecimalFormat("#,###");
//             String formattedTotal = formatter.format(total);
//             System.out.println("World population is: " + formattedTotal);
//         } catch(IOException ex) {
//             System.err.println("Error reading file: " + ex.getMessage());
//         }
//     }
// }


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

// public class PopulationCounter {
//     public long calculateTotalPopulation(String filePath) throws IOException {
//         CsvParser csvParser = new CsvParser();
//         List<String[]> rows = csvParser.parseCsv(filePath);

//         long total = 0;
//         for (String[] row : rows) {
//             if (row.length >= 4) {
//                 String populationStr = row[3].trim();
//                 try {
//                     long population = Long.parseLong(populationStr);
//                     total += population;
//                 } catch (NumberFormatException ex) {
//                     System.err.println("Error parsing population in line: " + String.join(",", row));
//                 }
//             }
//         }

//         return total;
//     }
// }



public class PopulationCounterTest {
    @Test
    public void calculateTotalPopulation_withValidInput_shouldReturnCorrectTotal() throws IOException {
        CsvParser csvParserStub = Mockito.mock(CsvParser.class);
        List<String[]> rows = new ArrayList<>();
        rows.add(new String[] {"1", "New York", "USA", "10,000,000"});
        rows.add(new String[] {"2", "London", "UK", "8,000,000"});
        Mockito.when(csvParserStub.parseCsv("test.csv")).thenReturn(rows);

        PopulationCounter populationCounter = new PopulationCounter();
        long total = populationCounter.calculateTotalPopulation("test.csv");

        assertEquals(18000000, total);
    }
}
