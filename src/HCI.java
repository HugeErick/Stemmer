import snowball.SnowballStemmer;
import snowball.englishStemmer;
import snowball.spanishStemmer;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.util.Scanner;

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
}
