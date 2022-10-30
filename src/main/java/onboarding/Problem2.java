package onboarding;

/*
1. 중복 문자 체크
2. 중복 문자 제거
 */

public class Problem2 {

    private static boolean isDuplication(String word) {
        for (int i = 1; i < word.length(); i ++) {
            if (word.charAt(i - 1) == word.charAt(i))
                return true;
        }
        return false;
    }

    private static String getRemoveDuplication(String word) {
        if (!isDuplication(word))
            return word;
        int k = 0;
        char[] element = word.toCharArray();
        for (int i = 0; i < word.length() - 1; i ++) {
            if (word.charAt(i) != word.charAt(i + 1)) {
                element[k++] = word.charAt(i);
            }
            if (word.charAt(i) == word.charAt(i + 1)) {
                while (i + 1 < word.length() && word.charAt(i) == word.charAt(i + 1)) {
                    i++;
                }
            }
        }
        if (word.charAt(word.length() - 2) != word.charAt(word.length() - 1)) {
            element[k++] = word.charAt(word.length() - 1);
        }
        word = new String(element).substring(0, k);
        return getRemoveDuplication(word);
    }

    public static String solution(String cryptogram) {
        String answer = getRemoveDuplication(cryptogram);
        return answer;
    }
}
