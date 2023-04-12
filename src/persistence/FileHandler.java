package persistence;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import jdk.jfr.events.FileWriteEvent;

/**
 * @author G
 */
class FileHandler {

    private static final String DELIMITER = ",";
    private static final String[] DELIMITER_PATTERN = {DELIMITER, ""};

    private FileHandler() {
    }

    public static void writeOut(List<List<String>> rows, String path) {
        String writeable = createWritable(rows);
        writeToFile(writeable, path);
    }

    private static String createWritable(List<List<String>> rows) {
        StringBuilder builder = new StringBuilder();
        String[] lineEndPattern = {System.lineSeparator(), ""};
        for (int i = 0; i < rows.size(); i++) {
            addRow(rows.get(i), builder);
            builder.append(lineEndPattern[(i + 1) / rows.size()]);

        }
        return builder.toString();
    }

    private static void addRow(List<String> data, StringBuilder builder) {
        for (int i = 0; i < data.size(); i++) {
            builder.append(data.get(i));
            builder.append(DELIMITER_PATTERN[(i + 1) / data.size()]);
        }
    }

    private static void writeToFile(String writeable, String path) {
        //try with resource (bezarja az eroforrasokat melyeket
        // a try ()-ben hozunk letre
        try (FileWriter writer = new FileWriter(path)) {
            writer.write(writeable);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static List<List<String>> readIn(String path) {
        List<List<String>> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String rawRow;
            while ((rawRow = reader.readLine()) != null) {
                List<String> nextRow = readRow(rawRow);
                result.add(nextRow);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return result;
    }

    private static List<String> readRow(String rawRow) {
        List<String> result = new ArrayList<>();
        String[] rowArray = rawRow.split(DELIMITER);
        fillList(result, rowArray);
        return result;
    }

    private static void fillList(List<String> result, String[] row) {
        for (String text : row) {
            result.add(text);
        }
    }
}
