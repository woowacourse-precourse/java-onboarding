package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        boolean validatePageForPobi = validatePage(pobi);
        boolean validatePageForCrong = validatePage(crong);

        if (!validatePageForPobi || !validatePageForCrong) {
            return -1;
        }

        answer = whoWinBetween(pobi, crong);

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

    static int sumPageIngredient(List<Integer> pageIngredient) {

        return pageIngredient.stream().reduce(0, Integer::sum);
    }

    static int multiplyPageIngredient(List<Integer> pageIngredient) {

        return pageIngredient.stream().reduce(1, (a, b) -> a * b);
    }

    static int getSomeoneScore(List<Integer> person) {

        int someoneScore = Integer.MIN_VALUE;

        for (Integer page : person) {
            List<Integer> separatedPageNum = getPageIngredients(page);

            int sum = sumPageIngredient(separatedPageNum);
            int multiply = multiplyPageIngredient(separatedPageNum);

            someoneScore = Math.max(sum, multiply);
        }

        return someoneScore;
    }

    static int whoWinBetween(List<Integer> pobi, List<Integer> crong) {

        int pobiScore = getSomeoneScore(pobi);
        int crongScore = getSomeoneScore(crong);

        if (pobiScore > crongScore) {
            return 1;
        }

        if (pobiScore < crongScore) {
            return 2;
        }

        return 0;
    }
}