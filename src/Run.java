import java.util.InputMismatchException;
import java.util.Scanner;

public class Run {

    public static void run() {

        String filePath;
        boolean hasEncrypted = false;


        Scanner scanner = new Scanner(System.in);


        while (true) {
            try {
                System.out.println("Введіть 1, якщо файл треба зашифрувати. Введіть 2, якщо файл треба розшифрувати. Введіть 3 для завершення програми.");
                int action = scanner.nextInt();
                scanner.nextLine();

                //збираю в змінні всі вхідні дані користувача
                int key = 0;
                if (action == 1) {
                    hasEncrypted = true;
                    System.out.println("Введіть шлях до файлу або натисніть Enter, щоб використати файл за замовчуванням");
                    filePath = scanner.nextLine();

                    if (filePath.isEmpty()) {
                        filePath = "src/DefaultFile";
                    }
                    System.out.println("Введіть ключ для шифрування");
                    key = scanner.nextInt();

                } else if (action == 2) {
                    System.out.println("Введіть шлях до зашифрованого файлу або натисніть Enter, щоб використати шлях за замовчуванням");
                    filePath = scanner.nextLine();

                    if (filePath.isEmpty() && !hasEncrypted) {
                        filePath = "src/DefaultFile2";
                    } else if (filePath.isEmpty() && hasEncrypted) {
                        filePath = "src/DefaultFile_ENCRYPTED";
                    }

                    System.out.println("Введіть ключ для розшифровування або натисніть Enter, щоб використати brute force");
                    String keyInput = scanner.nextLine();
                    if (!keyInput.isEmpty()) {
                        key = Integer.parseInt(keyInput);
                    }

                } else if (action == 3) {
                    return;
                } else {
                    throw new IllegalArgumentException("Неправильна дія, ведіть 1 або 2");
                }

                if (action == 1) {
                    Encryptor.encryptFile(filePath, key, AllConstants.ALPHABET);

                } else if (action == 2 && key != 0) {
                    Decryptor.decryptFile(filePath, key, AllConstants.ALPHABET);
                } else if (action == 2 && key == 0) {
                    BruteForce.decryptFile(filePath, AllConstants.UKRAINIAN);
                }

            } catch (InputMismatchException e) {
                System.err.println("Введено неправильний формат даних, спробуйте ще раз");
                scanner.nextLine();
            } catch (NumberFormatException e) {
                System.err.println("Введено неправильний формат ключа, спробуйте ще раз");
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            } catch (Exception e) {
                System.err.println("Виникла непередбачена помилка: " + e.getMessage());
            }
        }
    }
}
