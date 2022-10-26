package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!(isValidPage(pobi) && isValidPage(crong))) {
            return -1;
        }
        return answer;
    }

    private static boolean isValidPage(List<Integer> pageList) {
        Integer first = pageList.get(0);
        Integer second = pageList.get(1);
        return (first > 1 && second < 400) &&
                (second - first == 1);
    }
}