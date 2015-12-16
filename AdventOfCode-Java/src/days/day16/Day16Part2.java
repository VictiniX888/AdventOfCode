package days.day16;

import lib.ReadInput;

public class Day16Part2 {

    public Day16Part2() {

        ReadInput readInput = new ReadInput();
        String[] input = readInput.input.split(";");

        for (int i = 0; i < input.length; i++) {
            String[] splitInput = input[i].split(" ");

            boolean a = findAunt(3, splitInput);
            boolean b = findAunt(5, splitInput);
            boolean c = findAunt(7, splitInput);
            if(a && b && c) {
                System.out.println(i + 1);
                break;
            }
        }
    }

    public boolean findAunt(int i, String[] input) {

        if(i < input.length - 1) {
            if (input[i - 1].equals("children:") && input[i].equals("3,")) {
                return true;
            }
            else if (input[i - 1].equals("cats:") && Integer.parseInt(input[i].substring(0, input[i].length() - 1)) > 7) {
                return true;
            }
            else if (input[i - 1].equals("samoyeds:") && input[i].equals("2,")) {
                return true;
            }
            else if (input[i - 1].equals("pomeranians:") && Integer.parseInt(input[i].substring(0, input[i].length() - 1)) < 3) {
                return true;
            }
            else if (input[i - 1].equals("akitas:") && input[i].equals("0,")) {
                return true;
            }
            else if (input[i - 1].equals("vizslas:") && input[i].equals("0,")) {
                return true;
            }
            else if (input[i - 1].equals("goldfish:") && Integer.parseInt(input[i].substring(0, input[i].length() - 1)) < 5) {
                return true;
            }
            else if (input[i - 1].equals("trees:") && Integer.parseInt(input[i].substring(0, input[i].length() - 1)) > 3) {
                return true;
            }
            else if (input[i - 1].equals("cars:") && input[i].equals("2,")) {
                return true;
            }
            else if (input[i - 1].equals("perfumes:") && input[i].equals("1,")) {
                return true;
            }
            else {
                return false;
            }
        }
        else {
            if (input[i - 1].equals("children:") && input[i].equals("3")) {
                return true;
            }
            else if (input[i - 1].equals("cats:") && Integer.parseInt(input[i]) > 7) {
                return true;
            }
            else if (input[i - 1].equals("samoyeds:") && input[i].equals("2")) {
                return true;
            }
            else if (input[i - 1].equals("pomeranians:") && Integer.parseInt(input[i]) < 3) {
                return true;
            }
            else if (input[i - 1].equals("akitas:") && input[i].equals("0")) {
                return true;
            }
            else if (input[i - 1].equals("vizslas:") && input[i].equals("0")) {
                return true;
            }
            else if (input[i - 1].equals("goldfish:") && Integer.parseInt(input[i]) < 5) {
                return true;
            }
            else if (input[i - 1].equals("trees:") && Integer.parseInt(input[i]) > 3) {
                return true;
            }
            else if (input[i - 1].equals("cars:") && input[i].equals("2")) {
                return true;
            }
            else if (input[i - 1].equals("perfumes:") && input[i].equals("1")) {
                return true;
            }
            else {
                return false;
            }
        }
    }
}
