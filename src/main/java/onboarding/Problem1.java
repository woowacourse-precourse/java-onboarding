package onboarding;

import java.util.List;

class Problem1 {
    //Page continuity check
    public static boolean isBook(List<Integer> pages) {
        Integer left_page = pages.get(0) ;
        Integer right_page = pages.get(1) ;

        return( (right_page - left_page) == 1 ) ;
    }

    // Calculate max score using 2 scoring method
    public static int calculateMaxScore(List<Integer> pages) {

        int max_score = 0 ;

        for (int i = 0; i < pages.size(); ++i) {
            Integer page_number = pages.get(i);
            int add_number = 0;
            int multiple_number = 1;

            while (page_number > 0) {
                int remainder = page_number % 10;
                add_number += remainder;
                multiple_number *= remainder;
                page_number = page_number / 10;

            }
            max_score = Math.max( max_score, Math.max(add_number, multiple_number) );
        }
        return max_score ;
    }

    // Winner check
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        boolean flag = isBook(pobi) && isBook(crong) ;

        if (flag) {
            if (calculateMaxScore(pobi) > calculateMaxScore(crong)) {
                answer = 1;
            }
            else if (calculateMaxScore(pobi) < calculateMaxScore(crong)) {
                answer = 2;
            }
            else answer = 0;
        }
        else answer = -1;

        return answer;
    }
}
