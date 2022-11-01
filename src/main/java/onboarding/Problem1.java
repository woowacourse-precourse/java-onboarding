package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int max_pobi = Integer.MIN_VALUE;
        int max_crong = Integer.MIN_VALUE;
        int max_page = 0;

        //예외사항 : 1. left >= right
        //          2.  right - left > 1
        if( (pobi.get(0)-pobi.get(1)) >= 0 || (pobi.get(1)-pobi.get(0)) > 1 ||
                (crong.get(0)-crong.get(1)) >= 0 || (crong.get(1)-crong.get(0)) > 1     ) {
            return -1;
        }

        for(int i = 0; i<=1; i++) {
            max_page = Calscore(pobi.get(i));
            if(max_pobi < max_page)
                max_pobi = max_page;

            max_page = Calscore(crong.get(i));
            if(max_crong < max_page)
                max_crong = max_page;
        }

        if(max_pobi > max_crong)
            answer = 1;
        else if(max_pobi < max_crong)
            answer = 2;
        else
            answer = 0;

        return answer;
    }

    public static int Calscore(int page) {
        int add = 0;
        int mul = 1;

        while (page > 0) {
            add += page % 10;
            mul *= page % 10;
            page /= 10;
        }

        if(add > mul)
            return add;
        else
            return mul;
    }
}