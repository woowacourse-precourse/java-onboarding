package onboarding;

import java.util.List;


class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = Integer.MAX_VALUE;
        int pobiMax = pageMax(pobi);
        int crongMax = pageMax(crong);
        if(pobiMax==-1 || crongMax==-1) {
            answer = -1;
        }
        else if( pobiMax > crongMax){
            answer = 1;
        }
        else if(pobiMax<crongMax) {
            answer = 2;
        }else {
            answer = 0;
        }

        return answer;
    }
    public static int pageSum(int page) {
        int pageSum =0;
        while(page > 0) {
            pageSum += page%10;
            page /= 10;
        }
        return pageSum;
    }

    public static int pageMul(int page) {
        int pageMul =1;
        while(page > 0) {
            pageMul *= page%10;
            page /= 10;
        }
        return pageMul;
    }

    public static int pageMax(List<Integer> pages) {

        if(pages.get(0)+1 != pages.get(1)) {
            return -1;
        }else {
            int pageMax = pageSum(pages.get(0));

            if(pageMax < pageMul(pages.get(0))) {
                pageMax = pageMul(pages.get(0));
            }
            if(pageMax < pageMul(pages.get(1)))
            {
                pageMax = pageMul(pages.get(1));
            }
            if(pageMax<pageSum(pages.get(1)))
            {
                pageMax = pageSum(pages.get(1));
            }
            return pageMax;
        }
    }
}