package onboarding;

import java.util.*;

class Problem1 {
    static final int PAGE_MIN = 1;
    static final int PAGE_MAX = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int left_pobi = pobi.get(0);
        int right_pobi = pobi.get(1);
        int left_crong = crong.get(0);
        int right_crong = crong.get(1);

        if (pobi.size() != 2 || crong.size() != 2) {
            return check_exception("리스트 요소가 2가 아님");
        }

        if (!page_range(left_pobi) || !page_range(right_pobi) || !page_range(left_crong) || !page_range(right_crong)) {
            return check_exception("페이지 범위가 틀렸습니다.");
        }


        if (left_pobi % 2 != 1 || left_crong % 2 != 1) {
            return check_exception("left page가 홀수가 아님.");
        }


        if (right_pobi != left_pobi + 1 || right_crong != left_crong + 1) {
            return check_exception("right page가 left page 다음 페이지가 아님.");
        }

        int pobi_score = Integer.max(max_score(left_pobi), max_score(right_pobi));
        int crong_score = Integer.max(max_score(left_crong), max_score(right_crong));
        System.out.println("pobi: " + pobi_score + " crong: " + crong_score);

        if (pobi_score == crong_score) {
            return 0;
        } else if (pobi_score > crong_score) {
            return 1;
        } else {
            return 2;
        }
    }
    static int check_exception(String word){
        System.out.println(word);
        return -1;
    }

    static boolean page_range(int val) {
        return val > PAGE_MIN && val < PAGE_MAX;
    }

    static int max_score(Integer page) {

        List<Integer> new_list = new ArrayList<>();

        int sum = 0;
        int duplicate = 1;
        int number = page;

        while (number > 0) {
            new_list.add(number % 10);
            number /= 10;
        }

        for(int i : new_list) {
            sum += i;
            duplicate *= i;
        }
        return sum >= duplicate ? sum : duplicate;
    }
}