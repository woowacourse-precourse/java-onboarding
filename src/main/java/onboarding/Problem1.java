package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validatePageConsecutive(pobi) || !validatePageConsecutive(crong)) {
            return -1;
        }
        if (!validatePageRange(pobi) || !validatePageRange(crong)) {
            return -1;
        }
        if (!validatePageSequence(pobi) || !validatePageSequence(crong)) {
            return -1;
        }
        return 1;
    }

    private static boolean validatePageSequence(List<Integer> list) {
        return list.get(1) > list.get(0);
    }

    private static boolean validatePageConsecutive(List<Integer> list) {
        return list.get(1) - list.get(0) == 1;
    }

    private static boolean validatePageRange(List<Integer> list) {
        return list.get(0) > 1 ||  list.get(1) < 400;
    }

}