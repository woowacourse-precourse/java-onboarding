package onboarding;

import java.util.List;

class Problem1 {
    public static int SumPageNum(int pageNumber) {
        int ret = 0;
        char c;
        String pageNumberStr = Integer.toString(pageNumber);

        for (int i = 0; i < pageNumberStr.length(); i++) {
            c = pageNumberStr.charAt(i);
            ret += Character.getNumericValue(c);
        }

        return ret;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}