package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        if (isException(pobi) || isException(crong)) {
            return answer;
        }

        return answer;
    }

    private static boolean isException(List<Integer> person) {
        int leftPage = person.get(0);
        int rightPage = person.get(1);
        int pageDifference = rightPage - leftPage;

        if (pageDifference != 1) {
            return true;
        } else if (rightPage > 400 || leftPage < 1) {
            return true;
        } else if (rightPage % 2 == 1) {
            return true;
        }

        return false;
    }
}