package onboarding;

import java.util.ArrayList;
import java.util.List;

public class CharSpliter<T> {
    private List<Character> chars = new ArrayList<>();

    public List<Character> getChars(T data) {

        String strData = String.valueOf(data);

        for (int i = 0; i < strData.length(); i++)
            chars.add(strData.charAt(i));

        return chars;
    }
}
