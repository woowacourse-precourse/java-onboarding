package onboarding.problem4;

import org.w3c.dom.CDATASection;

import javax.security.auth.callback.CallbackHandler;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Dictionary {

    private Validation validation;
    private Map<Character, Character> alphabets;

    public Dictionary(String word) {
        this.validation = new Validation(word);
        this.alphabets = new ConcurrentHashMap<>();
        setting();
    }

    private void setting() {
        char startValue = 'Z';
        for (char data = 'A'; data <= 'Z'; data++) {
            alphabets.put(data, startValue--);
        }
    }

    // 로직 미구현
    public String reverseString(String word) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char data = word.charAt(i);

            // 대문자
            if (isUpperCaseLogic(result, data)) continue;

            // 소문자
            if (isLowerCaseLogic(result, data)) continue;

            if (!alphabets.containsKey(data)) {
                result.append(" ");
            }

        }
        return result.toString();
    }

    private boolean isLowerCaseLogic(StringBuilder result, char data) {
        if (Character.isLowerCase(data)) {
            char dataToUpper = Character.toUpperCase(data);
            Character reverseData = alphabets.get(dataToUpper);
            char dataToLower = Character.toLowerCase(reverseData);

            result.append(dataToLower);
            return true;
        }

        return false;
    }

    private boolean isUpperCaseLogic(StringBuilder sb, char data) {
        if (Character.isUpperCase(data)) {
            Character reverseData = alphabets.get(data);

            sb.append(reverseData);
            return true;
        }

        return false;
    }
}
