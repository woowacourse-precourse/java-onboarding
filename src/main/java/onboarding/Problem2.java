package onboarding;

/*
1. 중복 문자 체크
2. 중복 문자 제거
 */

public class Problem2 {

    private static int checkOverlap(String word) {
        for (int i = 1; i < word.length(); i ++) {
            if (word.charAt(i - 1) == word.charAt(i))
                return 1;
        }
        return 0;
    }

    private static String removeOverlap(String word) {
        if (checkOverlap(word) == 0)
            return word;
        if (word.length() == 2 && checkOverlap(word) == 1)
            return "";

        int i, k = 0;
        char[] tmp = word.toCharArray();
        for (i = 1; i < word.length(); i ++) {
            if (word.charAt(i - 1) == word.charAt(i)) {
                while (i < word.length() && word.charAt(i - 1) == word.charAt(i))
                    i++;
            } else
                tmp[k++] = word.charAt(i - 1);
        }
        tmp[k++] = tmp[i - 1];
        word = new String(tmp).substring(0, k);

        return removeOverlap(word);
    }

    public static String solution(String cryptogram) {
        String answer = "";
        answer = removeOverlap(cryptogram);
        return answer;
    }
}
