package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<List<Integer>> c1 = new ArrayList<>();
        List<List<Integer>> c2 = new ArrayList<>();
        int answer = -1;

        if (page_validator(pobi) && page_validator(crong)) {
            for (int n : pobi) c1.add(divide_number(n));
            for (int n : crong) c2.add(divide_number(n));

            int pobi_result = score_calculator(c1);
            int crong_result = score_calculator(c2);

            if (pobi_result > crong_result) answer = 1;
            else if (pobi_result < crong_result) answer = 2;
            else answer = 0;
        }

        return answer;
    }

    public static int score_calculator(List<List<Integer>> numbers) {
        int result = 0;
        for (List<Integer> number : numbers) {
            int plus_result = 0;
            int mult_result = 1;
            for (int n : number) {
                plus_result += n;
                mult_result *= n;
            }
            result = Math.max(result, Math.max(plus_result, mult_result));
        }
        return result;
    }

    public static List<Integer> divide_number(int number) {
        List<Integer> result = new ArrayList<Integer>();
        int number_length = Integer.toString(number).length();
        int n = number;

        for (int i = 1; i < number_length; i++) {
            int temp = (int) Math.round(Math.pow(10, number_length - i));
            result.add(n / temp);
            n = n % temp;
        }
        result.add(number % 10);
        return result;
    }

    public static boolean page_validator(List<Integer> numbers) {
        int n1 = numbers.get(0);
        int n2 = numbers.get(1);
        if (n1 > 0 && n1 < 400 && n2 > 0 && n2 < 400)
            if (n1 % 2 == 1 && n2 % 2 == 0)
                return Math.abs(n1 - n2) == 1;
        return false;
    }

    public static List<Integer> book_open() {
        Random r = new Random();
        List<Integer> result = new ArrayList<>();

        int i = r.nextInt(398) + 1;
        if (i % 2 == 0) {
            result.add(i - 1);
            result.add(i);
        } else {
            result.add(i);
            result.add(i + 1);
        }

        return result;
    }
}