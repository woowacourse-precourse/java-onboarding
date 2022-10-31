package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer;
        Count369 count = new Count369(number);

        if(count.exception() == -1) {
            answer = -1;
        } else {
            answer = count.count();
        }

        return answer;
    }
}
