package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!checkException(pobi, crong)) return -1;
    }

    private static boolean checkException(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(0) + 1 == pobi.get(1) && crong.get(0) + 1 == crong.get(1);
    }

    private static int addEachDigit(int pageNum) {
        int answer = 0;
        String s = Integer.toString(pageNum);

        for (int i = 0; i < s.length(); i++) {
            answer += Integer.parseInt(s.substring(i, i + 1));
        }
        return answer;
    }
}