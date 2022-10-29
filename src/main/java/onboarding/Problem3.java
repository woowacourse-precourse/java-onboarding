package onboarding;

import java.util.Set;

public class Problem3 {
    private static final Set<Integer> clapNumbers = Set.of(3, 6, 9);

    private static int clapCount(int maxNumber) {
        int totalClap = 0;

        for (int number = 0; number <= maxNumber; number++) {
            totalClap += splitNumberOfDigits(number);
        }

        return totalClap;
    }
    /**
     * 숫자 number가 매개변수로 주어질 때, 1부터 number까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하도록 solution 메서드를 완성하라.
     *
     * @param number 주어지는 최대 숫자
     * @return 손뼉 횟수
     */
    public static int solution(int number) {
        return clapCount(number);
    }
}
