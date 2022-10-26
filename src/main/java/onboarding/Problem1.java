package onboarding;

import java.util.List;
import java.util.stream.Collectors;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isPageSeparated(pobi) || isPageSeparated(crong) ||
            isPageFirstOrLower(pobi) || isPageFirstOrLower(crong) ||
            isPageLastOrHigher(pobi) || isPageLastOrHigher(crong)
        ) {
            return -1;
        }

        int pobiScore = getHighestScore(pobi);
        int crongScore = getHighestScore(crong);

        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        }

        return 0;
    }

    private static boolean isPageSeparated(List<Integer> pages) {
        return pages.get(1) - pages.get(0) != 1;
    }

    private static boolean isPageLastOrHigher(List<Integer> pages) {
        return 400 <= pages.get(1);
    }

    private static boolean isPageFirstOrLower(List<Integer> pages) {
        return pages.get(0) <= 1;
    }

    private static int getHighestScore(List<Integer> pages) {
        return Math.max(
            Math.max(
                add(pages.get(0)), add(pages.get(1))
            ),
            Math.max(
                multiply(pages.get(0)), multiply(pages.get(1))
            )
        );
    }

    private static Integer multiply(Integer page) {
        List<Integer> numbers = page.toString().chars().map(ch -> ch - 48).boxed().collect(Collectors.toList());
        int result = 1;
        for (Integer number : numbers) {
            result = result * number;
        }

        return result;
    }

    private static Integer add(Integer page) {
        return page.toString().chars().map(ch -> ch - 48).sum();
    }
}
