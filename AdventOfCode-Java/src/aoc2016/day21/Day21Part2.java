package aoc2016.day21;

import java.util.Scanner;

public class Day21Part2 {

    private static final String PASSWORD = "fbgdceah";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        String password = PASSWORD;
        for (int i = splitInput.length - 1; i >= 0; i--) {
            String[] sSplit = splitInput[i].split(" ");
            if(sSplit[0].equals("swap")) {
                if(sSplit[1].equals("position")) {
                    password = swapPosition(password, Integer.parseInt(sSplit[2]), Integer.parseInt(sSplit[5]));
                }
                else {
                    password = swapLetter(password, sSplit[2].charAt(0), sSplit[5].charAt(0));
                }
            }
            else if(sSplit[0].equals("rotate")) {
                if(sSplit[1].equals("left")) {
                    password = rotateLeft(password, Integer.parseInt(sSplit[2]));
                }
                else if(sSplit[1].equals("right")) {
                    password = rotateRight(password, Integer.parseInt(sSplit[2]));
                }
                else {
                    password = rotatePosition(password, sSplit[6].charAt(0));
                }
            }
            else if(sSplit[0].equals("reverse")) {
                password = reverse(password, Integer.parseInt(sSplit[2]), Integer.parseInt(sSplit[4]));
            }
            else {
                password = move(password, Integer.parseInt(sSplit[2]), Integer.parseInt(sSplit[5]));
            }
        }

        System.out.println(password);
    }

    private static String swapPosition(String password, int posX, int posY) {

        char x = password.charAt(posX);
        char y = password.charAt(posY);
        password = password.substring(0, posY) + x + password.substring(posY+1);
        password = password.substring(0, posX) + y + password.substring(posX+1);

        return password;
    }

    private static String swapLetter(String password, char x, char y) {

        char[] chars = password.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == x) {
                chars[i] = y;
            }
            else if(chars[i] == y) {
                chars[i] = x;
            }
        }

        return new String(chars);
    }

    private static String rotateLeft(String password, int steps) {

        return password.substring(password.length() - (steps % password.length())) + password.substring(0, password.length() - (steps % password.length()));
    }

    private static String rotateRight(String password, int steps) {

        return password.substring(steps % password.length()) + password.substring(0, steps % password.length());
    }

    private static String rotatePosition(String password, char c) {

        for (int i = 0; i < password.length(); i++) {
            String newPassword;

            if(i < 4) {
                newPassword = rotateRight(password, 1 + i);
            }
            else {
                newPassword = rotateRight(password, 2 + i);
            }

            int index = newPassword.indexOf(c);

            if(index >= 4 && password.equals(rotateLeft(newPassword, 2 + index))) {
                password = newPassword;
                break;
            }
            else if(index < 4 && password.equals(rotateLeft(newPassword, 1 + index))) {
                password = newPassword;
                break;
            }
        }

        return password;
    }

    private static String reverse(String password, int posX, int posY) {

        char[] chars = password.substring(posX, posY+1).toCharArray();
        char[] output = chars.clone();

        for (int i = 0; i < output.length; i++) {
            output[i] = chars[chars.length - i - 1];
        }

        return password.substring(0, posX) + new String(output) + password.substring(posY + 1);
    }

    private static String move(String password, int posX, int posY) {

        char c = password.charAt(posY);
        password = password.substring(0, posY) + password.substring(posY + 1);
        password = password.substring(0, posX) + c + password.substring(posX);

        return password;
    }
}
