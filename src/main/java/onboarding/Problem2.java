package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem2 {
    public static String solution(String cryptogram) {
        List<Character> strList = new ArrayList<>();

        char[] strCharArr = cryptogram.toCharArray();
        for (char el : strCharArr) {
            strList.add(el);
        }
        for (int i = strList.size(); i > 1; i--) {
            for (int j = strList.size() - 1; j > 0; j--) {
                if (strList.get(j) == strList.get(j - 1)) {
                    strList.remove(j - 1);
                    strList.remove(j - 1);
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for (Character character : strList) {
            result.append(character);
        }
        return result.toString();
    }

}
