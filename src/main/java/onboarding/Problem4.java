package onboarding;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem4 {
    public static String solution(String word) {

//        String answer = converter(word);
        String answer = "";
        return answer;
    }

    public static String converter(String value) {
        String result = "";
        Map<String, String> map = createDictionary();
        Set<String> alphSet = new HashSet<>();
        String alph = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";

        for (int i = 0; i < alph.length(); i++) {
            alphSet.add(String.valueOf(alph.charAt(i)));
        }



        for (int i = 0; i < value.length(); i++) {
            String letter = String.valueOf(value.charAt(i));
            if (!alphSet.contains(letter)) {
                result += letter;
            } else {
                String convertedLetter = map.get(letter);
                result += convertedLetter;
            }


        }
        return result;
    }

    public static Map<String, String> createDictionary() {
        Map<String, String> map = new HashMap<String, String>();

        String[] parentString = "A | B | C | D | E | F | G | H | I | J | K | L | M | N | O | P | Q | R | S | T | U | V | W | X | Y | Z |"
                .replace(" |", "")
                .split(" ");
        String[] childString = "Z | Y | X | W | V | U | T | S | R | Q | P | O | N | M | L | K | J | I | H | G | F | E | D | C | B | A |"
                .replace(" |", "")
                .split(" ");

        for (int i = 0; i < parentString.length; i++) {
            String parent = parentString[i];
            String child = childString[i];
            String parentLower = parent.toLowerCase();
            String childLower = child.toLowerCase();
            map.put(parent, child);
            map.put(parentLower, childLower);
            map.put(child, parent);
            map.put(childLower, parentLower);
        }

        return map;
    }

}
