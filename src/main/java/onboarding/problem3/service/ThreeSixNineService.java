package onboarding.problem3.service;

import onboarding.problem3.validation.ThreeSixNineValidator;

public class ThreeSixNineService {
    public static int playThreeSixNine(int number) {
        ThreeSixNineValidator.validate(number);
        return countTotalClap(number);
    }

    private static int countTotalClap(int target) {
        int totalClap = 0;
        for (int number = 1; number <= target; number++) {
            totalClap += clap(number);
        }
        return totalClap;
    }

    private static int clap(Integer target) {
        String countString = target.toString();
        return countString.length() - getLengthWithoutThreeSixNine(countString);
    }

    private static int getLengthWithoutThreeSixNine(String target) {
        return target
                .replace("3", "")
                .replace("6", "")
                .replace("9", "")
                .length();
    }
}
