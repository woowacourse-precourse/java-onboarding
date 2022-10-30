package onboarding;
import onboarding.solution3.*;

public class Problem3 {
    public static int solution(int number) {
        NumOfCount countNum = new NumOfCount();
        int answer = countNum.count369(number);
        return answer;
    }
}
