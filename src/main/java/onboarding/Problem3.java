package onboarding;

import onboarding.pkgProblem3.service.ClapCountService;

/**
 * 369 게임을 진행하며 주어진 숫자까지 쳐야하는 박수 수를 구하는 문제
 * @author 유지웅
 */
public class Problem3 {
    public static int solution(int number) {
        ClapCountService clapCountService = new ClapCountService();
        return clapCountService.clapCount(number);
    }

}
