package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    private static final Problem1 problem = new Problem1();

    public static void main(String[] args) {
        List<Integer> pobi = new ArrayList<>();
        List<Integer> crong = new ArrayList<>();
        pobi.add(97);pobi.add(98);
        crong.add(197);crong.add(198);
        System.out.println(solution(pobi, crong));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_value = 0, crong_value = 0;

        if(!problem.validation(pobi) || !problem.validation(crong)) {
            answer = -1;
            return answer;
        }

        pobi_value = problem.getValue(pobi);
        crong_value = problem.getValue(crong);

        if (pobi_value > crong_value) answer = 1;
        else if(pobi_value < crong_value) answer = 2;
        else answer = 0;

        return answer;
    }

    private int getValue(List<Integer> page) {
        int left_plus = 0, left_multi = 0,
                right_plus = 0, right_multi = 0;
        List<Integer> left_split = getSplit(page.get(0));
        List<Integer> right_split = getSplit(page.get(1));

        left_plus = getPlus(left_split);
        left_multi = getMultiply(left_split);
        right_plus = getPlus(right_split);
        right_multi = getMultiply(right_split);

        return Math.max(Math.max(left_plus, left_multi), Math.max(right_plus, right_multi));
    }

    private int getPlus(List<Integer> splited_int) {
        int plus = 0;
        for (Integer integer : splited_int) {
            plus += integer;
        }

        return plus;
    }

    private int getMultiply(List<Integer> splited_int) {
        int multi = 1;
        for (Integer integer : splited_int) {
            multi *= integer;
        }

        return multi;
    }

    private List<Integer> getSplit(int number) {
        List<Integer> result = new ArrayList<>();
        int temp = number;
        while(temp > 0) {
            result.add(temp % 10);
            temp /= 10;
        }

        return result;
    }

    private boolean validation(List<Integer> page) {
        Integer left = page.get(0),
                right = page.get(1);

        if(left + 1 != right) {
            return false;
        }

        if(left % 2 != 1 || right % 2 != 0) {
            return false;
        }

        if(left < 0 || 400 < left) {
            return false;
        }

        if(right < 0 || 400 < right) {
            return false;
        }

        return true;
    }
}