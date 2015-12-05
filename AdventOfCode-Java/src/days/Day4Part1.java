package days;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Day4Part1 {

    public Day4Part1() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.next();

        byte[] result;
        int number = 0;
        byte[] byteInput;
        MessageDigest md5 = null;
        String finalString;

        for (int i = 0; i < Long.MAX_VALUE; i++) {
            number = number + 1;
            String inputNumber = input + number;

            try {
                md5 = MessageDigest.getInstance("MD5");
            }
            catch(NoSuchAlgorithmException e) {

            }

            byteInput = inputNumber.getBytes();
            result = md5.digest(byteInput);
            finalString = DatatypeConverter.printHexBinary(result);
            if(finalString.substring(0, 5).contains("00000")) {
                System.out.println("Day 4 Part 1 answer: " + number);
                break;
            }
        }
    }
}
