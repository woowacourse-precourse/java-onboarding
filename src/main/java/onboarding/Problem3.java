package onboarding;

import onboarding.problem3.validation.ThreeSixNineValidator;

public class Problem3 {
    public static int solution(int number) {
        ThreeSixNineValidator.validate(number);

        int totalClap = 0;
        for (int count = 1; count <= number; count++) {
            totalClap += countThreeSixNine(count);
        }
        return totalClap;
    }

    private static int countThreeSixNine(Integer count) {
        String countString = count.toString();
        return countString.length() - countString
            .replace("3", "")
            .replace("6", "")
            .replace("9", "")
            .length();
    }
}
