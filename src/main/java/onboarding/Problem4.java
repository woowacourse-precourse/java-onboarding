package onboarding;

public class Problem4 {
    
    public static String solution(String word) {
        String answer = "";

        for (char alphabet : word.toCharArray()) {
            answer += convertWord(alphabet);
        }

        return answer;
    }

    public static char convertWord(char word) {
        if('a' <= word && word <= 'z') {
            return (char) ('a' + 'z' - word);
        }
        if ('A' <= word && word <= 'Z') {
            return (char) ('A' + 'Z' - word);
        }
        return word;
    }
}
