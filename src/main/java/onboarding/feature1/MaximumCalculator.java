package onboarding.feature1;

import java.util.ArrayList;
import java.util.List;

public class MaximumCalculator {
    // 메소드
    public static Integer getMaximum (Pages pages) {
        List<Integer> digitsOfLeftPage = getDigits(pages.getLeftPage());
        List<Integer> digitsOfRightPage = getDigits(pages.getRightPage());

        return Math.max(compareCalculations(digitsOfLeftPage), compareCalculations(digitsOfRightPage));
    }

    public static List<Integer> getDigits(Integer pageNumber) {
        List<Integer> digitsOfPage = new ArrayList<>();
        String temp = Integer.toString(pageNumber);
        for (Character character : temp.toCharArray()) {
            digitsOfPage.add(Character.getNumericValue(character));
        }
        return digitsOfPage;
    }

    public static Integer compareCalculations(List<Integer> digitsOfPage) {
        Integer addition = 0;
        Integer multiplication = 1;

        for (int i = 0; i < digitsOfPage.size(); i++) {
            addition += digitsOfPage.get(i);
        }

        for (int i = 0; i < digitsOfPage.size(); i++) {
            multiplication *= digitsOfPage.get(i);
        }

        return Math.max(addition, multiplication);
    }
}
