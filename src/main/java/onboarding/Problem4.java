package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String[] wordArr = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};

        String firstWord = word;

        word = word.toLowerCase();

        for (int i = 0; i < wordArr.length; i++) {
            word = word.replace(wordArr[i], wordArr[wordArr.length - i - 1].toUpperCase());
        }

        StringBuilder answer = new StringBuilder();

        for (int i=0; i < firstWord.length(); i++) {
            if (Character.isLowerCase(firstWord.charAt(i))) {
                answer.append(Character.toLowerCase(word.charAt(i)));
            }
            else answer.append(word.charAt(i));
        }

        return answer.toString();
    }
}
