package onboarding;

import java.util.List;


class Problem1 {
    /**
     * 예외사항 처리 메서드
     * @param pages 왼쪽 페이지 번호, 오른쪽 페이지 번호 리스트
     * @return 유효한 입력 값일 경우 true
     */
    public static boolean checkPage(List<Integer> pages) {

        if (pages.size() != 2) return false;

        int left = pages.get(0);
        int right = pages.get(1);

        if ((left + 1) != right) return false;
        if (left <= 1 || right >= 400) return false;

        return true;
    }

    /**
     * 각 자리 숫자를 모두 더하는 메서드
     * @param page 펼친 페이지
     * @return 각 자리 숫자를 덧셈한 값
     */
    public static int addPage(int page) {
        int sum = 0;
        while (page > 0) {
            sum += (page % 10);
            page = page / 10;
        }
        return sum;
    }

    /**
     * 각 자리 숫자를 모두 곱하는 메서드
     * @param page 펼친 페이지
     * @return 각 자리 숫자를 곱셈한 값
     */
    public static int multiPage(int page) {
        int base = 1;
        while (page > 0) {
            int r = page % 10;
            if (r == 0) return 0;
            base = base * r;
            page = page / 10;
        }
        return base;
    }

    /**
     * 승자 출력 메서드
     * @param pobi 포비가 펼친 페이지 리스트
     * @param crong 크롱이 펼친 페이지 리스트
     * @return 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0
     */
    public static int getWinner(List<Integer> pobi, List<Integer> crong) {
        int maxPobi = 0;
        int maxCrong =0;

        for (int page : pobi) {
            maxPobi = Math.max(maxPobi, addPage(page));
            maxPobi = Math.max(maxPobi, multiPage(page));
        }

        for (int page : crong) {
            maxCrong = Math.max(maxCrong, multiPage(page));
            maxCrong = Math.max(maxCrong, multiPage(page));
        }

        if (maxPobi > maxCrong) {
            return 1;
        }

        if (maxPobi < maxCrong) {
            return 2;
        }

        return 0;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!checkPage(pobi) || !checkPage(crong)) {
            return -1;
        }
        return getWinner(pobi, crong);
    }

}