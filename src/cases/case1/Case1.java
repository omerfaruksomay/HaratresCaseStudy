package cases.case1;

import java.util.Scanner;

public class Case1 {
    public static void run(Scanner scanner) {
        System.out.println("\n--- Soru 1 ---");

        int maxCharacterCount = getMaxCharacterCount(scanner);
        String sentence = getSentence(scanner, maxCharacterCount);
        boolean caseSensitive = getCaseSensitivity(scanner);
        char targetCharacter = getTargetCharacter(scanner);

        int count = countCharacter(sentence, targetCharacter, caseSensitive);

        System.out.println(
                "'" + targetCharacter + "' karakteri "
                        + count + " defa geçmektedir."
        );

    }


    private static int getMaxCharacterCount(Scanner scanner) {
        while (true) {
            System.out.println("Maksimum karakter sayısı: ");
            String input = scanner.nextLine();

            try {
                int value = Integer.parseInt(input);
                if (value > 0) {
                    return value;
                }
            } catch (Exception ignored) {
            }

            System.out.println("Geçerli bir sayı giriniz.");
        }
    }

    private static String getSentence(Scanner scanner, int max) {
        while (true) {
            System.out.print("Cümle girin: ");
            String sentence = scanner.nextLine();

            if (sentence.length() <= max) return sentence;

            System.out.println("Limit aşıldı, tekrar giriniz.");

        }
    }

    private static boolean getCaseSensitivity(Scanner scanner) {
        while (true) {
            System.out.print("Case sensitive? (Evet/Hayır): ");
            String answer = scanner.nextLine().trim().toLowerCase();

            switch (answer) {
                case "evet":
                    return true;
                case "hayır":
                    return false;
                default:
                    System.out.println("Geçerli bir cevap giriniz.");
            }

        }
    }

    private static char getTargetCharacter(Scanner scanner) {
        while (true) {
            System.out.print("Karakter girin: ");
            String input = scanner.nextLine();

            if (!input.isEmpty()) return input.charAt(0);

            System.out.println("Boş bırakılamaz.");
        }
    }

    private static int countCharacter(String sentence, char target, boolean caseSensitive) {
        if (!caseSensitive) {
            sentence = sentence.toLowerCase();
            target = Character.toLowerCase(target);
        }
        int count = 0;

        for (char c : sentence.toCharArray()) {
            if (c == target) count++;
        }

        return count;
    }


}

