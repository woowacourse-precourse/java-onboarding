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
    private static int countAnswer(int answer, String numStr) {
        for(int j = 0; j< numStr.length(); j++){
            if((numStr.charAt(j) == '3')||(numStr.charAt(j) == '6')||(numStr.charAt(j) == '9')){
                answer += 1;
            }
        }
        return answer;
    }
}
