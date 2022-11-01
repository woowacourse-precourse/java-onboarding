package onboarding;

public class Problem4 {
    public static String solution(String word) {
        //String answer = "";
        int upper = 'A' + 'Z';
        int lower = 'a' + 'z';

        char[] cArr = word.toCharArray();

        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] >= 'a' && cArr[i] <= 'z') {
                cArr[i] = (char) (lower - cArr[i]);
            } else if (cArr[i] >= 'A' && cArr[i] <= 'Z') {
                cArr[i] = (char) (upper - cArr[i]);
            }
        }

        return String.valueOf(cArr);
    }


}