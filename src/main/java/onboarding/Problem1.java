package onboarding;


import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        // 1. 페이지가 연속 되었는지 확인(예외 -1)
        if(checkPage(pobi) != -1 && checkPage(crong) != -1) {

            // 2. 가장 큰 수 계산
            int pobi_max = maxNum(pobi);
            int crong_max = maxNum(crong);

            // 3. 승부 계산
            if (pobi_max > crong_max) answer = 1;
            else if(pobi_max < crong_max) answer = 2;
            else if(pobi_max == crong_max) answer = 0;

        }
        return answer;
    }

    /**
     * 페이지 번호의 연속 여부 확인
     * @param page
     * @return int
     */
    public static int checkPage(List<Integer> page) {
        int result = -1;
        if ( page.get(0) + 1 == page.get(1) ) {
            result = 1;
        }
        return result;
    }

    /**
     * 페이지의 번호의 각 자리수를 더하거나 곱해 가장 큰 수 계산
     * @param page
     * @return
     */
    public static int maxNum(List<Integer> page) {
        int page_sum = 0;
        int page_mul = 1;
        for (int x : page) {
            ArrayList<Integer> arr = new ArrayList<>();
            while (x > 0) {
                arr.add(x % 10);
                x /= 10;
            }

            for (int y : arr) {
                page_sum += y;
                page_mul *= y;
            }
        }
        int page_max = (page_sum > page_mul) ? page_sum : page_mul;
        return page_max;
    }

}