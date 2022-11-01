package onboarding.problem4;

import java.util.Map;

public class PlaceCheck {

    public String wordCompare(Map<Character, Character> Dictionary, Character split) {

        String result = "";
        Character getMap;

        if (Character.isLowerCase(split)) {
            split = Character.toUpperCase(split);

            getMap = Dictionary.get(split);

            result += Character.toLowerCase(getMap);

        } else {

            getMap = Dictionary.get(split);

            result += getMap;
        }

        return result;
    }
}
