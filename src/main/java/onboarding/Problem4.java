package onboarding;

import java.util.ArrayList;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        return answer;
    }

    /**
     * 
     * @param isUpper 대문자 여부
     * @return {@code} ArrayList<String>} 알파벳의 역순 목록
     */
    private static ArrayList<String> getAlphabetList(boolean isUpper) {
        ArrayList<String> res = new ArrayList<>();

        int lastCharASCII = 122;

        if (isUpper) {
            lastCharASCII = 90;
        }

        for (int i = 0; i < 26; i++) {
            String alphabet = String.valueOf((char) (lastCharASCII - i));
            res.add(alphabet);
        }

        return res;
    }
}
