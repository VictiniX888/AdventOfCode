package days.day19;

import lib.ReadInput;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Day19Part2 {

    public Day19Part2() {

        ReadInput readInput = new ReadInput();
        String[] replacements = readInput.input.split(";");
        String input = "ORnPBPMgArCaCaCaSiThCaCaSiThCaCaPBSiRnFArRnFArCaCaSiThCaCaSiThCaCaCaCaCaCaSiRnFYFArSiRnMgArCaSiRnPTiTiBFYPBFArSiRnCaSiRnTiRnFArSiAlArPTiBPTiRnCaSiAlArCaPTiTiBPMgYFArPTiRnFArSiRnCaCaFArRnCaFArCaSiRnSiRnMgArFYCaSiRnMgArCaCaSiThPRnFArPBCaSiRnMgArCaCaSiThCaSiRnTiMgArFArSiThSiThCaCaSiRnMgArCaCaSiRnFArTiBPTiRnCaSiAlArCaPTiRnFArPBPBCaCaSiThCaPBSiThPRnFArSiThCaSiThCaSiThCaPTiBSiRnFYFArCaCaPRnFArPBCaCaPBSiRnTiRnFArCaPRnFArSiRnCaCaCaSiThCaRnCaFArYCaSiRnFArBCaCaCaSiThFArPBFArCaSiRnFArRnCaCaCaFArSiRnFArTiRnPMgArF";
        Map<String, String> rep = new HashMap<>();
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < replacements.length; i++) {
            String[] splitRep = replacements[i].split(" ");
            rep.put(splitRep[2], splitRep[0]);
        }

        Set<String> repSet = rep.keySet();
        String[] repArr = repSet.toArray(new String[repSet.size()]);

        String newInput = input;
        int steps = 0;
        int count = 0;
        for (int q = 0; q < Integer.MAX_VALUE; q++) {
            everything:
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                for (int l = 0; l < Integer.MAX_VALUE; l++) {
                    int h = newInput.length();
                    for (int j = 0; j < 100; j++) {
                        int k = ThreadLocalRandom.current().nextInt(0, repArr.length);
                        if (newInput.equals("e")) {
                            break everything;
                        } else if (newInput.contains(repArr[k])) {
                            newInput = newInput.replaceFirst(repArr[k], rep.get(repArr[k]));
                            steps++;
                            count = 0;
                            break;
                        }
                    }
                    if (newInput.length() == h) {
                        count++;
                    }
                    if (count >= 10) {
                        newInput = input;
                        steps = 0;
                        count = 0;
                        break;
                    }
                }
            }

            if (steps < shortest) {
                shortest = steps;
                System.out.println(shortest);
            }
        }
    }
}