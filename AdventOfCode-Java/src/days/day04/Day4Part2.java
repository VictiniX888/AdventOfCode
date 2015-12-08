package days.day04;

import lib.ReadInput;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Day4Part2 {

    public Day4Part2() {

        ReadInput readInput = new ReadInput();
        byte[] result;
        int number = 0;
        byte[] byteInput;
        MessageDigest md5 = null;
        String finalString;

        for (int i = 0; i < Long.MAX_VALUE; i++) {
            number = number + 1;
            String inputNumber = readInput.input + number;

            try {
                md5 = MessageDigest.getInstance("MD5");
            }
            catch(NoSuchAlgorithmException e) {

            }

            byteInput = inputNumber.getBytes();
            result = md5.digest(byteInput);
            finalString = DatatypeConverter.printHexBinary(result);
            if(finalString.substring(0, 6).contains("000000")) {
                System.out.println("Day 4 Part 2 answer: " + number);
                break;
            }
        }
    }
}
