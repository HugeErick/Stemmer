import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StopMoros {
  private final Set<String> englishStopWords;
  private final Set<String> spanishStopWords;
  private final StringBuilder paragraph;
  private final String language;
  private final Set<String> detectedStopWords;

  public StopMoros(StringBuilder paragraph, String language) {
    this.paragraph = paragraph;
    this.language = language.toLowerCase();
    this.detectedStopWords = new HashSet<>();

    // Initialize English stop words
    this.englishStopWords = new HashSet<>(Arrays.asList(
        "a", "an", "and", "are", "as", "at", "be", "but", "by", "for",
        "if", "in", "into", "is", "it", "no", "not", "of", "on", "or",
        "such", "that", "the", "their", "then", "there", "these",
        "they", "this", "to", "was", "will", "with"
    ));

    // Initialize Spanish stop words
    this.spanishStopWords = new HashSet<>(Arrays.asList(
        "a", "al", "algo", "algunas", "algunos", "ante", "antes", "como",
        "con", "contra", "cual", "cuando", "de", "del", "desde", "donde",
        "durante", "e", "el", "ella", "ellas", "ellos", "en", "entre",
        "era", "erais", "eran", "eras", "eres", "es", "esa", "esas",
        "ese", "eso", "esos", "esta", "estaba", "estabais", "estaban",
        "estabas", "estad", "estada", "estadas", "estado", "estados",
        "estamos", "estando", "estar", "estaremos", "estará", "estarán",
        "estarás", "estaré", "estaréis", "estaría", "estaríais",
        "estaríamos", "estarían", "estarías", "estas", "este", "estemos",
        "esto", "estos", "estoy", "estuve", "estuviera", "estuvierais",
        "estuvieran", "estuvieras", "estuvieron", "estuviese", "estuvieseis",
        "estuviesen", "estuvieses", "estuvimos", "estuviste", "estuvisteis",
        "estuviéramos", "estuviésemos", "estuvo", "está", "estábamos",
        "estáis", "están", "estás", "esté", "estéis", "estén", "estés",
        "fue", "fuera", "fuerais", "fueran", "fueras", "fueron", "fuese",
        "fueseis", "fuesen", "fueses", "fui", "fuimos", "fuiste", "fuisteis",
        "fuéramos", "fuésemos", "ha", "habéis", "había", "habíais", "habíamos",
        "habían", "habías", "han", "has", "hasta", "hay", "haya", "hayáis",
        "hayamos", "hayan", "hayas", "he", "hemos", "hube", "hubiera", "hubierais",
        "hubieran", "hubieras", "hubieron", "hubiese", "hubieseis", "hubiesen",
        "hubieses", "hubimos", "hubiste", "hubisteis", "hubiéramos", "hubiésemos",
        "hubo", "la", "las", "le", "les", "lo", "los", "me", "mi", "mis", "mucho",
        "muchos", "muy", "más", "mí", "mía", "mías", "mío", "míos", "nada", "ni",
        "no", "nos", "nosotras", "nosotros", "nuestra", "nuestras", "nuestro",
        "nuestros", "o", "os", "otra", "otras", "otro", "otros", "para", "pero",
        "poco", "por", "porque", "que", "quien", "quienes", "qué", "se", "sea",
        "seamos", "sean", "seas", "seremos", "será", "serán", "serás", "seré",
        "seréis", "sería", "seríais", "seríamos", "serían", "serías", "seáis",
        "si", "sido", "siendo", "sin", "sobre", "sois", "somos", "son", "soy",
        "su", "sus", "suya", "suyas", "suyo", "suyos", "sí", "también", "tanto",
        "te", "tendremos", "tendrá", "tendrán", "tendrás", "tendré", "tendréis",
        "tendría", "tendríais", "tendríamos", "tendrían", "tendrías", "tened",
        "tenemos", "tenga", "tengamos", "tengan", "tengas", "tengo", "tengáis",
        "tenía", "teníais", "teníamos", "tenían", "tenías", "ti", "tiene",
        "tienen", "tienes", "todo", "todos", "tu", "tus", "tuve", "tuviera",
        "tuvierais", "tuvieran", "tuvieras", "tuvieron", "tuviese", "tuvieseis",
        "tuviesen", "tuvieses", "tuvimos", "tuviste", "tuvisteis", "tuviéramos",
        "tuviésemos", "tuvo", "tuya", "tuyas", "tuyo", "tuyos", "tú", "un", "una",
        "uno", "unos", "vosotras", "vosotros", "vuestra", "vuestras", "vuestro",
        "vuestros", "y", "ya", "yo", "él", "éramos"
    ));
  }

  public void detectStopWords() {
    // Get the appropriate stop words list based on language
    Set<String> stopWords = (language.startsWith("e")) ? englishStopWords : spanishStopWords;

    // Split the paragraph into words
    String[] words = paragraph.toString().split("\\s+");

    // Check each word against the stop words list
    for (String word : words) {
      // Clean the word (remove punctuation, convert to lowercase)
      String cleanWord = word.replaceAll("[^a-zA-Z]", "").toLowerCase();
      if (!cleanWord.isEmpty() && stopWords.contains(cleanWord)) {
        detectedStopWords.add(cleanWord);
      }
    }

    System.out.println("Stop words detected: " + String.join(", ", detectedStopWords));
  }
}