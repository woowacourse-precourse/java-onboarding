package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "";
        answer += cryptogram.charAt(0);

        boolean duplicated = false;
        for(int i=1; i<cryptogram.length(); i++) {

            char cryptoNowChar = cryptogram.charAt(i);

            int answerLen = answer.length();
            char answerLastChar = answer.charAt(answerLen-1);

            if (cryptoNowChar == answerLastChar)
                duplicated = true;

            if(cryptoNowChar != answerLastChar && duplicated == false)
                answer += cryptoNowChar;

            if(cryptoNowChar != answerLastChar && duplicated == true) {
                answer = answer.substring(0, answerLen-1);
                duplicated = false;
                i -= 1;
            }
        }
        if(duplicated) {
            int answerLen = answer.length();
            answer = answer.substring(0, answerLen-1);
            duplicated = false;
        }

        return answer;
    }
}
