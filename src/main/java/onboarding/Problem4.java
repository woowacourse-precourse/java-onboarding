package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";
        for(int i = 0; i < word.length(); i++) {
            char letter = word.charAt(i);
            answer += String.valueOf(changeLetter(letter));
        }
        return answer;
    }

    public static char changeLetter(char letter) {
        if(letter >= 'a' && letter <= 'z') {
            return (char) ('z' - letter + 'a');
        } else if (letter >= 'A' && letter <= 'Z') {
            return (char) ('Z' - letter + 'A');
        } else {
            return letter;
        }
    }

}
