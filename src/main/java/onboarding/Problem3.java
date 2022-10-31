package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for(int num = 1; num <= number; num++) {
            String numStr = String.valueOf(num);

            String[] numArr = numStr.split("");
            for (String test : numArr) {
                 if(test.equals("3") || test.equals("6") || test.equals("9")){
                     answer++;
                 }
            }
        }
        return answer;
    }
}
