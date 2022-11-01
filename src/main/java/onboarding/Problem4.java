package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(char letter : word.toCharArray()){
            if((65 <= letter && letter <= 90) ||
                    (97 <= letter && letter <122)){
                char c = 0;
                if (letter <= 90)
                    c = (char) (65 + 90 - letter);
                else
                    c = (char) (97 + 122 - letter);
                answer += Character.toString(c);
            }
            else
                answer += Character.toString(letter);
        }
        return answer;
    }
}
