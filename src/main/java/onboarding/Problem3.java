package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int num = 1 ; num <= number ; num += 1) {
            answer += numOfClap(num);
        }
        return answer;
    }

}
