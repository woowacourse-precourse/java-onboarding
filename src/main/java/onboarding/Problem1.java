package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!validate_page_number(pobi, crong)) {
            return -1;
        }
        int pobi_max_num = get_max_number(pobi);
        int crong_max_num = get_max_number(crong);

        return compare_result(pobi_max_num, crong_max_num);
    }

    private static int get_max_number(List<Integer> pages) {
        int left_page = pages.get(0);
        int right_page = pages.get(1);

        int max_addition = Math.max(get_max_addition(left_page), get_max_addition(right_page));
        int max_multiplication = Math.max(get_max_multiplication(left_page), get_max_multiplication(right_page));

        return Math.max(max_addition, max_multiplication);
    }

    private static int get_max_multiplication(int page) {
        int result = 1;

        while (page > 0) {
            int value = page % 10;
            result *= value;
            page /= 10;
        }

        return result;
    }

    private static int get_max_addition(int page) {
        int result = 0;

        while (page > 0) {
            int value = page % 10;
            result += value;
            page /= 10;
        }

        return result;
    }

    private static boolean validate_page_number(List<Integer> pobi, List<Integer> crong) {
        return !(pobi.get(1) - pobi.get(0) > 1 || crong.get(1) - crong.get(0) > 1) ? true : false;
    }

    public static int compare_result(int x, int y) {
        return (x - y)> 0 ? 1 : (y - x) > 0 ? 2 : 0;
    }
}