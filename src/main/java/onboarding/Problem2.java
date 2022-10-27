package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Problem2 {
    public static String solution(String oldCryptogram) {
        if (oldCryptogram.length() < 2) {
            return oldCryptogram;
        }

        char[] previousString = oldCryptogram.toCharArray();

        // Make an empty list that will have the letters of previousString meeting the if statement below🔻
        List<Character> laterString = new ArrayList<>();

        // Start with the second letter of previousString
        for (int i = 1; i < previousString.length; i++) {
            if (previousString[i] != previousString[i - 1]) {
                laterString.add(previousString[i - 1]);
                continue;
            }
            // When adjacent elements are duplicate, increase the index
            while (i < previousString.length && previousString[i] == previousString[i - 1]) {
                i++;
            }
        }

        /*
        * Check the last letter of previousString because the index could exceed
        * the length of previousString before the if statement above🔺 inspect the last letter
        */
        if (previousString[previousString.length - 1] != previousString[previousString.length - 2]) {
            laterString.add(previousString[previousString.length - 1]);
        }

        String newCryptogram = laterString.stream()
            .map(letter -> String.valueOf(letter))
            .collect(Collectors.joining());
        if (!oldCryptogram.equals(newCryptogram)) {
            return solution(newCryptogram);
        }
        return newCryptogram;
    }
}
