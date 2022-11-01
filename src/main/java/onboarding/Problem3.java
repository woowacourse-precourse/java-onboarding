package onboarding;

import onboarding.P3.NumberVerification;
import onboarding.P3.ThreeSixNineGamePlay;


public class Problem3 {

    public static int solution(int number) {
        NumberVerification numberVerification = new NumberVerification();
        ThreeSixNineGamePlay threeSixNineGamePlay = new ThreeSixNineGamePlay();

        if(!numberVerification.NumberCheck(number)){
            throw new IllegalArgumentException("1글자 이상 1000글자 이하로 입력 해주세요.");
        }
        return threeSixNineGamePlay.ThreeSixNine(number);
    }
}
