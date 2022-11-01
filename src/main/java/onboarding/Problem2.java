package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "";
        answer += cryptogram.charAt(0);

        boolean duplicated = false;
        for(int i=1; i<cryptogram.length(); i++) {

            char cryptoNowChar = cryptogram.charAt(i);
            boolean sameLastChar = isSameLastChar(cryptoNowChar, answer);

            if (sameLastChar)
                duplicated = true;

            if(!sameLastChar && !duplicated)
                answer += cryptoNowChar;

            if(!sameLastChar && duplicated) {
                answer = removeLastChar(answer);
                duplicated = false;
                i -= 1;
            }
        }
        if(duplicated) {
            answer = removeLastChar(answer);
        }

        return answer;
    }

    public static boolean isSameLastChar(char cryptoChar, String answer) {

        int answerLen = answer.length();
        char answerLastChar = answer.charAt(answerLen-1);

        return cryptoChar == answerLastChar;
    }

    public static String removeLastChar(String answer) {

        int answerLen = answer.length();
        return answer.substring(0, answerLen-1);
    }
}
