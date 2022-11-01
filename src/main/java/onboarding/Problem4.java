package onboarding;

public class Problem4 {
    public static String solution(String word) {
        /*
         * 대문자 혹은 소문자라면 청개구리 사전대로 변환해서 결과를 구한다.
         */
        StringBuilder answer = new StringBuilder();
        int upperPivot = 'A' + 'Z'; // 대문자인 경우 변환을 위한 기준 값
        int lowerPivot = 'a' + 'z'; // 소문자인 경우 변환을 위한 기준 값

        for (int i = 0; i < word.length(); i++) {
            Character ch = word.charAt(i);
            if (isUpperAlpha(ch)) {
                answer.append(convertToFrogDict(ch, upperPivot));
            } else if (isLowerAlpha(ch)) {
                answer.append(convertToFrogDict(ch, lowerPivot));
            } else {
                answer.append(ch);
            }
        }

        return answer.toString();
    }

    public static boolean isUpperAlpha(Character ch) {
        return ch >= 'A' && ch <= 'Z';
    }

    public static boolean isLowerAlpha(Character ch) {
        return ch >= 'a' && ch <= 'z';
    }

    public static char convertToFrogDict(Character ch, int standard) {
        return (char) (standard - ch);
    }
}
