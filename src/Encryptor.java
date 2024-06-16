import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encryptor {

    public static String encryptedByCaesar(String text, int key, String alphabet) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            int index = alphabet.indexOf(currentChar);

            if (index == -1) {
                encryptedText.append(currentChar);
            } else {
                int newIndex = (index + key) % alphabet.length();
                encryptedText.append(alphabet.charAt(newIndex));

            }
        }
        return encryptedText.toString();
    }

    public  static  void encryptFile(String filePath, int key, String alphabet){
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader(filePath);
            outputStream = new FileWriter(filePath + "_ENCRYPTED");

            StringBuilder text = new StringBuilder();

            int c;
            while ((c = inputStream.read()) != -1) {
                text.append((char) c);

            }

            String fileContent = text.toString();
            String resultText = "";

            resultText = encryptedByCaesar(fileContent, key, alphabet);
            System.out.println("Зашифрований текст:\n" + resultText);

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
