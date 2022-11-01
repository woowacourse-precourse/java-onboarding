package onboarding;
import java.util.HashMap;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        HashMap<String, String>  wordDict = new HashMap<>();
        List<String> wordToList = new ArrayList<>(Arrays.asList(word.split("")));
        List<String> charList = new ArrayList<String>();
        for (String c : wordToList) {
            if (c.charAt(0) >= 'a' && c.charAt(0) <= 'z') {
                changeSmall(charList, c);
            } else if (c.charAt(0) >= 'A' && c.charAt(0) <= 'Z') {
                changeLarge(charList, c);
            } else {
                charList.add(c);
            }
        }
        answer = String.join("", charList);
        return answer;
    }
    public static void changeSmall(List<String> charList, String c) {
        if (c.charAt(0) <= 'm') {
            charList.add(Character.toString('n' + 'm' - c.charAt(0)));
        } else {
            charList.add(Character.toString('m'- (c.charAt(0) - 'n')));
        }
    }

    public static void changeLarge(List<String> charList, String c) {
        if (c.charAt(0) <= 'M') {
            charList.add(Character.toString('N'+'M' - c.charAt(0)));
        } else {
            charList.add(Character.toString('M'- (c.charAt(0) - 'N')));
        }
    }
}
