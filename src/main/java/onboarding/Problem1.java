package onboarding;


import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
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

}