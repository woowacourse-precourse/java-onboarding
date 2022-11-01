package onboarding;

import java.util.List;

class Problem1 {

    private static final int MIN_PAGE_NUM = 1;
    private static final int MAX_PAGE_NUM = 400;
    private static final int FIXED_SIZE = 2;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean validateWrongPageOrder(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(0).intValue() + 1 != pobi.get(1).intValue()
            || crong.get(0).intValue() + 1 != crong.get(1).intValue();
    }

    private static void validateMemberSize(int POBISIZE, int CRONGSIZE) {
        if (POBISIZE != FIXED_SIZE || CRONGSIZE != FIXED_SIZE) {
            throw new IllegalArgumentException("pobi와 crong의 길이는 2여야 합니다");
        }
    }
    private static boolean validatePageNum(List<Integer> member) {
        for (Integer pageNum : member) {
            if (pageNum < MIN_PAGE_NUM || pageNum > MAX_PAGE_NUM) {
                return false;
            }
        }
        return true;
    }
}