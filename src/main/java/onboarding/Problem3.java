package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer = 0;
        for(int i = 1; i < number + 1; i++) {
            String strNumber = Integer.toString(i);
            if(strNumber.contains("3") || strNumber.contains("6") || strNumber.contains("9")) {
                System.out.println(strNumber);
                answer += 1;
            }
        }
        return answer;
    }
}