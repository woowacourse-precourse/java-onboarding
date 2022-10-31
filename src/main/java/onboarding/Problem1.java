package onboarding;

import java.util.List;

class Problem1 {

    /**
     * @param pageList : page List(Integer)
     * @return boolean : 주어진 페이지 리스트가 valid 한가?
     */
    public static boolean validCheck(List<Integer> pageList) {
        // pobi와 crong의 길이는 2이다. 모든 페이지에는 번호가 적혀 있다.
        if (pageList == null || pageList.size() != 2) {
            return false;
        }
        // 페이지 번호는 1부터 400 사이이다.
        for (Integer page : pageList) {
            if (page == null || !(page >= 1 && page <= 400)) {
                return false;
            }
        }
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);
        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수이다.
        if (leftPage % 2 != 1 || rightPage % 2 != 0 ||
                leftPage >= rightPage || rightPage - leftPage != 1) {
            return false;
        }
        return true;
    }

    /**
     * @param number : 1과 400 사이의 자연수
     * @return int : 자연수 각 자릿수들의 합
     */
    public static int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    /**
     * @param number : 1과 400 사이의 자연수
     * @return int : 자연수 각 자릿수들의 곱
     */
    public static int getDigitProduct(int number) {
        int product = 1;
        while (number > 0) {
            product *= number % 10;
            number /= 10;
        }
        return product;
    }

    /**
     * @param a : 자연수
     * @param b : 자연수
     * @return int : a와 b중 더 큰 수
     */
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    private static int getMaxNumberFromPageList(List<Integer> pageList) {
        int leftPage = pageList.get(0);
        int rightPage = pageList.get(1);
        int leftPageMax = max(getDigitSum(leftPage), getDigitProduct(leftPage));
        int rightPageMax = max(getDigitSum(rightPage), getDigitProduct(rightPage));
        int maxNumberFromPage = max(leftPageMax, rightPageMax);
        return maxNumberFromPage;
    }

    public static int judgeWinner(int poby, int crong) {
        if (poby > crong) {
            return 1;
        } else if (poby < crong) {
            return 2;
        } else if (poby == crong) {
            return 0;
        }
        return -1;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // exception
        if (!validCheck(pobi) || !validCheck(crong)) {
            return -1;
        }
        // game logic
        int pobiMaxNumber = getMaxNumberFromPageList(pobi);
        int crongMaxNumber = getMaxNumberFromPageList(crong);
        return judgeWinner(pobiMaxNumber, crongMaxNumber);
    }
}