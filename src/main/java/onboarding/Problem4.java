package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer = "";

        for (char ch : word.toCharArray()) {
            answer += convertWord(ch);
        }

        return answer;
    }

    static char convertWord(char word) {
        char newWord;

        if('a' <= word && word <= 'z') {            // 소문자
            newWord = (char) ('a' + 'z' - word);
        } else if ('A' <= word && word <= 'Z') {    // 대문자
            newWord = (char) ('A' + 'Z' - word);
        } else {                                    // 알파벳 외의 문자
            newWord = word;
        }

        return newWord;
    }
}
