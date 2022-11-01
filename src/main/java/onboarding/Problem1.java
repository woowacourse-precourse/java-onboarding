package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }


    private static int pageAddition(int number) {
        int result = 0;

        while (number > 0) {
            result += number % 10;
            number /= 10;
        }

        return result;
    }


    private static int pageMultiply(int number) {
        int result = 1;

        while (number > 0) {
            result *= number % 10;
            number /= 10;
        }

        return result;
    }


    private static int findMaxResult(List<Integer> pages) {
        List<Integer> results = List.of(pageAddition(pages.get(0)),
                pageMultiply(pages.get(0)),
                pageAddition(pages.get(1)),
                pageMultiply(pages.get(1)));

        return results.stream().max(Integer::compare).orElse(-1);
    }

    
    private static int winner(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        } else if (pobi < crong) {
            return 2;
        } else {
            return 0;
        }
    }
}