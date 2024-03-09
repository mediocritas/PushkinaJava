package org.andersen.task;

import java.util.*;

public class SecondTask {

    public static void secondTask(String bracketSequence) {
        Deque<Character> stackOfBrackets = new ArrayDeque<>();
        List<Character> openingBrackets = List.of('(', '[', '{');
        List<Character> closingBrackets = List.of(')', ']', '}');

        char[] brackets = bracketSequence.toCharArray();
        for (int i = 0; i < brackets.length; i++) {
            Character currentBracket = brackets[i];
            if (!openingBrackets.contains(currentBracket) && !closingBrackets.contains(currentBracket)) {
                System.out.print("Invalid character on the position" + (i + 1));
                return;
            }
            if (stackOfBrackets.isEmpty() && closingBrackets.contains(currentBracket)) {
                System.out.println("Brackets order is incorrect, " +
                        "the extra one is " + currentBracket +
                        " on the position " + (i + 1));
                return;
            }
            if (openingBrackets.contains(currentBracket)) {
                stackOfBrackets.add(currentBracket);
                continue;
            }
            if (closingBrackets.contains(currentBracket) &&
                    closingBrackets.indexOf(currentBracket) == openingBrackets.indexOf(stackOfBrackets.getLast())) {
                stackOfBrackets.removeLast();
            } else {
                System.out.println("Brackets order is incorrect, " +
                        "the extra closing one is " + currentBracket +
                        " on the position " + (i + 1) +
                        ", the unpaired opening one is " + stackOfBrackets.getLast());
                return;
            }
        }

        if (!stackOfBrackets.isEmpty()) {
            System.out.println("Brackets order is incorrect");
            System.out.println("The unpaired one is " + stackOfBrackets.getLast());
        } else {
            System.out.println("Brackets order is correct");
        }
    }

    public static void main(String[] args) {
        String bracketsSequence = "[((())()(())]]";
        secondTask(bracketsSequence);
    }
}
