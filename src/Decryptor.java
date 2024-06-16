import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Decryptor {
    public static String decryptedByCaesar(String text, int key, String alphabet) {
               return Encryptor.encryptedByCaesar(text, alphabet.length() - key, alphabet);
         }

    public  static  void decryptFile(String filePath, int key, String alphabet){
        FileReader inputStream = null;
        FileWriter outputStream = null;

        try {
            inputStream = new FileReader(filePath);
            outputStream = new FileWriter(filePath + "_DECRYPTED");

            StringBuilder text = new StringBuilder();

            int c;
            while ((c = inputStream.read()) != -1) {
                text.append((char) c);

            }

            String fileContent = text.toString();
            String resultText = "";

            resultText = decryptedByCaesar(fileContent, key, alphabet);
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
