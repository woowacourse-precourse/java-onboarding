package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    static boolean validatePage(List<Integer> person) {

        if (person.get(0) < 1 || person.get(0) > 400) {
            return false;
        }

        if (person.get(1) < 1 || person.get(1) > 400) {
            return false;
        }

        return person.get(0) == person.get(1) - 1;
    }
}