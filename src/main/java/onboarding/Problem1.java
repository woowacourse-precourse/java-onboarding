package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        answer = getWinner(pobi, crong);
        return answer;
    }



    public static int getScore(List<Integer> pages){
        int max_score=0;

        for(int i=0;i<2;i++){
            int sum=0;
            int mlt=1;
            int page = pages.get(i);
            int max = 0;
            while(page>0) {
                sum += page%10;
                mlt *= page%10;
                page = page/10;
            }
            max = Math.max(sum, mlt);
            if(max_score<max) max_score = max;
        }
        return max_score;
    }

    public static int getWinner(List<Integer> pobi, List<Integer> crong){
        int winner = Integer.MAX_VALUE;
        int pobi_score = getScore(pobi);
        System.out.println("pobi:"+ pobi_score);
        int crong_score = getScore(crong);
        System.out.println("crong:"+ crong_score);
        if(pobi_score>crong_score){
            winner = 1;
        }else if(pobi_score<crong_score){
            winner = 2;
        }else if(pobi_score==crong_score){
            winner = 0;
        }
        return winner;
    }

}
