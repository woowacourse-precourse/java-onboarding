package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!(validatePageList(pobi) && validatePageList(crong))) {
            return -1;
        }

        Integer pobiMaxScore = maxScoreByPageList(pobi);
        Integer crongMaxScore = maxScoreByPageList(crong);

        if (pobiMaxScore > crongMaxScore) {
            return 1;
        } else if (pobiMaxScore < crongMaxScore) {
            return 2;
        }
        return 0;
    }

    private static Integer maxScoreByPageList(List<Integer> pages) {
        int max = 0;

        for (Integer page: pages) {
            max = Integer.max(sumOfEachNum(page), multiplyOfEachNum(page));
        }

        return max;
    }

    private static boolean validatePageList(List<Integer> pages) {
        if (pages.size() > 2) {
            return false;
        }

        for (Integer page: pages) {
            if (page < 1 || page > 400) {
                return false;
            }
        }

        return pages.get(1) - pages.get(0) == 1;
    }

    private static Integer sumOfEachNum(Integer num) {
        return toDigitStream(num).reduce(0, Integer::sum);
    }

    private static Integer multiplyOfEachNum(Integer num) {
        return toDigitStream(num).reduce(1, (prev, curr) -> prev * curr);
    }

    private static Stream<Integer> toDigitStream(Integer num) {
        return Arrays.stream(num.toString()
                .split("")).map(Integer::parseInt);
    }
}