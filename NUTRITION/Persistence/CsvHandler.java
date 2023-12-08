package Persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvHandler {
    public static void writeCsv(String filePath, List<String> lines) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            for (String line : lines) {
                writer.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();  // Manejar la excepción según sea necesario
        }
    }

    public static List<String[]> readCsv(String filePath) {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                records.add(values);
            }
        } catch (IOException e) {
            e.printStackTrace();  // Handle the exception according to your needs
        }

        return records;
    }
}
