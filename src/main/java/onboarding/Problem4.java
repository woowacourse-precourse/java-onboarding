package onboarding;

public class Problem4 {
    public static String solution(String word) {
        char[] alphabet = word.toCharArray();   // String을 char 배열로 만듦

        for (int i = 0; i < alphabet.length; i++) { // 배열의 각 요소에 접근해서 청개구리 사전에 따라 변환
            alphabet[i] = change(alphabet[i]);
        }

        String answer = String.valueOf(alphabet);   // char 배열을 다시 String 배열로 만듦
        return answer;
    }
}
