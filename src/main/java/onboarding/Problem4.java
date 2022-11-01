package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for (int i = 0; i < word.length(); i++) {
            if (!isAlphabet(word.charAt(i))){
                answer += word.charAt(i);
            }
        }
        return answer;
    }
    public static boolean isAlphabet(char letter){
        if (letter >= 'A' && letter <= 'Z' || letter >= 'a' && letter <= 'z'){
            return true;
        }
        return false;
    }

}
