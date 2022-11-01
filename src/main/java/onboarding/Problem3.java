package onboarding;
import onboarding.solution3.*;

public class Problem3 {
    public static int solution(int number) {
        Game369 game369 = new Game369();
        int answer = Game369.checkTarget(number);
        return answer;
    }
}
