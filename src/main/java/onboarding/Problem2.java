package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        String str = cryptogram;
        while (true) {
            String str_rm = same_remove(str);
            if (str_rm.equals(str)) {
                break;
            }
            str = str_rm;
        }
        return str;
    }

    public static String same_remove(String s) {
        List<Character> chars = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            int size = chars.size() - 1;
            if (chars.isEmpty()) {
                chars.add(ch);
                continue;
            }
            if (chars.get(size).equals(ch)) {
                chars.remove(size);
                continue;
            }
            chars.add(ch);

        }
        return convertCharListToString(chars);
    }

    public static String convertCharListToString(List<Character> characterList) {
        StringBuilder sb = new StringBuilder();
        for (Character ch : characterList) {
            sb.append(ch);
        }
        return sb.toString();
    }


}
