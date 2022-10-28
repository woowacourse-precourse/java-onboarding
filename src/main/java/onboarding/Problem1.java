package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<List<Integer>> pobiSeperateedDigits = separateDigits(pobi);
        List<List<Integer>> crongSeperatedDigits = separateDigits(crong);

        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static List<List<Integer>> separateDigits(List<Integer> pages) {
        List<List<Integer>> digitsNum = new ArrayList<>();

        for (int page : pages) {
            int [] onePage = Stream.of(String.valueOf(page).split("")).mapToInt(Integer::parseInt).toArray();
            List<Integer> al = Arrays.stream(onePage).boxed().collect(Collectors.toList());
            digitsNum.add(al);
        }

        return digitsNum;
    }

    public static int add(List<Integer> page) {
        return page.stream().mapToInt(Integer::intValue).sum();
    }

    public static int multiply(List<Integer> page) {
        int mul = 1;

        for (int num : page) {
            mul *= num;
        }

        return mul;
    }

    public static int getMax(List<Integer> cases) {
        int max = cases.stream().mapToInt(x -> x).max().getAsInt();
        return max;
    }

    public static int determinateWinner(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        }
        if (crong > pobi) {
            return 2;
        }
        return 0;
    }
}