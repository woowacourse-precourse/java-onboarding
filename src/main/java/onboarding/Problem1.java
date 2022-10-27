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
        String str_page = String.valueOf(page);
        int sum = 0;
        for(int i=0; i<str_page.length(); i++) {
            char c = str_page.charAt(i);
            sum += c;
        }
        return sum;
    }

    int getMulti(int page) {
        String str_page = String.valueOf(page);
        int multi = 1;
        for(int i=0; i<str_page.length(); i++) {
            char c = str_page.charAt(i);
            multi *= c;
        }
        return multi;
    }
}


