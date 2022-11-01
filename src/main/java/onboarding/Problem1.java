package onboarding;

import java.util.List;

class Problem1 {
    /*
    - 문제 요구사항 정리 및 해결방법
    1. pobi와 crong의 예외처리
        - pobi와 crong의 페이지 번호가 정의에 안 맞거나 범위를 벗어나거나, 순서가 안맞을 경우 예외처리
        - 예외 발생시 → -1을 리턴
    2. pobi와 crong마다 최대값을 구함
        - pobi(또는 crong)가 펼친 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구함
        - pobi(또는 crong)가 펼친 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수 를 구함
        - pobi(또는 crong)가 구한 왼쪽 페이지의 가장 큰 값과 오른쪽 페이지의 가장 큰값중 가장 큰 값을 구하여 pobi(또는 crong)의 최대값을 구함
    3. pobi와 crong의 최대값과 비교 및 예외사항을 적용하여 아래의 조건을 성립하도록 결과 리턴
        - 포비가 이긴 경우 → 1을 리턴
        - 크롱이 이긴 경우 → 2를 리턴
        - 무승부시 → 3을 리턴
    */
    int sum_function(int temp) {
        // pobi(또는 crong)가 펼친 특정 페이지 번호의 각 자리 숫자를 모두 더한 값 리턴
        int value = 0;
        while (temp>0){
            value += temp%10;
            temp /= 10;

        }
        return value;
    }
    int mult_function(int temp) {
        // pobi(또는 crong)가 펼친 특정 페이지 번호의 각 자리 숫자를 모두 곱한 값 리턴
        int value = 1;
        while (temp>0){
            value *= temp%10;
            temp /= 10;
        }
        return value;
    }
    int calculate_function(List<Integer> values) {
        int left_max, right_max;
        Problem1 p1 = new Problem1();
        int left_digit = values.get(0);
        int right_digit = values.get(1);

        // pobi(또는 crong)가 구한 왼쪽 페이지 번호를 각 자리 숫자를 모두 더한값과 곱한 값중 큰 값을 리턴
        left_max = Math.max(p1.sum_function(left_digit), p1.mult_function(left_digit));
        // pobi(또는 crong)가 구한 오른쪽 페이지 번호를 각 자리 숫자를 모두 더한값과 곱한 값중 큰 값을 리턴
        right_max = Math.max(p1.sum_function(right_digit),p1.mult_function(right_digit));
        // pobi(또는 crong)의 왼쪽 페이지의 최대값과 오른쪽 페이지의 최대값 중 큰 값을 리턴
        return Math.max(left_max,right_max);
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        Problem1 p1 = new Problem1();

        // pobi와 crong의 예외처리
        if (pobi.get(0) + 1 != pobi.get(1) || crong.get(0) + 1 != crong.get(1) // 왼쪽 페이지와 오른쪽 페이지 짝이 아닌경우
                || pobi.get(0) < 0 || pobi.get(1) > 400 || crong.get(0) < 0 || crong.get(1) > 400   // 왼쪽 페이지와 오른쪽 페이지가 정해진 범위를 넘는 경우
                || pobi.get(0) % 2 == 0 || pobi.get(1) % 2 == 1 || crong.get(0) % 2 == 0 || crong.get(1) % 2 == 1) // 왼쪽페이지가 짝수이거나 오른쪽 페이지가 홀수일 경우
        {
            return -1;  // 예외발생!!
        }

        int pobi_max = p1.calculate_function(pobi); // pobi의 최대값
        int crong_max = p1.calculate_function(crong);   // crong의 최대값

        return answer;
    }
}