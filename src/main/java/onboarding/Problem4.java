package onboarding;

public class Problem4 {
    public static int alphabetJudgement (char alphabet) {
        if (65<=alphabet&&alphabet<=90) {
            return 1;
        } else if (97<=alphabet&&122>=alphabet) {
            return 2;
        } else {
            return 0;
        }
    }

    public static String alphabetConversion(char alphabet) {
        int alphabetJudgementReturn = alphabetJudgement(alphabet);
        if (alphabetJudgementReturn==0) {
            return String.valueOf(alphabet);
        } else if (alphabetJudgementReturn==1) {
            char intToChar= (char) (155-alphabet);
            return String.valueOf(intToChar);
        } else {
            char intToChar= (char) (219-alphabet);
            return String.valueOf(intToChar);
        }
    }

    public static String solution(String word) {
        String answer = "";
        return answer;
    }
}
