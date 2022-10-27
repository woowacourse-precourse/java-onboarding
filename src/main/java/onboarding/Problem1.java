package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int bigPage(int page1, int page2){
        int answer = 0;
        if(page1 > page2)
            answer = page1;
        else
            answer = page2;

        return answer;
    }

    public static boolean exception(List<Integer> pages){
        boolean answer = false;

        int left = pages.get(0);
        int right = pages.get(1);


        if(left%2 != 0 || right %2 == 0){
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
}