package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if((isPage(pobi) == false) || (isPage(crong) == false)) return -1;

        int pobiScore =0;
        int crongScore = 0;

        for(int i=0;i<pobi.size();i++){
            String pobiPage = String.valueOf(pobi.get(i));
            pobiScore = Math.max(pobiScore, findMaxNum(pobiPage));

            String crongPage = String.valueOf(crong.get(i));
            crongScore = Math.max(crongScore, findMaxNum(crongPage));
        }

        return findWinner(pobiScore, crongScore);
    }

    public static boolean isPage(List<Integer> list){
        int leftPage = list.get(0);
        int rightPage = list.get(1);
        if (leftPage%2 == 0) {
            return false;
        }
        return ((rightPage-leftPage==1) ? true : false);
    }

    public static int findMaxNum(String page){
        int add = page.charAt(0)-'0';
        int multiple = page.charAt(0)-'0';

        for(int i=1;i<page.length();i++){
            add += page.charAt(i)-'0';
            multiple *= page.charAt(i)-'0';
        }

        return Math.max(add, multiple);
    }

    public static int findWinner(int a, int b){
        if (a>b) {
            return 1;
        }
        if (a<b){
            return 2;
        }
        return 0;
    }
}