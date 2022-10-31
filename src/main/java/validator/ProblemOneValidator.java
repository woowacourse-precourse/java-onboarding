package validator;

import java.util.List;

public class ProblemOneValidator {

    public static int validate(List<Integer> pobi, List<Integer> crong) {
        if (isNegativeNumber(pobi) || isNegativeNumber(crong)) {
            return -1;
        }
        if (!isContinuousNumber(pobi) || !isContinuousNumber(crong)) {
            return -1;
        }
        if (!isOddEvenNumber(pobi) || !isOddEvenNumber(crong)) {
            return -1;
        }
        return 0;
    }


    private static boolean isNegativeNumber(List<Integer> list) {
        long count = list.stream().filter(i -> i < 0).count();
        return count > 0;
    }

    private static boolean isContinuousNumber(List<Integer> list) {
        return list.get(0) + 1 == list.get(1);
    }

    private static boolean isOddEvenNumber(List<Integer> list) {
        return (list.get(0) % 2 == 1) && (list.get(1) % 2 == 0);
    }
}
