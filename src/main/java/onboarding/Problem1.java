package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pageChecks = 0;
        pageChecks += pobi.get(1) - pobi.get(0);
        pageChecks += crong.get(1) - crong.get(0);

        if (pageChecks != 2) {
            return -1;
        }

        int pobiValue = getMaximum(pobi);
        int crongValue = getMaximum(crong);

        if (pobiValue > crongValue) {
            return 1;
        } else if (pobiValue < crongValue) {
            return 2;
        }

        return 0;
    }


    /**
     * 페이지 정보를 입력받아 구할 수 있는 최대값을 반환한다.
     * @param pages
     * @return {@code int} 최대값
     */
    private static int getMaximum(List<Integer> pages) {
        int res = 0;

        for (Integer page : pages) {

            String pageNumber = String.valueOf(page);

            String[] nums = pageNumber.split("");

            int plus = 0;
            for (String n : nums) {
                plus += Integer.parseInt(n);
            }

            int times = 1;
            for (String n : nums) {
                times *= Integer.parseInt(n);
            }

            res = Math.max(plus, times);
        }

        return res;
    }
}