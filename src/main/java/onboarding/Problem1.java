package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);

        // 입력된 페이지의 값이 예외 사향이면 -1을 리턴한다.
        if (isValidPages(pobiLeftPage, pobiRightPage) == false || isValidPages(crongLeftPage, crongRightPage) == false) {
            return -1;
        }

        int pobiScore = getMaxScore(
                List.of(sum(pobiLeftPage),
                        sum(pobiRightPage),
                        multiply(pobiLeftPage),
                        multiply(pobiRightPage)
                )
        );

        int crongScore = getMaxScore(
                List.of(sum(crongLeftPage),
                        sum(crongRightPage),
                        multiply(crongLeftPage),
                        multiply(crongRightPage)
                )
        );

        // 출력
        if (pobiScore > crongScore) {
            return 1;
        } else if (pobiScore < crongScore) {
            return 2;
        } else {
            return 0;
        }
    }


    private static boolean isValidPages(int leftPage, int rightPage) {
        // 시작 면이나 마지막 면이 나오는 예외사항 || 시작 면이나 마지막 면을 벗어나는 예외사항
        if (leftPage <= 1 || rightPage <= 2 || leftPage >= 399 || rightPage >= 400) {
            return false;
        }

        // 왼쪽 페이지가 항상 홀수이며, 오른쪽 페이지는 항상 짝수이다.
        if (leftPage % 2 == 0 || rightPage % 2 == 1) {
            return false;
        }

        // 오른쪽 페이지에서 왼쪽 페이지의 차는 1이다.
        return (rightPage - leftPage == 1);
    }

    private static int getMaxScore(List<Integer> scores) {
        // 항상 MAX 값은 존재한다. (pobi와 crong의 길이는 2이다.)
        return scores.stream()
                .mapToInt(score -> score)
                .max()
                .getAsInt();
        //.orElse(Integer.MIN_VALUE);
    }

    private static int sum(int page) {
        int ret = 0;

        while (page > 0) {
            ret += (page % 10);
            page /= 10;
        }

        return ret;
    }

    private static int multiply(int page) {
        int ret = 1;

        while (page > 0) {
            ret *= (page % 10);
            page /= 10;
        }

        return ret;
    }

}
