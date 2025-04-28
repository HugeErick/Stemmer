import snowball.SnowballStemmer;
import snowball.englishStemmer;
import snowball.spanishStemmer;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.*;

public class HCI {
  public static StringBuilder result = new StringBuilder();

  public void performStemming() {
    try {
      AnsiConsole.systemInstall();

      System.out.println("Enter the stemmer language ('english' or 'spanish'):");
      Scanner scanner = new Scanner(System.in);
      String algorithm = scanner.nextLine().toLowerCase(); // Normalize input to lowercase

      // Create an instance of the appropriate stemmer
      SnowballStemmer stemmer;

      // Acknowledges the user input
      if (algorithm.charAt(0) == 'e') {
        stemmer = new englishStemmer();
      } else if (algorithm.charAt(0) == 's') {
        stemmer = new spanishStemmer();
      } else {
        System.err.println(
          Ansi.ansi().fg(Ansi.Color.RED).a("Unsupported language: " + algorithm)
        );
        return;
      }

      System.out.println("Enter text to lemmatize (type 'exit' to quit):");

      while (true) {
        String input = scanner.nextLine();
        if (input.equalsIgnoreCase("exit")) {
          break;
        }

        // Clear the result StringBuilder for each new input
        result.setLength(0);

        // Process the input
        String[] words = input.split("\\s+");

        for (String word : words) {
          // Clean the word (remove punctuation, convert to lowercase)
          String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
          if (!cleanWord.isEmpty()) {
            // Set the current word to process
            stemmer.setCurrent(cleanWord);
            // Perform stemming
            stemmer.stem();
            // Get the stemmed result
            result.append(stemmer.getCurrent()).append(" ");
          } else {
            // Keep non-word characters as is
            result.append(word).append(" ");
          }
        }

        System.out.println(
          Ansi.ansi()
          .fg(Ansi.Color.GREEN).a("Lemmatized: ") // "Lemmatized:" in green
          .fg(Ansi.Color.BLUE).a(result.toString().trim()) // Result in blue
          .reset() // Reset formatting after the output
        );

        // Create a StopMoros instance and detect stop words
        StringBuilder originalText = new StringBuilder(input);
        StopMoros stopMoros = new StopMoros(originalText, algorithm);
        stopMoros.detectStopWords();
        stopMoros.morosStopped();
      }

      scanner.close();

    } catch (Exception e) {
      System.err.println(
        Ansi.ansi().fg(Ansi.Color.RED).a("Error: " + e.getMessage()).reset()
      );
    } finally {
      AnsiConsole.systemUninstall();
    }
  }

  public void processJsonFile(File jsonFile) {
    try {
      // Read JSON file
      JSONObject jsonObject;
      try (FileReader reader = new FileReader(jsonFile)) {
        jsonObject = new JSONObject(new JSONTokener(reader));
      }

      // Create a new JSON object with only the fields we want to keep
      JSONObject processedJson = new JSONObject();

      // Preserve orderNumber if it exists
      if (jsonObject.has("orderNumber")) {
        processedJson.put("orderNumber", jsonObject.get("orderNumber"));
      }

      // Extract language from JSON (default to english if not specified)
      String language = "english";
      if (jsonObject.has("language")) {
        String langCode = jsonObject.getString("language").toLowerCase();
        if (langCode.startsWith("e") || langCode.equals("en")) {
          language = "english";
        } else if (langCode.startsWith("s") || langCode.equals("es")) {
          language = "spanish";
        }
        System.out.println("Detected language: " + language);
        processedJson.put("language", language);
      } else {
        System.out.println("No language field found, defaulting to: english");
        processedJson.put("language", "english");
      }

      // Extract and process content
      StringBuilder contentBuilder = new StringBuilder();
      if (jsonObject.has("content")) {
        Object content = jsonObject.get("content");
        if (content instanceof String) {
          contentBuilder.append(content);
        } else if (content instanceof JSONArray) {
        ((JSONArray) content).forEach(item -> contentBuilder.append(item).append(" "));
        }
      }

      // Process the content with the detected language
      String processedContent = processText(contentBuilder.toString(), language);

      // Calculate term frequencies
      JSONObject termFrequencies = calculateTermFrequencies(processedContent);

      // Add processed content and term frequencies to new JSON
      processedJson.put("processedContent", processedContent);
      processedJson.put("termFrequencies", termFrequencies);

      // Write processed JSON to file
      File processedDir = new File("processedJson");
      if (!processedDir.exists()) {
        processedDir.mkdir();
      }

      File processedFile = new File(processedDir, "processed_" + jsonFile.getName());
      try (FileWriter writer = new FileWriter(processedFile)) {
        writer.write(processedJson.toString(4)); // Pretty-print JSON
      }

      System.out.println("Processed JSON saved to: " + processedFile.getAbsolutePath());

    } catch (IOException e) {
      System.err.println("Error processing JSON file: " + jsonFile.getName());
      e.printStackTrace();
    }
  }

  private JSONObject calculateTermFrequencies(String text) {
    JSONObject frequencies = new JSONObject();
    String[] words = text.split("\\s+");

    // First pass: count all terms
    for (String word : words) {
      String cleanWord = word.toLowerCase().replaceAll("[^a-zA-Z]", "");
      if (!cleanWord.isEmpty()) {
        int count = frequencies.optInt(cleanWord, 0);
        frequencies.put(cleanWord, count + 1);
      }
    }

    // Second pass: remove terms with frequency = 1
    JSONObject filteredFrequencies = new JSONObject();
    for (String term : frequencies.keySet()) {
      int count = frequencies.getInt(term);
      if (count > 1) {
        filteredFrequencies.put(term, count);
      }
    }

    return filteredFrequencies;
  }


  private String processText(String text, String language) {
    // Clear the result before processing
    result.setLength(0);

    // Perform stemming first
    SnowballStemmer stemmer;
    if (language.startsWith("e")) {
      stemmer = new englishStemmer();
    } else {
      stemmer = new spanishStemmer();
    }

    String[] words = text.split("\\s+");
    for (String word : words) {
      String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
      if (!cleanWord.isEmpty()) {
        stemmer.setCurrent(cleanWord);
        stemmer.stem();
        result.append(stemmer.getCurrent()).append(" ");
      } else {
        result.append(word).append(" ");
      }
    }

    // Then perform stop-word removal
    StringBuilder originalText = new StringBuilder(text);
    StopMoros stopMoros = new StopMoros(originalText, language);
    stopMoros.detectStopWords();
    stopMoros.morosStopped();

    // Return processed text
    return result.toString();
  }

  public void reprocessAllJsonsInDirectory() {
    result.setLength(0); // Clear the result before processing
    File processedDir = new File("processedJson");
    if (!processedDir.exists() || !processedDir.isDirectory()) {
        System.err.println("Processed JSON directory not found: " + processedDir.getAbsolutePath());
        return;
    }

    File[] jsonFiles = processedDir.listFiles((dir, name) -> name.toLowerCase().endsWith(".json"));
    if (jsonFiles == null || jsonFiles.length == 0) {
        System.out.println("No JSON files found in directory: " + processedDir.getAbsolutePath());
        return;
    }

    for (File jsonFile : jsonFiles) {
        try {
            // Read processed JSON file
            JSONObject jsonObject;
            try (FileReader reader = new FileReader(jsonFile)) {
                jsonObject = new JSONObject(new JSONTokener(reader));
            }

            // Get language and processed content
            String language = jsonObject.getString("language");
            String processedContent = jsonObject.getString("processedContent");

            // Create StopMoros instance for stop word removal
            StringBuilder contentBuilder = new StringBuilder(processedContent);
            StopMoros stopMoros = new StopMoros(contentBuilder, language);
            stopMoros.detectStopWords();
            stopMoros.morosStopped();

            // Get the filtered result
            String filteredContent = HCI.result.toString().trim();

            // Update the JSON object
            jsonObject.put("processedContent", filteredContent);

            // Recalculate term frequencies with the new content
            JSONObject termFrequencies = calculateTermFrequencies(filteredContent);
            jsonObject.put("termFrequencies", termFrequencies);

            // Overwrite the file with updated content
            try (FileWriter writer = new FileWriter(jsonFile)) {
                writer.write(jsonObject.toString(4));
            }

            System.out.println("Reprocessed: " + jsonFile.getName());

        } catch (IOException e) {
            System.err.println("Error reprocessing file: " + jsonFile.getName());
            e.printStackTrace();
        }
    }
  }
}
