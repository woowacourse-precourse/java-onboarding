package onboarding;

public class Problem4 {
    public static char upperChange(char word) {
        char reversed;
        reversed = (char) (155 - word);
        return reversed;
    }
    public static char lowerChange(char word) {
        char reversed;
        reversed = (char) (219 - word);
        return reversed;
    }

    public static char changeWord(char word) {
        if (!((word >= 65 && word <= 97) || (word >= 97 && word <= 122))) {
            return word;
        }

        if (word >= 65 && word <= 97) {
            return upperChange(word);
        }
        return lowerChange(word);
    }


    public static String solution(String word) {
        String answer = "";
        char origin;
        char reversed;
        for (int i = 0; i < word.length(); i++) {
            origin = word.charAt(i);
            answer = answer + changeWord(origin);
        }
        return answer;
    }
}
