package onboarding;

public class Problem4 {
    /* 기능 단위
     * 1. 소문자인지, 대문자인지 확인 (isLowerCase, isUpperCase)
     * 2. 문자를 변환하는 기능
     * */
    private static boolean isLowerCase(int n) {
        return n >= 65 && n <= 90;
    }

    private static boolean isUpperCase(int n) {
        return n >= 97 && n <= 122;
    }
    public static String solution(String word) {
        String answer = "";
        String[] wordArray = word.split("");
        for(int i=0; i < word.length(); i++) {
            char ch = word.charAt(i);
        }
        answer = String.join("", wordArray);
        System.out.println("answer: " + answer);
        return answer;
    }
}
