package onboarding;

public class Problem4 {
    public static String solution(String word) {
        
        String answer = "";

        for (int i = 0; i < word.length(); i++) {
            char original_word = word.charAt(i);
            if (original_word >= 'A' && original_word <= 'Z') {
                answer +=  (char) (155 - original_word);
            } else if (original_word >= 'a' && original_word <= 'z') {
                answer +=  (char) (219 - original_word);
            } else {
                answer += String.valueOf(original_word);
            }
        }
        return answer;
    }


}
