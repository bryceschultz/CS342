import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Class: TextParser
 * Description: this class is used to read in text from a file.
 */
public class TextParser {
    /**
     * getWordsInFile      (return an array of words from a file)
     * Input : path (String)
     * Output : words (String[])
     * This method takes a path as input and uses regex to remove any non alphanumeric characters, then make all
     * the text lowercase, and then uses regex to split the text string into an array of Strings based on any white space
     * in the original String/text (for example spaces, newlines) and will then return the words after
     * the regex processing.
     */
    public String[] getWordsInFile(String path)  {
        Path fileName = Path.of(path);
        String fileContent = null;
        try {
            fileContent = Files.readString(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String[] words = fileContent.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase().split("\\s+");
        return words;
    }
}
