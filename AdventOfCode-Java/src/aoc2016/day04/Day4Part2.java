package aoc2016.day04;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Day4Part2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();
        String[] splitInput = input.split(";");

        String alphabets = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> alphabetMap = new HashMap<>();
        for (int i = 0; i < alphabets.length(); i++) {
            alphabetMap.put(alphabets.charAt(i), i);
        }

        for (int i = 0; i < splitInput.length; i++) {
            String alphabetInput = splitInput[i].replaceAll("-", "");
            int[] alphabetCount = new int[26];
            for (int j = 0; j < alphabetInput.length() - 10; j++) {
                alphabetCount[alphabetMap.get(alphabetInput.charAt(j))]++;
            }

            int sectorID = Integer.parseInt(alphabetInput.substring(alphabetInput.length() - 10, alphabetInput.length() - 7));
            String checksum = alphabetInput.split("\\[")[1].substring(0, 5);
            for (int j = 0; j < checksum.length(); j++) {
                int pos = 1;
                for (int k = 0; k < alphabetCount.length; k++) {
                    if(alphabetCount[alphabetMap.get(checksum.charAt(j))] < alphabetCount[k]) {pos++;}
                    else if(k < alphabetMap.get(checksum.charAt(j)) && alphabetCount[alphabetMap.get(checksum.charAt(j))] == alphabetCount[k]) {pos++;}
                }
                if(pos > 5) {
                    break;
                }
                else if(j == 4 && decipher(sectorID, splitInput[i].substring(0, splitInput[i].length() - 11)).equals("northpole object storage")) {
                    System.out.println(sectorID);
                }
            }
        }
    }

    public static String decipher(int key, String s) {

        String letters = "abcdefghijklmnopqrstuvwxyz";
        Map<Character, Integer> letterMap = new HashMap<>();
        for (int i = 0; i < letters.length(); i++) {
            letterMap.put(letters.charAt(i), i);
        }
        Map<Integer, Character> caesarMap = new HashMap<>();
        for (int i = 0; i < letters.length(); i++) {
            if(i+(key%26) > 25) {
                caesarMap.put(i, letters.charAt(i+(key%26)-26));
            }
            else {
                caesarMap.put(i, letters.charAt(i+(key%26)));
            }
        }

        String input = s.replaceAll("-", " ");
        String output = "";
        for (int i = 0; i < input.length(); i++) {
            if(input.substring(i, i+1).matches("[a-zA-Z]")) {
                int j = letterMap.get(input.charAt(i));
                char c = caesarMap.get(j);
                output = output.concat(Character.toString(c));
            }
            else {
                output = output.concat(input.substring(i, i+1));
            }
        }

        return output;
    }
}
