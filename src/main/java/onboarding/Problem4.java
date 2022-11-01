package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (char ch : word.toCharArray()) {
            answer += convertWord(ch);
        }

        return answer;
    }

    public static char convertWord(char word) {
        char newWord;

        if('a' <= word && word <= 'z') {
            newWord = (char) ('a' + 'z' - word);
        } else if ('A' <= word && word <= 'Z') {
            newWord = (char) ('A' + 'Z' - word);
        } else {
            newWord = word;
        }

        return newWord;
    }
}
