package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(validatePages(pobi)==-1||validatePages(crong)==-1){
            answer = -1;
            return answer;
        }

        answer = getWinner(pobi, crong);
        return answer;
    }

    public static int validatePages(List<Integer> pages){
        //페이지 홀짝 판별
        if(pages.get(0)%2!=1) return -1;
        if(pages.get(1)%2!=0) return -1;

        //페이지 연속 여부 판별
        if(pages.get(1)-pages.get(0)!=1) return -1;

        return 0;
    }

    public static int getScore(List<Integer> pages){
        int max_score=0;

        //덧셈과 곱셈 중 큰 수 점수로 반환
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
        int crong_score = getScore(crong);

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
