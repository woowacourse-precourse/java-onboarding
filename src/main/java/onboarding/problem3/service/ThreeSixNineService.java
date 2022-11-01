package onboarding.problem3.service;

import onboarding.problem3.validation.ThreeSixNineValidator;
import onboarding.problem3.vo.Number;

/**
 * 배달이의 369 게임 진행과 관련된 비즈니스 로직을 진행하는 서비스 레이어 클래스입니다.
 * @author BackFoxx
 */
public class ThreeSixNineService {
    /**
     * 1부터 인자로 주어진 숫자만큼 숫자를 하나씩 올리면서,
     * 숫자에 포함된 3, 6, 9의 개수만큼 손뼉을 친 후 총 손뼉 친 횟수를 반환하는 메소드입니다.
     * @param number 해당 값에 대해 1부터 number 까지 게임을 진행합니다.
     * @return 총 손뼉 친 횟수를 반환합니다.
     */
    public static int playThreeSixNine(int number) {
        ThreeSixNineValidator.validate(number);
        return countTotalClap(number);
    }

    /**
     * 1부터 target 값까지 손뼉 친 총 횟수를 계산해 반환합니다.
     * @param target 1부터 target 까지 숫자를 하나씩 올리며 게임을 진행합니다.
     * @return 총 손뼉 친 횟수를 반환합니다.
     */
    private static int countTotalClap(int target) {
        int totalClap = 0;
        for (int number = 1; number <= target; number++) {
            totalClap += countClap(Number.of(number));
        }
        return totalClap;
    }

    /**
     * 주어진 숫자에서 손뼉을 친 횟수, 즉 숫자 안에 있는 3, 6, 9의 개수를 계산해 반환합니다.
     * @param target 3, 6, 9의 개수를 계산할 대상입니다.
     * @return 손뼉 친 횟수, 즉 숫자 안에 있는 3, 6, 9의 개수입니다.
     */
    private static int countClap(Number target) {
        return target.getCountOfThreeSixNine();
    }
}
