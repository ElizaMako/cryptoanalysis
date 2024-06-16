import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BruteForce {

    public static String bruteForceCaesar(String encryptedText, String alphabet) {
        String[] commonWords = {"the", " і ", " що ", " та ", " не ", " в ", ", ", ".\n"};
        for (int shift = 0; shift < alphabet.length(); shift++) {
            StringBuilder decrypted = new StringBuilder();
            for (int i = 0; i < encryptedText.length(); i++) {
                char currentChar = encryptedText.charAt(i);
                int index = alphabet.indexOf(currentChar);
               // System.out.println(encryptedText);

                if (index == -1) {
                    decrypted.append(currentChar);
                } else {
                    int newIndex = (index - shift + alphabet.length() % alphabet.length());
                    decrypted.append(alphabet.charAt(newIndex));
                }
            }
            String decryptedText = decrypted.toString();
            for (String word : commonWords) {
                if (decryptedText.contains(word)) {
                    return decryptedText;
                }
            }
            System.out.println("Shift " + shift + ": " + decrypted.toString());
        }
        return "Не знайдено читабельного тексту";
    }
    public  static  void decryptFile(String filePath, String alphabet){
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader(filePath);
            outputStream = new FileWriter(filePath + "_DECRYPTED_BRUTE");

            StringBuilder text = new StringBuilder();

            int c;
            while ((c = inputStream.read()) != -1) {
                text.append((char) c);

            }

            String fileContent = text.toString();
            String resultText = "";

            resultText = bruteForceCaesar(fileContent, alphabet);
            System.out.println("Розшифрований текст:\n" + resultText);

            outputStream.write(resultText);

        } catch (IOException e) {

            System.err.println("Виникла помилка під час читання або запису файлу" + e.getMessage());

        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                System.err.println("Виникла помилка під час закриття файлу" + e.getMessage());
            }
        }
    }
}
