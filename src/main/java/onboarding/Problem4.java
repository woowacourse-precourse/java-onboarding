package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    /**
     * 문자열 검증
     * @param word 문자열
     * @return 검증 결과 값
     */
    private static boolean validateWord(String word) {
        int lengthWord = word.length();
        return (lengthWord > 0 && lengthWord <= 1000);
    }


}
