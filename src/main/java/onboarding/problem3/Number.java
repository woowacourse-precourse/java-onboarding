package onboarding.problem3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Number {
    private final static Set<String> containNumber;

    static {
        containNumber = new HashSet<>();
        containNumber.add("3");
        containNumber.add("6");
        containNumber.add("9");
    }

    public static Integer calculateContainThreeOrSizeOrNineCount(Integer number) {
        String numberString = String.valueOf(number);
        return (int) Arrays.stream(numberString.split(""))
                           .filter(containNumber::contains)
                           .count();
    }
}
