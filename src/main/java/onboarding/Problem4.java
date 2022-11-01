package onboarding;

public class Problem4 {
    private static final String LOWER_ORDER = "abcdefghijklmnopqrstuvwxyz";
    private static final String LOWER_UNORDER = "zyxwvutsrqponmlkjihgfedcba";
    private static final String UPPER_ORDER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String UPPER_UNORDER = "ZYXWVUTSRQPONMLKJIHGFEDCBA";

    public static String solution(String word) {
        String answer = "";
        answer = checkEachCharacter(word, answer);
        return answer;
    }

    private static String appendCharacter(String answer, String appendingStr) {
        answer += appendingStr;
        return answer;
    }

    private static String convertReverseAlphabet(String str, int index) {
        if (LOWER_ORDER.contains(str)) {
            return LOWER_UNORDER.substring(index, index + 1);
        } else {
            return UPPER_UNORDER.substring(index, index + 1);
        }
    }

    private static String checkEachCharacter(String word, String answer) {
        for (int i = 0; i < word.length(); ++i) {
            // 각 문자 추출
            String str = word.substring(i, i + 1);
            int index = 0;
            // str이 소문자 알파벳 문자열 상수에 포함돼 있다면 인덱스를 반환, 없다면 -1
            index = isContainAlphabetOrOtherCharacter(str);
            if (index != -1) {
                str = convertReverseAlphabet(str, index);
            }
            answer = appendCharacter(answer, str);
        }
        return answer;
    }

    private static int isContainAlphabetOrOtherCharacter(String str) {
        int index = 0;
        if (LOWER_ORDER.contains(str)) {
            index = LOWER_ORDER.indexOf(str);
        } else if (UPPER_ORDER.contains(str)) {
            index = UPPER_ORDER.indexOf(str);
        } else {
            return -1;
        }
        return index;
    }
}
