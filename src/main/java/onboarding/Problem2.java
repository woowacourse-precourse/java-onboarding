package onboarding;

public class Problem2 {

    public static String solution(String cryptogram) {

        String answer = "answer";

        return answer;
    }

    //중복 문자 제거
    static String getRemoveDuplicateWord(String word) {

        StringBuffer resultWord = new StringBuffer();

        for (int i = 0; i < word.length(); i++) {

            if (i > 0 && word.charAt(i) == word.charAt(i - 1)) {
                continue;
            }
            if (i < word.length() - 1 && word.charAt(i) == word.charAt(i + 1)) {
                continue;
            }

            resultWord.append(word.charAt(i));
        }

        return resultWord.toString();
    }

}
