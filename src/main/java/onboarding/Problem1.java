package onboarding;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Problem1 {
    // 적합한 입력값이 들어왔는지 검사하는 함수
    public static boolean input_check(List<Integer> input) {
        return ((input.get(0) % 2 == 1) && (1 < input.get(0)) && (input.get(0) < 399) && (input.get(0) + 1 == input.get(1)));
    }

    // 각 자리 숫자를 모두 더하는 함수
    public static List<Integer> input_plus(List<Integer> input) {
        List<Integer> plus_answer = new ArrayList<Integer>();

        for (int i = 0; i < input.size(); i++) {
            int number = input.get(i);
            int temp_plus_answer = 0;

            while (number != 0) {
                temp_plus_answer += number % 10;
                number /= 10;
            }

            plus_answer.add(temp_plus_answer);
        }

        return plus_answer;
    }

    // 각 자리 숫자를 모두 곱하는 함수
    public static List<Integer> input_multi(List<Integer> input) {
        List<Integer> multi_answer = new ArrayList<Integer>();

        for (int i = 0; i < input.size(); i++) {
            int number = input.get(i);
            int temp_multi_answer = 1;

            while (number != 0) {
                temp_multi_answer *= number % 10;
                number /= 10;
            }

            multi_answer.add(temp_multi_answer);
        }

        return multi_answer;
    }

    // 작동 함수
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        List<Integer> pobi_results = new ArrayList<Integer>();
        List<Integer> crong_results = new ArrayList<Integer>();

        int temp_answer = -1;

        if (input_check(pobi) && input_check(crong)) {
            pobi_results.addAll(input_plus(pobi));
            pobi_results.addAll(input_multi(pobi));

            Collections.sort(pobi_results, Collections.reverseOrder());
            int pobi_result = pobi_results.get(0);

            crong_results.addAll(input_plus(crong));
            crong_results.addAll(input_multi(crong));

            Collections.sort(crong_results, Collections.reverseOrder());
            int crong_result = crong_results.get(0);

            if (pobi_result == crong_result) {
                temp_answer = 0;
            }
            else if ((pobi_result > crong_result)) {
                temp_answer = 1;
            }
            else {
                temp_answer = 2;
            }
        }

        answer = temp_answer;

        return answer;
    }
}