package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (!(checkPage(pobi) && checkPage(crong))) {
            return -1;
        }
        if (!(validation(pobi) && validation(crong))) {
            return -1;
        }

        return answer;
    }

    private static int sum(Integer page) {
        int sum = 0;
        String num = Integer.toString(page);

        for (int i = 0; i < num.length(); i++) {
            sum += Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return sum;
    }

    private static int mul(Integer page) {
        int mul = 1;
        String num = Integer.toString(page);

        for (int i = 0; i < num.length(); i++) {
            mul *= Integer.parseInt(String.valueOf(num.charAt(i)));
        }
        return mul;
    }


    private static boolean checkPage(List<Integer> page) {
        return page.get(1) - page.get(0) == 1;
    }

    private static boolean validation(List<Integer> page) {
        return page.get(0) != 1 && page.get(1) != 400;
    }
}