package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(exception(pobi) || exception(crong)){
            answer = -1;
        }else {
            int pobiPage = bigPage(summulPage(pobi.get(0)),summulPage(pobi.get(1)));
            int crongPage = bigPage(summulPage(crong.get(0)),summulPage(crong.get(1)));

            answer = result(pobiPage, crongPage);
        }


        return answer;
    }

    //기능 1
    public static int bigPage(int page1, int page2){
        int answer = 0;
        if(page1 > page2)
            answer = page1;
        else
            answer = page2;

        return answer;
    }

    //기능 2
    public static boolean exception(List<Integer> pages){
        boolean answer = false;

        int left = pages.get(0);
        int right = pages.get(1);


        if(left%2 == 0 || right %2 != 0){
            answer = true;
        }else if(right-left != 1){
            answer = true;
        }else if(left==1 || right==400){
            answer = true;
        }else if(left<1 || right>400){
            answer = true;
        }

        return answer;
    }

    //기능 3
    public static int summulPage(int page){
        int answer = 0;
        int hundred, ten, one;
        int na;
        int sum, mul;

        if(page>=100){
            na = page%100;

            hundred = page/100;
            ten = na/10;
            one = na%10;

            sum = hundred + ten + one;
            mul = hundred * ten * one;

            answer = bigPage(sum, mul);
        }else if(page >= 10){
            ten = page/10;
            one = page%10;

            sum = ten + one;
            mul = ten * one;

            answer = bigPage(sum, mul);
        }else{
            answer = page;
        }

        return answer;
    }

    //기능 4
    public static int result(int pobiPage, int crongPage){
        int answer=0;
        if(pobiPage > crongPage){
            answer = 1;
        }else if(pobiPage < crongPage){
            answer = 2;
        }else {
            answer = 0;
        }

        return answer;
    }
}