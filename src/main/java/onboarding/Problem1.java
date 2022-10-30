package onboarding;

import java.util.List;

class Problem1 {

    // 포비와 크롱의 승부 결과를 출력하는 메소드
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isAllValid(pobi) || !isAllValid(crong)) {
            return -1;
        }

        int pobiMax = maxPageNumber(pobi);
        int crongMax = maxPageNumber(crong);

        if (pobiMax < crongMax) {
            return 2;
        }

        if (pobiMax > crongMax) {
            return 1;
        }

        if (pobiMax == crongMax) {
            return 0;
        }

        return -1;
    }

    // 매개변수의 유효성성 검증하는 메소드
    private static boolean isAllValid(List<Integer> pages) {
        if (!isSizeValid(pages)) {
            return false;
        }

        if (!isPageValid(pages)) {
            return false;
        }

        if (!isContinuous(pages)) {
            return false;
        }

        return true;
    }

    // 입력받은 페이지 수 크기가 2인지 확인하는 메소드
    private static boolean isSizeValid(List<Integer> pages) {
        return pages.size() == 2;
    }

    // 왼쪽, 오른쪽 페이지가 각각 짝수 홀수인지 검증하는 메소드
    private static boolean isPageValid(List<Integer> pages) {
        return pages.get(0) % 2 != 0 && pages.get(1) % 2 == 0;
    }

    // 왼쪽, 오른쪽 페이지가 연속되지 않는 경우를 확인하는 메소드
    private static boolean isContinuous(List<Integer> pages) {
        return pages.get(1) - pages.get(0) == 1;
    }


    // 왼쪽, 오른쪽 페이지에서 각 자리 수를 더하거나 곱해 가장 큰 수를 반환하는 메소드
    private static int maxPageNumber(List<Integer> pages) {
        int max = 0;

        for (int i = 0; i < pages.size(); i++) {
            int pageNumber = maxNumber(pages.get(i));

            if (pageNumber > max) {
                max = pageNumber;
            }
        }

        return max;
    }


    // 페이지의 각 자리 수를 더하거나 곱해 가장 큰 수를 반환하는 메소드
    private static int maxNumber(int page) {

        int sum = add(page);
        int multiplication = multiply(page);

        return Math.max(sum, multiplication);

    }

    // 페이지의 각 자리 숫자를 모두 곱하는 메소드
    private static int multiply(int page) {
        int multiplication = 1;
        String num = String.valueOf(page);

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            multiplication *= Character.getNumericValue(c);
        }

        return multiplication;
    }


    // 페이지의 각 자리 숫자를 모두 더하는 메소드
    private static int add(int page) {
        int sum =0;
        String num = String.valueOf(page);

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            sum += Character.getNumericValue(c);
        }

        return sum;
    }


}