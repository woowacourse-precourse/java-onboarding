package onboarding.problem4;

import java.util.Map;

public class CompareWords {

    PlaceCheck placeCheck = new PlaceCheck();

    public String compareSplit(Map<Character, Character> Dictionary, String word) {

        StringBuilder result = new StringBuilder();

        for (Character split : word.toCharArray()) {

            if (SpacesCompare(split)) {
                result.append(' ');
                continue;
            }

            result.append(placeCheck.wordCompare(Dictionary, split));
        }

        return result.toString();
    }

    private boolean SpacesCompare(Character split) {

        if (split != ' ') {
            return false;
        }

        return true;
    }


}
