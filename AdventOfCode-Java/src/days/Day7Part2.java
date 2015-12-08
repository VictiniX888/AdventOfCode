package days;

import lib.ReadInput;

import java.util.HashMap;
import java.util.Map;

public class Day7Part2 {

    public Day7Part2() {

        ReadInput readInput = new ReadInput();

        Map<String, Integer> map = new HashMap<>();
        String[] splitInput = readInput.input.split(";");

        map.put("a", null);
        putMap(splitInput, map);

        int override = map.get("a");
        for (String key : map.keySet()) {
            map.replace(key, null);
        }
        map.putIfAbsent("b", override);
        putMap(splitInput, map);

        System.out.println(map.get("a"));
    }

    public void putMap(String[] input, Map<String, Integer> map) {

        while(map.containsValue(null)) {
            for (int i = 0; i < input.length; i++) {
                String[] split = input[i].split(" ");

                if(split.length == 3) { // If the input is x -> y
                    if(isInteger(split[0])) {
                        map.putIfAbsent(split[2], Integer.parseInt(split[0]));
                    }
                    else if(map.get(split[0]) != null) {
                        map.putIfAbsent(split[2], map.get(split[0]));
                    }
                    else {
                        map.putIfAbsent(split[2], null);
                    }
                }
                else if(split.length == 4) { // If the input is NOT
                    if(map.get(split[1]) != null) {
                        map.putIfAbsent(split[3], ~map.get(split[1]));
                    }
                    else {
                        map.putIfAbsent(split[3], null);
                    }
                }
                else if(split.length == 5) { // If the input is AND, OR, LSHIFT, RSHIFT
                    if(split[1].equals("AND")) { // If the input is AND
                        if(map.get(split[2]) != null) {
                            if(isInteger(split[0])) {
                                map.putIfAbsent(split[4], Integer.parseInt(split[0]) & map.get(split[2]));
                            }
                            else if(map.get(split[0]) != null) {
                                map.putIfAbsent(split[4], map.get(split[0]) & map.get(split[2]));
                            }
                            else {
                                map.putIfAbsent(split[4], null);
                            }
                        }
                        else {
                            map.putIfAbsent(split[4], null);
                        }
                    }
                    else if(split[1].equals("OR")) { //If the input is OR
                        if(map.get(split[0]) != null && map.get(split[2]) != null) {
                            map.putIfAbsent(split[4], map.get(split[0]) | map.get(split[2]));
                        }
                        else {
                            map.putIfAbsent(split[4], null);
                        }
                    }
                    else if(split[1].equals("LSHIFT")) { // If the input is LSHIFT
                        if(map.get(split[0]) != null) {
                            map.putIfAbsent(split[4], map.get(split[0]) << Integer.parseInt(split[2]));
                        }
                        else {
                            map.putIfAbsent(split[4], null);
                        }
                    }
                    else if(split[1].equals("RSHIFT")) { // If the input is RSHIFT
                        if(map.get(split[0]) != null) {
                            map.putIfAbsent(split[4], map.get(split[0]) >> Integer.parseInt(split[2]));
                        }
                        else {
                            map.putIfAbsent(split[4], null);
                        }
                    }
                }
            }
        }
    }

    public boolean isInteger(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }
}
