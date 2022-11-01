package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        try {
            // 페이지 정보가 제대로 됐는 지 확인
            if (is_abnormal_pages(pobi) || is_abnormal_pages(crong)){
                return -1;
            }

            // 포비와 크롱이 뽑은 페이지 연산 결과 중 각각 최댓값
            int pobi_max = find_max_between_pages(pobi);
            int crong_max = find_max_between_pages(crong);

            if (pobi_max == crong_max) {
                answer = 0;
            } else if (pobi_max < crong_max) {
                answer = 2;
            } else {
                answer = 1;
            }

        } catch (Exception e) {
            return -1;
        }

        return answer;
    }


    // 페이지 오류 확인
    public static boolean is_abnormal_pages(List<Integer> pages){
        int left_page = pages.get(0);
        int right_page = pages.get(1);

        if (left_page < 0 || right_page > 400){
            return true;
        }

        if (left_page + 1 != right_page) {
            return true;
        }

        return false;
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