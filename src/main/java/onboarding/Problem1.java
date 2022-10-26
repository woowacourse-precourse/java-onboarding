package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (isExceptionCase(pobi, crong)) {
            return -1;
        }

        String pobi_str = pobi.get(0).toString() + pobi.get(1).toString();
        String crong_str = crong.get(0).toString() + crong.get(1).toString();

        int pobi_max = getPobiMax(pobi_str);
        int crong_max = getCrongMax(crong_str);

        answer = (pobi_max < crong_max) ? 2 : ((pobi_max == crong_max) ? 0 : 1);
        return answer;
    }

    private static int getCrongMax(String crong_str) {
        int crong_sum = Stream.of(crong_str.split(""))
                .mapToInt(Integer::parseInt)
                .sum();
        int crong_multi = Stream.of(crong_str.split(""))
                .mapToInt(Integer::parseInt)
                .reduce(1, (x, y) -> x * y);
        return Math.max(crong_sum, crong_multi);
    }

    private static int getPobiMax(String pobi_str) {
        int pobi_sum = Stream.of(pobi_str.split(""))
                .mapToInt(Integer::parseInt)
                .sum();
        int pobi_multi = Stream.of(pobi_str.split(""))
                .mapToInt(Integer::parseInt)
                .reduce(1, (x, y) -> x * y);
        return Math.max(pobi_sum, pobi_multi);
    }

    private static boolean isExceptionCase(List<Integer> pobi, List<Integer> crong) {
        if (pobi.get(1) - pobi.get(0) != 1) return true;
        if (crong.get(1) - crong.get(0) != 1) return true;
        if (pobi.get(0) == 1 || crong.get(1) == 400) return true;
        return false;
    }

}