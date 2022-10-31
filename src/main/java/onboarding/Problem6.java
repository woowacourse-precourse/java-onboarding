package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    /*
     * for문을 돌면서 forms에서 닉네임을 하나 뽑아.
     * 그리고 그 닉네임을 바탕으로 for문을 하나 더 돌면서 다른 닉네임들하고 비교를 해
     * 비교 => 연속으로 두글자가 겹치는지 true or false return해.
     * 두글자가 겹치는지 확인하는 함수는 substring([n], [n+1])을 통해 0부터 문자열 length - 1까지 돌면서 contains 함수를 통해 확인해.
     *
     */
    private static boolean[] hasDuplicatePartInNickname;
    public static List<String> solution(List<List<String>> forms) {
        List<String> result = new ArrayList<>();
        hasDuplicatePartInNickname = new boolean[forms.size()];
        for (int i = 0; i < forms.size(); i++) {
            String criterionNickname = forms.get(i).get(1);
            findTwoLettersDuplication(criterionNickname, forms, i);
        }

        for (int i = 0; i < hasDuplicatePartInNickname.length; i++) {
            if (hasDuplicatePartInNickname[i] == true)
                result.add(forms.get(i).get(0));
        }

        Collections.sort(result); //자연정렬

        return result;
    }

    private static void findTwoLettersDuplication(String criterionNickname, List<List<String>> forms, int startIndex) {
        boolean duplicationFlag = false;

        for (int i = startIndex + 1; i < forms.size(); i++) {
            String comparedNickname = forms.get(i).get(1);
            if (hasDuplicateTwoLetters(criterionNickname, comparedNickname)) {
                hasDuplicatePartInNickname[i] = true;
                duplicationFlag = true;
            }
        }

        if (duplicationFlag == true) {
            hasDuplicatePartInNickname[startIndex] = true;
        }
    }

    private static boolean hasDuplicateTwoLetters(String str1, String str2) {
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
