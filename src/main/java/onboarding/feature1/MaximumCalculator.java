package onboarding.feature1;

import java.util.ArrayList;
import java.util.List;

public class MaximumCalculator {
    // 필드
    private final List<Integer> digitsOfLeftPage;
    private final List<Integer> digitsOfRightPage;

    // 생성자
    public MaximumCalculator (PageNumber pageNumber) {
        digitsOfLeftPage = getDigits(pageNumber.getLeftPage());
        digitsOfRightPage = getDigits(pageNumber.getRightPage());
    }

    // 메소드
    public Integer getMaximum () {
        return Math.max(compareCalculations(digitsOfLeftPage), compareCalculations(digitsOfRightPage));
    }

    public List<Integer> getDigits(Integer pageNumber) {
        List<Integer> digitsOfPage = new ArrayList<>();
        String temp = Integer.toString(pageNumber);
        for (Character character : temp.toCharArray()) {
            digitsOfPage.add(Character.getNumericValue(character));
        }
        return digitsOfPage;
    }

    public Integer compareCalculations(List<Integer> digitsOfPage) {
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
