package onboarding;

public class Problem4 {
    public static String solution(String word) {
        String answer;
        word = checkWord(word);
        char[] wordArray = word.toCharArray();

        for (int i = 0; i < wordArray.length; i++) {
            char c = wordArray[i];
            if (Character.isAlphabetic(c)) { //알파벳 외의 문자는 변환하지 않는다.
                if (Character.isLowerCase(c)) {
                    //알파벳 대문자는 알파벳 대문자로, 알파벳 소문자는 알파벳 소문자로 변환한다.
                    c = (char) ('z' - c + 'a');
                    wordArray[i] = c;
                } else if (Character.isUpperCase(c)) {
                    c = (char) ('Z' - c + 'A');
                    wordArray[i] = c;
                }
            }
        }
        answer = new String(wordArray);
        return answer;
    }

    public static String checkWord(String word) {
        if (word.length() < 1 || word.length() > 1_000) {
            throw new IllegalStateException("문자열의 길이는 1 이상, 1,000 이하여야 합니다.");
            //word는 길이가 1 이상 1,000이하인 문자열이다.
        } else {
            return word;
        }
    }

}
