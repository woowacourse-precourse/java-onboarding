package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}


class Calculator {
    List<Integer> pages;

    Calculator(List<Integer> pages) {
        this.pages = pages;
    }

    int returnScore(){
        int page1_score = getScore(pages.get(0));
        int page2_score = getScore(pages.get(1));
        return Integer.max(page1_score, page2_score);
    }
    int getScore(int page) {
        int max_page = Integer.max(getSum(page), getMulti(page));
        return max_page;
    }

    int getSum(int page) {
        int sum = 0;
        while (page>0) {
            int q = page/10;
            int r = page%10;
            sum += r;
            page = q;
        }
        return sum;
    }

    int getMulti(int page) {
        int multi = 1;
        while (page>0) {
            int q = page/10;
            int r = page%10;
            multi *= r;
            page = q;
        }
        return multi;
    }
}

