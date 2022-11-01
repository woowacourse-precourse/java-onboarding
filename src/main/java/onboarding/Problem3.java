package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        while(number > 0) {
            for (char ch : String.valueOf(number--).toCharArray()) {
                if(ch == '3' || ch == '6' || ch == '9') answer++;
            }
        }
        return answer;
    }
}
