package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isValidPage(pobi.get(0), pobi.get(1)) || isValidPage(crong.get(0), crong.get(1))) {
            return -1;
        }
        return compareMaxPage(comparePobiPage(pobi), compareCrongPage(crong));
    }

    // 페이지가 순서가 맞지 않을 때 예외사항
    public static boolean isValidPage(int leftPage, int rightPage) {
        boolean wrongPage = false;
        if ((leftPage + 1) != rightPage) {
            wrongPage = true;
        }
        if (leftPage == 1 || rightPage == 400) {
            wrongPage = true;
        }
        return wrongPage;
    }

    // 페이지의 합을 구하는 메소드
    public static int sumPage(int page) {
        int sum = 0;
        while (page != 0) {
            sum += page % 10;
            page /= 10;
        }
        return sum;
    }

    // 페이지의 곱을 구하는 메소드
    public static int multiplyPage(int page) {
        int multiply = 1;
        while (page != 0) {
            multiply *= page % 10;
            page /= 10;
        }
        return multiply;
    }

    // 포비의 페이지의 합과 곱 중 큰 값을 구하는 메소드
    public static int comparePobiPage(List<Integer> pobi) {
        int pobiMaxPage = 0;
        for (int i : pobi) {
            int pobiBiggerPage = Math.max(sumPage(i), multiplyPage(i));
            if (pobiBiggerPage > pobiMaxPage) {
                pobiMaxPage = pobiBiggerPage;
            }
        }
        return pobiMaxPage;
    }

    // 크롱의 페이지의 합과 곱 중 큰 값을 구하는 메소드
    public static int compareCrongPage(List<Integer> crong) {
        int crongMaxPage = 0;
        for (int i : crong) {
            int crongBiggerPage = Math.max(sumPage(i), multiplyPage(i));
            if (crongBiggerPage > crongMaxPage) {
                crongMaxPage = crongBiggerPage;
            }
        }
        return crongMaxPage;
    }

    // 포비와 크롱의 페이지를 비교하는 메소드
    public static int compareMaxPage(int pobiMaxPage, int crongMaxPage) {
        int answer = -1;
        if (pobiMaxPage > crongMaxPage) {
            answer = 1;
        }
        if (crongMaxPage > pobiMaxPage) {
            answer = 2;
        }
        if (crongMaxPage == pobiMaxPage) {
            answer = 0;
        }
        return answer;
    }
}