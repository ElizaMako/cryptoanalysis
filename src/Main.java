//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.Scanner;
//
//
//
//
//        public class Main {
//
//            public static void main(String[] args) throws IOException {
//
////                Scanner scanner = new Scanner(System.in);
////
////                String lowCaseUkrainian = "абвгґдеєжзиіїйклмнопрстуфхцчшщьюя";
////                String lowCaseEnglish = "abcdefghijklmnopqrstuvwxyz";
////                String upperCaseEnglish = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
////                String upperCaseUkrainian = "АБВГҐДЕЄЖЗИІЇЙКЛМНОПРСТУФХЦЧШЩЬЮЯ";
////                String symbols = ".,!?() ";
////                String numbers = "0123456789";
////                String alphabet = lowCaseUkrainian + upperCaseUkrainian + upperCaseEnglish + lowCaseEnglish +symbols + numbers;
////
////                System.out.println("Введіть шлях до файлу або натисніть Enter, щоб використати файл за замовчуванням");
////                String filePath = scanner.nextLine();
////
////                if (filePath.isEmpty()) {
////                    filePath = "src/DefaultFile";
////                }
////
////                System.out.println("Введіть шлях для збереження зашифрованого файлу або натисніть Enter, щоб використати шлях за замовчуванням");
////                String outputFilePath = scanner.nextLine();
////
////                if (outputFilePath.isEmpty()) {
////                    outputFilePath = "src/DefaultFile2";
////                }
////
////
////                System.out.println("Введіть 1, якщо файл треба зашифрувати. Введіть 2, якщо файл треба розшифрувати");
////                int action = scanner.nextInt();
////                scanner.nextLine();
////
////
////                int key = 0;
////                if (action == 1) {
////                    System.out.println("Введіть ключ для шифрування");
////                    key = scanner.nextInt();
////                } else if (action == 2) {
////                    System.out.println("Введіть ключ для розшифровування або натисніть Enter, щоб використати brute force");
////                    String keyInput = scanner.nextLine();
////                    if (!keyInput.isEmpty()) {
////                        key = Integer.parseInt(keyInput);
////                    }
////                }
//
//
//                FileReader inputStream = null;
//                FileWriter outputStream = null;
//
//                try {
//                    inputStream = new FileReader("src/DefaultFile");
//                    outputStream = new FileWriter("src/DefaultFile2");
//
//                    StringBuilder text = new StringBuilder();
//
//                    int c;
//                    while ((c = inputStream.read()) != -1) {
//                        text.append((char) c);
//                        // outputStream.write(c);
//                        // System.out.print(Character.toChars(c));
//                    }
//
//                    String fileContent = text.toString();
//                    String resultText = "";
//
//                    if (action == 1) {
//                        resultText = encryptedByCaesar(fileContent, key, alphabet);
//                        System.out.println("Зашифрований текст:\n" + resultText);
//                    } else if (action == 2 && key !=0) {
//                        resultText = decryptedByCaesar(fileContent, key, alphabet);
//                        System.out.println("Розшифрований текст:\n" + resultText);
//                    } else if (action == 2) {
//                        System.out.println("Текст, розшифрований brute force:");
//                        bruteForceCaesar(fileContent, alphabet);
//                        return;
//
//                    }
//
//                    outputStream.write(resultText);
//
//
//
//                } catch (IOException e) {
//
//                    System.err.println("Виникла помилка під час читання або запису файлу" + e.getMessage());
//
//
//                } finally {
//                    try {
//                        if (inputStream != null) {
//                            inputStream.close();
//                        }
//                        if (outputStream != null) {
//                            outputStream.close();
//                        }
//                    } catch (IOException e) {
//                        System.err.println("Виникла помилка під час закриття файлу" + e.getMessage());
//                    }
//                }
//            }
//            public static String encryptedByCaesar(String text, int key, String alphabet) {
//                StringBuilder encryptedText = new StringBuilder();
//
//                for (int i = 0; i < text.length(); i++) {
//                    char currentChar = text.charAt(i);
//                    int index = alphabet.indexOf(currentChar);
//
//                    if (index == -1) {
//                        encryptedText.append(currentChar);
//                    } else {
//                        int newIndex = (index + key) % alphabet.length();
//                        encryptedText.append(alphabet.charAt(newIndex));
//                    }
//
//                }
//                return encryptedText.toString();
//            }
//
//            public static String decryptedByCaesar(String text, int key, String alphabet) {
//                return encryptedByCaesar(text, alphabet.length() - key, alphabet);
//            }
//
//            public static void bruteForceCaesar(String encryptedText, String alphabet) {
//                for (int shift = 0; shift < alphabet.length(); shift++) {
//                    StringBuilder decrypted = new StringBuilder();
//                    for (int i = 0; i < encryptedText.length(); i++) {
//                        char currentChar = encryptedText.charAt(i);
//                        int index = alphabet.indexOf(currentChar);
//                        if (index == -1) {
//                            decrypted.append(currentChar);
//                        } else {
//                            int newIndex = (index - shift + alphabet.length() % alphabet.length());
//                            decrypted.append(alphabet.charAt(newIndex));
//                        }
//                    }
//
//                    System.out.println("Shift " + shift + ": " + decrypted.toString());
//                }
//            }
//
//        }
