package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (isValid(pobi) && isValid(crong)) {
            int Pobi = calculatePage(pobi);
            int Crong = calculatePage(crong);

            if (Pobi == Crong)
                answer = 0;
            else if (Math.max(Pobi, Crong) == Pobi)
                answer = 1;
            else
                answer = 2;
        }
        else
            answer = -1;

        return answer;
    }

    public static Boolean isValid(List<Integer> Pages) {
        if (Pages.size() != 2)
            return false;
        if (Pages.get(0) != Pages.get(1) - 1)
            return false;
        if (Pages.get(0) % 2 == 0)
            return false;
        if (Pages.get(1) % 2 == 1)
            return false;
        if (Pages.get(0) == 1 || Pages.get(1) == 400)
            return false;
        return true;
    }

    public static List<Integer> convertString(final String input) {
        List<Integer> output = new ArrayList<>();
        for (Character c : input.toCharArray()) {
            output.add(Character.getNumericValue(c));
        }
        return output;
    }

    public static Integer calculatePage(List<Integer> Pages) {
        var digits = convertString(String.valueOf(Pages));
        int sum = digits.stream().reduce(0, (x, y) -> x + y);
        int mul = digits.stream().reduce(1, (x, y) -> x * y);
        return Math.max(sum, mul);
    }
}