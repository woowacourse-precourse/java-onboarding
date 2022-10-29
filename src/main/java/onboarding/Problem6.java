package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    private static boolean[] hasDuplicatePartInNickname;
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        hasDuplicatePartInNickname = new boolean[forms.size()];
        for (int i = 0; i < forms.size(); i++) {
            findTwoLettersDuplicationNickname(forms.get(i).get(1), forms, i);
        }

        for (int i = 0; i < hasDuplicatePartInNickname.length; i++) {
            if (hasDuplicatePartInNickname[i] == true)
                result.add(forms.get(i).get(0));
        }

        Collections.sort(result); //자연정렬

        return result;
    }

    private static void findTwoLettersDuplicationNickname(String nickname, List<List<String>> forms, int startIndex) {
        boolean hasDuplicationFlag = false;

        for (int i = startIndex + 1; i < forms.size(); i++) {
            String comparedNickname = forms.get(i).get(1);
            if (containSameTwoLetters(nickname, comparedNickname)) {
                hasDuplicatePartInNickname[i] = true;
                hasDuplicationFlag = true;
            }
        }
        if (hasDuplicationFlag == true) {
            hasDuplicatePartInNickname[startIndex] = true;
        }
    }

    private static boolean containSameTwoLetters(String str1, String str2) {
        String shortStr;
        String longStr;
        if (str1.length() <= str2.length()) {
            shortStr = str1;
            longStr = str2;
        } else {
            shortStr = str2;
            longStr = str1;
        }

        for (int i = 0; i < shortStr.length() - 1; i++) {
            String splitStr = shortStr.substring(i, i + 2);
            if (longStr.contains(splitStr)) {
                return true;
            }
        }

        return false;
    }
}
