package onboarding.problem3.service;

import onboarding.problem3.validation.ThreeSixNineValidator;

/**
 * 배달이의 369 게임 진행과 관련된 비즈니스 로직을 진행하는 서비스 레이어 클래스입니다.
 * @author BackFoxx
 */
public class ThreeSixNineService {
    /**
     * 1부터 인자로 주어진 숫자만큼 숫자를 하나씩 대면서,
     * 3, 6, 9의 개수만큼 손뼉을 친 후 총 손뼉 친 횟수를 반환하는 메소드입니다.
     * @param number 해당 값에 대해 1부터 number 까지 게임을 진행합니다.
     * @return 총 손뼉 친 횟수를 반환합니다.
     */
    public static int playThreeSixNine(int number) {
        ThreeSixNineValidator.validate(number);
        return countTotalClap(number);
    }

    /**
     * 1부터 target 값까지 손뼉 친 총 횟수를 계산해 반환합니다.
     * @param target 1부터 하나씩 올리며 게임을 진행할 총 횟수입니다.
     * @return 총 손뼉 친 횟수를 반환합니다.
     */
    private static int countTotalClap(int target) {
        int totalClap = 0;
        for (int number = 1; number <= target; number++) {
            totalClap += clap(number);
        }
        return totalClap;
    }

    /**
     * 주어진 숫자에서 손뼉을 친 횟수, 즉 숫자 안에 있는 3, 6, 9의 개수를 계산해 반환합니다.
     * @param target 3, 6, 9의 개수를 계산할 대상입니다.
     * @return 손뼉 친 횟수, 즉 숫자 안에 있는 3, 6, 9의 개수입니다.
     */
    private static int clap(Integer target) {
        return getNumberLength(target) - getLengthWithoutThreeSixNine(target);
    }

    /**
     * 숫자의 총 길이를 반환합니다.
     */
    private static Integer getNumberLength(Integer target) {
        String numberString = target.toString();
        return numberString.length();
    }

    /**
     * 주어진 숫자에서 '3', '6', '9'를 제외한 길이를 반환합니다.
     * 숫자의 총 길이에서 해당 메소드의 결과값을 빼면
     * '3', '6', '9'가 들어간 개수를 계산할 수 있습니다.
     * @return '3', '6', '9'를 제외한 숫자의 길이입니다.
     */
    private static int getLengthWithoutThreeSixNine(Integer target) {
        return target.toString()
                .replace("3", "")
                .replace("6", "")
                .replace("9", "")
                .length();
    }
}
