import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    HCI hci = new HCI();

    System.out.println("Choose an option:");
    System.out.println("1. Manual Text Input");
    System.out.println("2. Process JSON Files");
    System.out.println("3. Reprocess all JSONs in processedJson directory");
    int choice = scanner.nextInt();
    scanner.nextLine(); // Consume newline

    switch (choice) {
      case 1:
      hci.performStemming();
      break;
      case 2:
      // Open a file dialog to select a JSON file
      JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
      fileChooser.setDialogTitle("Select JSON File");
      fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
      fileChooser.setAcceptAllFileFilterUsed(false);
      fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("JSON files", "json"));

      int userSelection = fileChooser.showOpenDialog(null);
      if (userSelection == JFileChooser.APPROVE_OPTION) {
        File selectedFile = fileChooser.getSelectedFile();
        if (!selectedFile.exists() || !selectedFile.isFile()) {
          System.out.println("Invalid file selected.");
          return;
        }
        if (selectedFile.getName().toLowerCase().endsWith(".json")) {
          hci.processJsonFile(selectedFile);
        } else {
          System.out.println("Selected file is not a JSON file.");
        }
      } else {
        System.out.println("No file selected. Exiting...");
      }
      break;
      case 3:
      hci.reprocessAllJsonsInDirectory();
      break;
      default:
      System.out.println("Invalid option.");
    }

    scanner.close();
  }
}
