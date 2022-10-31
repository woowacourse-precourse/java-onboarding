package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        try {


        } catch (Exception e) {
            return -1;
        }

        return answer;
    }


    // 왼쪽 페이지와 오른쪽 페이지 연산 결과 중에 최댓값
    public static int find_max_between_pages(List<Integer> pages){
        int left_max = find_max_between_sum_and_multi(pages.get(0));
        int right_max = find_max_between_sum_and_multi(pages.get(1));

        int max_num = (left_max < right_max) ? right_max : left_max;

        return max_num;

    }

    // 해당 페이지의 숫자들을 더하거나 곱한 것 중에 최댓값
    public static int find_max_between_sum_and_multi(Integer num) {

        int sum = 0;
        int multi = 1;

        while (num != 0) {
            int units = num % 10;

            sum += units;
            multi *= units;

            num /= 10;
        }

        int max_num = (sum < multi) ? multi : sum;

        return max_num;
    }
}