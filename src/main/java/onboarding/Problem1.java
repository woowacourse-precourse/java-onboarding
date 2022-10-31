package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// TODO
// 1. 책을 임의로 펼친다.
// 2, 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
// 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
// 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
// 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
// 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
class Problem1 {
    /**
     * 주어진 페이지 리스트가 비어있다면 true, 아니라면 false를 반환한다.
     *
     * @param list 주어진 페이지 리스트
     * @return 비어있다면 true, 아니라면 false
     */
    public static boolean checkSize(List<Integer> list) {
        return list.isEmpty();
    }

    /**
     * 주어진 리스트에서 페이지의 범위를 벗어나는 페이지가 있다면 true, 아니라면 false를 반환한다.
     *
     * @param list 주어진 리스트
     * @return 페이지가 있다면 true, 아니라면 false
     */
    public static boolean checkPageBound(List<Integer> list) {
        List<Integer> outOfBounds = list.stream()
                .filter(x -> x > 400 || x < 1)
                .collect(Collectors.toList());
        return !outOfBounds.isEmpty();
    }

    /**
     * 주어진 페이지 리스트가 왼쪽이 홀수, 오른쪽이 짝수가 맞는지 확인한 후 맞으면 false, 아니라면 true를 리턴합니다.
     *
     * @param pageNumber 피이지가 담긴 리스트
     * @return 왼쪽이 홀수, 오른쪽이 짝수라면 false, 아니라면 true
     */
    public static boolean checkPageOddEven(List<Integer> pageNumber) {
        int leftPage = pageNumber.get(0);
        int rightPage = pageNumber.get(1);
        return leftPage % 2 == 0 || rightPage % 2 != 0;
    }

    /**
     * 주어진 페이지 리스트에서 오른쪽에서 왼쪽을 뺀 값이 1이 아니라면 true, 1이라면 false를 반환한다.
     *
     * @param pageNumber 페이지가 담긴 리스트
     * @return 오른쪽에서 왼쪽을 뺀 값이 1이 아니라면 true, 1이라면 false
     */
    public static boolean checkPair(List<Integer> pageNumber) {
        int leftPage = pageNumber.get(0);
        int rightPage = pageNumber.get(1);
        return rightPage - leftPage != 1;
    }

    /**
     * 주어진 페이지 리스트에 문제가 있다면 false, 문제가 없다면 true를 반환한다.
     * @param list 주어진 페이지 리스트
     * @return 문제가 있다면 false, 문제가 없다면 true
     */
    public static boolean handleErrors(List<Integer> list) {
        if (checkSize(list)) {
            return false;
        }

        if (checkPageBound(list)) {
            return false;
        }

        if (checkPageOddEven(list)) {
            return false;
        }

        if (checkPair(list)) {
            return false;
        }
        return true;
    }

    /**
     * 주어진 왼쪽 페이지와 오른쪽 페이지의 각 자릿수 합을 리턴합니다.
     *
     * @param leftPage  왼쪽 페이지
     * @param rightPage 오른쪽 페이지
     * @return 왼쪽 페이지와 오른쪽 페이지의 각 자릿수를 합한 값
     */
    public static int getPageSum(int leftPage, int rightPage) {
        String combined = String.valueOf(leftPage) + rightPage;
        return Arrays.stream(Integer.valueOf(combined).toString().split(""))
                .map(Integer::valueOf)
                .mapToInt(i -> i)
                .sum();
    }

    /**
     * 주어진 왼쪽 페이지와 오른쪽 페이지의 각 자릿수 곱을 리턴합니다.
     *
     * @param leftPage  왼쪽 페이지
     * @param rightPage 오른쪽 페이지
     * @return 왼쪽 페이지와 오른쪽 페이지의 각 자릿수를 곱한 값
     */
    public static int getPageProduct(int leftPage, int rightPage) {
        String combined = String.valueOf(leftPage) + rightPage;
        return Arrays.stream(combined.split(""))
                .map(Integer::valueOf)
                .reduce(1, (a, b) -> a * b);
    }

    /**
     * 주어진 page로 점수를 산정하고, 가장 점수가 높은 점수를 반환합니다.
     *
     * @param page 페이지가 담긴 리스트
     * @return 가장 높은 점수
     */
    public static int getHigherNumber(List<Integer> page) {
        int leftPage = page.get(0);
        int rightPage = page.get(1);

        int sumOfPage = getPageSum(leftPage, rightPage);
        int productOfPage = getPageProduct(leftPage, rightPage);

        return Math.max(sumOfPage, productOfPage);
    }

    /**
     * 주어진 포비의 값과 크롱의 값을 통해 승패와 무승부를 가릅니다.
     *
     * @param pobiResult  포비의 값
     * @param crongResult 크롱의 값
     * @return 포비의 값이 클 경우 1, 크롱의 값이 클 경우 2, 값이 같을 경우 0
     */
    public static int decideWinner(int pobiResult, int crongResult) {
        if (pobiResult > crongResult) {
            return 1;
        } else if (pobiResult < crongResult) {
            return 2;
        } else {
            return 0;
        }
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!handleErrors(pobi) || !handleErrors(crong)) {
            return -1;
        }

        return answer;
    }
}
