import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

public class StopMoros {
  private final Set<String> englishStopWords;
  private final Set<String> spanishStopWords;
  private final StringBuilder paragraph;
  private final String language;
  protected final Set<String> detectedStopWords;

  public StopMoros(StringBuilder paragraph, String language) {
    this.paragraph = paragraph;
    this.language = language.toLowerCase();
    this.detectedStopWords = new HashSet<>();

    // Initialize English stop words
    // In StopMoros.java constructor
    this.englishStopWords = new HashSet<>(Arrays.asList(
      "a", "about", "above", "after", "again", "against", "all", "am", "an", "and", 
      "any", "are", "aren't", "as", "at", "be", "because", "been", "before", 
      "being", "below", "between", "both", "but", "by", "can't", "cannot", "could", 
      "couldn't", "did", "didn't", "do", "does", "doesn't", "doing", "don't", 
      "down", "during", "each", "few", "for", "from", "further", "had", "hadn't", 
      "has", "hasn't", "have", "haven't", "having", "he", "he'd", "he'll", "he's", 
      "her", "here", "here's", "hers", "herself", "him", "himself", "his", "how", 
      "how's", "i", "i'd", "i'll", "i'm", "i've", "if", "in", "into", "is", "isn't", 
      "it", "it's", "its", "itself", "let's", "me", "more", "most", "mustn't", "my", 
      "myself", "no", "nor", "not", "of", "off", "on", "once", "only", "or", "other", 
      "ought", "our", "ours", "ourselves", "out", "over", "own", "same", "shan't", 
      "she", "she'd", "she'll", "she's", "should", "shouldn't", "so", "some", "such", 
      "than", "that", "that's", "the", "their", "theirs", "them", "themselves", 
      "then", "there", "there's", "these", "they", "they'd", "they'll", "they're", 
      "they've", "this", "those", "through", "to", "too", "under", "until", "up", 
      "very", "was", "wasn't", "we", "we'd", "we'll", "we're", "we've", "were", 
      "weren't", "what", "what's", "when", "when's", "where", "where's", "which", 
      "while", "who", "who's", "whom", "why", "why's", "with", "won't", "would", 
      "wouldn't", "you", "you'd", "you'll", "you're", "you've", "your", "yours", 
      "yourself", "yourselves"
    ));

    this.spanishStopWords = new HashSet<>(Arrays.asList(
      "a", "al", "algo", "algún", "alguna", "algunas", "alguno", "algunos", "ambos", 
      "ante", "antes", "aquel", "aquella", "aquellas", "aquello", "aquellos", "aquí", 
      "arriba", "atrás", "bajo", "bastante", "bien", "cada", "cierta", "ciertas", 
      "cierto", "ciertos", "como", "con", "contra", "cual", "cuales", "cualquier", 
      "cualquiera", "cualquieras", "cuán", "cuando", "cuanta", "cuantas", "cuanto", 
      "cuantos", "de", "del", "demasiada", "demasiadas", "demasiado", "demasiados", 
      "dentro", "desde", "donde", "dos", "durante", "e", "el", "él", "ella", "ellas", 
      "ello", "ellos", "en", "encima", "entonces", "entre", "era", "erais", "eran", 
      "eras", "eres", "es", "esa", "esas", "ese", "eso", "esos", "esta", "está", 
      "estaba", "estabais", "estaban", "estabas", "estad", "estada", "estadas", 
      "estado", "estados", "estamos", "estando", "estar", "estaremos", "estará", 
      "estarán", "estarás", "estaré", "estaréis", "estaría", "estaríais", "estaríamos", 
      "estarían", "estarías", "estas", "este", "estemos", "esto", "estos", "estoy", 
      "estuve", "estuviera", "estuvierais", "estuvieran", "estuvieras", "estuvieron", 
      "estuviese", "estuvieseis", "estuviesen", "estuvieses", "estuvimos", "estuviste", 
      "estuvisteis", "estuviéramos", "estuviésemos", "estuvo", "está", "estábamos", 
      "estáis", "están", "estás", "esté", "estéis", "estén", "estés", "excepto", 
      "fue", "fuera", "fuerais", "fueran", "fueras", "fueron", "fuese", "fueseis", 
      "fuesen", "fueses", "fui", "fuimos", "fuiste", "fuisteis", "fuéramos", 
      "fuésemos", "ha", "habéis", "había", "habíais", "habíamos", "habían", "habías", 
      "han", "has", "hasta", "hay", "haya", "hayáis", "hayamos", "hayan", "hayas", 
      "he", "hemos", "hube", "hubiera", "hubierais", "hubieran", "hubieras", 
      "hubieron", "hubiese", "hubieseis", "hubiesen", "hubieses", "hubimos", 
      "hubiste", "hubisteis", "hubiéramos", "hubiésemos", "hubo", "la", "las", 
      "le", "les", "lo", "los", "me", "mi", "mis", "mucha", "muchas", "mucho", 
      "muchos", "muy", "más", "mí", "mía", "mías", "mío", "míos", "nada", "ni", 
      "no", "nos", "nosotras", "nosotros", "nuestra", "nuestras", "nuestro", 
      "nuestros", "o", "os", "otra", "otras", "otro", "otros", "para", "pero", 
      "poca", "pocas", "poco", "pocos", "por", "porque", "primero", "puede", 
      "pueden", "puedo", "pues", "que", "quién", "quiénes", "qué", "se", "sea", 
      "seamos", "sean", "seas", "seremos", "será", "serán", "serás", "seré", 
      "seréis", "sería", "seríais", "seríamos", "serían", "serías", "seáis", 
      "si", "sido", "siendo", "sin", "sobre", "sois", "somos", "son", "soy", 
      "su", "sus", "suya", "suyas", "suyo", "suyos", "sí", "también", "tampoco", 
      "tan", "tanto", "te", "tendremos", "tendrá", "tendrán", "tendrás", "tendré", 
      "tendréis", "tendría", "tendríais", "tendríamos", "tendrían", "tendrías", 
      "tened", "tenemos", "tenga", "tengamos", "tengan", "tengas", "tengo", 
      "tengáis", "tenía", "teníais", "teníamos", "tenían", "tenías", "ti", 
      "tiene", "tienen", "tienes", "todo", "todos", "tu", "tus", "tuve", 
      "tuviera", "tuvierais", "tuvieran", "tuvieras", "tuvieron", "tuviese", 
      "tuvieseis", "tuviesen", "tuvieses", "tuvimos", "tuviste", "tuvisteis", 
      "tuviéramos", "tuviésemos", "tuvo", "tuya", "tuyas", "tuyo", "tuyos", 
      "tú", "un", "una", "uno", "unos", "usted", "ustedes", "varias", "varios", 
      "vosotras", "vosotros", "vuestra", "vuestras", "vuestro", "vuestros", 
      "y", "ya", "yo", "él", "éramos"
    ));
  }

    public String limitWords(String text, int maxWords) {
      String[] words = text.split("\\s+");
      StringBuilder limitedText = new StringBuilder();
      for (int i = 0; i < Math.min(words.length, maxWords); i++) {
        limitedText.append(words[i]).append(" ");
      }
      return limitedText.toString().trim();
    }

    public void detectStopWords() {
      // Get the appropriate stop words list based on language
      // Flexing on the ternary 
      Set<String> stopWords = (language.startsWith("e")) ? englishStopWords : spanishStopWords;

      // Split the paragraph into words with the same regex
      // as before
      String[] words = paragraph.toString().split("\\s+");
      try {
        AnsiConsole.systemInstall();


        // Check each word against the stop words list
        for (String word : words) {
          // Clean the word (remove punctuation, convert to lowercase)
          String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
          if (!cleanWord.isEmpty() && stopWords.contains(cleanWord)) {
            detectedStopWords.add(cleanWord);
          }
        }

        System.out.println(
          Ansi.ansi()
          .fg(Ansi.Color.MAGENTA).a("Stop words detected: ")        .fg(Ansi.Color.MAGENTA).a(String.join(", ", detectedStopWords))
          .reset()
        );
      } finally {
        AnsiConsole.systemUninstall();
      }
    }

    public void morosStopped() {
      if (detectedStopWords.isEmpty()){
        System.out.println("\nNo stop words removed\n");
      } else {
        System.out.println("\nRemoving stop words too\n");

        //In order to remove the stop words we need to first
        //get both operands to the same type, then 
        //filter the words in the sense to make 
        //a correct substraction of those.

        String resultText  = HCI.result.toString();

        String[] words = resultText.split("\\s+");
        StringBuilder filteredResult = new StringBuilder();

        for (String word : words) {
          String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
          if (cleanWord.isEmpty() || !detectedStopWords.contains(cleanWord)) {
            filteredResult.append(word).append(" ");
          }
        }

        // Limit number of words
        String limitedResult = limitWords(filteredResult.toString(), 300);

        HCI.result.setLength(0);
        HCI.result.append(limitedResult);

        try {
          AnsiConsole.systemInstall();

          System.out.println(
            Ansi.ansi()
            .fg(Ansi.Color.YELLOW).a("Result after removing stop words: ")
            .fg(Ansi.Color.GREEN).a(HCI.result.toString())
            .reset()
          );

        } finally {
          AnsiConsole.systemUninstall();
        }
      }
    }
  }
