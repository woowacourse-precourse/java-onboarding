package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 왼쪽, 오른쪽 페이지에서 각 자리 수를 더하거나 곱해 가장 큰 수를 반환하는 메소드
    private static int maxPageNumber(ArrayList<Integer> array) {
        int max = 0;

        for (int i = 0; i < array.size(); i++) {
            int pageNumber = maxNumber(array.get(i));

            if (pageNumber > max) {
                max = pageNumber;
            }
        }

        return max;
    }


    // 페이지의 각 자리 수를 더하거나 곱해 가장 큰 수를 반환하는 메소드
    private static int maxNumber(int number) {

        int sum = add(number);
        int multiplication = multiply(number);

        return Math.max(sum, multiplication);

    }

    // 페이지의 각 자리 숫자를 모두 곱하는 메소드
    private static int multiply(int number) {
        int multiplication = 1;
        String num = String.valueOf(number);

        for (int i = 0; i < num.length(); i++) {
            multiplication *= num.charAt(i);
        }

        return multiplication;
    }


    // 페이지의 각 자리 숫자를 모두 더하는 메소드
    private static int add(int number) {
        int sum =0;
        String num = String.valueOf(number);

        for (int i = 0; i < num.length(); i++) {
            sum += num.charAt(i);
        }

        return sum;
    }


}