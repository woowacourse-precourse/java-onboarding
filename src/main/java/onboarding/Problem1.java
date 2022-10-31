package onboarding;

import java.util.List;

class Problem1 {

    /**
     * @param pobi  : pobi's page List(Integer)
     * @param crong : crong's page List(Integer)
     * @return boolean : 주어진 pobi와 crong 페이지 리스트가 valid 한가?
     */
    public static boolean validCheck(List<Integer> pobi, List<Integer> crong) {
        // pobi와 crong의 길이는 2이다. 모든 페이지에는 번호가 적혀 있다.
        if (pobi == null || pobi.size() != 2 || crong == null || crong.size() != 2) {
            return false;
        }
        // 페이지 번호는 1부터 400 사이이다.
        for (Integer page : pobi) {
            if (page == null || !(page >= 1 && page <= 400)) {
                return false;
            }
        }
        for (Integer page : crong) {
            if (page == null || !(page >= 1 && page <= 400)) {
                return false;
            }
        }
        int pobiLeftPage = pobi.get(0);
        int pobiRightPage = pobi.get(1);
        int crongLeftPage = crong.get(0);
        int crongRightPage = crong.get(1);
        // 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수이다.
        if (pobiLeftPage % 2 != 1 || pobiRightPage % 2 != 0 ||
                pobiLeftPage >= pobiRightPage || pobiRightPage - pobiLeftPage != 1) {
            return false;
        }
        if (crongLeftPage % 2 != 1 || crongRightPage % 2 != 0 ||
                crongLeftPage >= crongRightPage || crongRightPage - crongLeftPage != 1) {
            return false;
        }
        return true;
    }

    /**
     *
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
     *
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
     *
     * @param a : 자연수
     * @param b : 자연수
     * @return int : a와 b중 더 큰 수
     */
    public static int max(int a, int b) {
        return Math.max(a, b);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}