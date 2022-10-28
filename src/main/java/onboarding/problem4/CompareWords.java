package onboarding.problem4;

import java.util.Map;

public class CompareWords {

    PlaceCheck placeCheck = new PlaceCheck();

    public String compareSplit(Map<Character, Character> Dictionary, String word) {

        String result = "";

        for (Character split : word.toCharArray()) {

            if (SpacesCompare(split)) {
                result += ' ';
                continue;
            }

            result = placeCheck.wordCompare(Dictionary, split);
        }

        return result;
    }

    private boolean SpacesCompare(Character split) {

        if (split != ' ') {
            return false;
        }

        return true;
    }


}
