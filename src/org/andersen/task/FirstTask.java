package org.andersen.task;

import java.util.Scanner;

public class FirstTask {

    public static void intCheck(int... values) {
        if (values.length == 1 && values[0] > 7) {
            System.out.println("Привет");
            return;
        }

        for (int value : values) {
            if (value % 3 == 0) {
                System.out.print(value + " ");
            }
        }
    }

    public static void greet(String name) {
        if (name.equals("Вячеслав")) {
            System.out.println("Привет");
        } else {
            System.out.println("Нет такого имени");
        }
    }

    public static void main(String[] args) {
        System.out.println("Введите число или строку:");
        Scanner scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            int value = scanner.nextInt();
            intCheck(value);
        } else if (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            greet(name);
        }
        scanner.close();
    }
}
