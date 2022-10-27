package onboarding;

public class Problem2 {

    //두번 반복되는 문자 삭제
    private static StringBuffer removeRepeat(StringBuffer cryptogram) {
        for (int i = 0; i < cryptogram.length() - 1; i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                cryptogram.delete(i, i + 2);
                break;
            }
        }
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = "answer";

        StringBuffer strBCCryptogram = new StringBuffer(cryptogram);
        StringBuffer strBAnswer = new StringBuffer(answer);
        StringBuffer compareBefore = new StringBuffer(answer);

        while (true) {

            strBAnswer = removeRepeat(strBCCryptogram);
            if (compareBefore == removeRepeat(strBCCryptogram)) {
                break;
            }
            compareBefore = removeRepeat(strBCCryptogram);
            strBCCryptogram = strBAnswer;

        }

        answer = strBAnswer.toString();
        return answer;
    }
}
