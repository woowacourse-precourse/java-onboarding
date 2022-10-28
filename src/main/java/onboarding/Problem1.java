package onboarding;

import java.util.ArrayList;
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

    static int getPageLength(int page) {
        return (int) (Math.log10(page) + 1);
    }

    static List<Integer> getPageIngredients(int page) {
        int length = getPageLength(page);

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            int temp = page % 10;
            page = page / 10;
            result.add(temp);
        }

        return result;
    }

}