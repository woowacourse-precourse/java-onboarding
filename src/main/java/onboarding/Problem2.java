package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
        StringBuilder answer = new StringBuilder();
        List<String> answerList = removeDouble(cryptogram);

        for (String st : answerList) {
            answer.append(st);
        }

        return answer.toString();
    }

}
