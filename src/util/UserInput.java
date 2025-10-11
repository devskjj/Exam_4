package util;

import java.util.Scanner;

public class UserInput {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getStrInput() {
        String input;
        while (true) {
            try {
                input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.print("Строка не может быть пустой. Попробуйте снова: ");
                    continue;
                }
                return input.toLowerCase();
            } catch (Exception e) {
                System.out.print("Ошибка при вводе. Попробуйте снова: ");
            }
        }
    }

    public static int getIntInput(int min, int max) {
        while (true) {
            try {
                String input = scanner.nextLine().strip();
                int number = Integer.parseInt(input);
                if (number >= min && max >= number) {
                    return number;
                } else {
                    System.out.printf("Число должно быть от %d до %d. Попробуйте снова:", min, max);
                }
            } catch (NumberFormatException e) {
                System.out.print("Нужно ввести целое число. Попробуйте снова: ");
            } catch (Exception e) {
                System.out.print("Ошибка ввода. Попробуйте снова: ");
            }
        }
    }
}
