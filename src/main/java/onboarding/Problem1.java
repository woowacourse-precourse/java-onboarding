package onboarding;

import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;

        answer = win(pobi, crong);

        return answer;
    }
    public static int win(List<Integer> pobi, List<Integer> crong) {

        int pobiMax = check(pobi);

        int crongMax = check(crong);

        int answer = -2;


        if( pobiMax > crongMax){

            answer = 1;
        }

        if(pobiMax<crongMax) {

            answer = 2;

        }
        if(pobiMax == crongMax) {

            answer = 0;

        }

        if((pobiMax==-1) || (crongMax==-1)) {

            answer = -1;

        }

        return answer;
    }

    public static int check(List<Integer> pages) {

        int answer = 0;

        if((pages.get(0)+1) != (pages.get(1))) {

            answer =-1;
        }

        if((pages.get(0)+1) == (pages.get(1))){
            answer = max(pages);
        }

            return answer;

    }

    public static int max(List<Integer> pages){

            int pageMax;

            pageMax = sum(pages.get(0));

            if(pageMax < mul(pages.get(0))) {

                pageMax = mul(pages.get(0));

            }

            if(pageMax < mul(pages.get(1))) {

                pageMax = mul(pages.get(1));

            }

            if(pageMax<sum(pages.get(1))) {

                pageMax = sum(pages.get(1));

            }
            return pageMax;
        }


    public static int sum(int page) {
        int pageSum =0;

        while(page > 0) {

            pageSum += page%10;

            page /= 10;

        }

        return pageSum;
    }

    public static int mul(int page) {

        int pageMul =1;

        while(page > 0) {

            pageMul *= page%10;

            page /= 10;

        }

        return pageMul;
    }
}