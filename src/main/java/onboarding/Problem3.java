package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        answer = getAnswer(number, answer);
        return answer;
    }
    private static int getAnswer(int number, int answer) {
        for(int i = 1; i<= number; i++){
            String numStr = Integer.toString(i);
            answer = countAnswer(answer, numStr);
        }
        return answer;
    }
}
