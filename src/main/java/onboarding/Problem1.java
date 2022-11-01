package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!pagesCheck(pobi) || !pagesCheck(crong))
            return -1;

        int pobi_val = pagesCom(pobi);
        int crong_val = pagesCom(crong);

        if (pobi_val > crong_val)
            return 1;
        else if (pobi_val < crong_val)
            return 2;
        else
            return 0;
    }

    public static boolean pagesCheck(List<Integer> pages){
        if (pages.get(0) + 1 != pages.get(1))
            return false;
        return true;
    }

    public static int pagesMax(int pageInt){
        String page = Integer.toString(pageInt);
        int sum = 0;
        int mul = 1;
        int n;

        for(int j = 0; j < page.length(); j++){
            n = page.charAt(j) - '0';
            sum +=n;
            mul *=n;
        }
        return Math.max(sum,mul);
    }

    public static int pagesCom(List<Integer> pageList){
        int temp;
        int score = 0;

        for(int i = 0; i < 2 ; i++){
            temp = pagesMax(pageList.get(i));
            score = Math.max(score,temp);
        }
        return score;
    }

}