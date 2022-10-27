package onboarding;

import java.util.List;

class Problem1 {
    static int rest;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;

        if(cal(pobi)!=-1 && cal(crong)!=-1){
            answer = compareScore(cal(pobi),cal(crong));
        }
        else{
            answer = -1;
        }
        return answer;
    }
    static int cal(List scoreData){
        int result = 0;
        int leftScore = 0;
        int rightScore = 0;

        if(Math.abs((int)scoreData.get(1)-(int)scoreData.get(0))!=1){
            result = -1;
            return result;
        }

        while(rest++ <=2){
            int addScore = 0;
            int mulScore = 1;
            if(rest==1){
                String[] leftPage = scoreData.get(0).toString().split("");

                for(int i=0; i<leftPage.length; i++) {
                    addScore += Integer.parseInt(leftPage[i]);
                    mulScore *= Integer.parseInt(leftPage[i]);
                }
                leftScore = Math.max(addScore, mulScore);
            }
            else if(rest==2){
                String[] rightPage = scoreData.get(1).toString().split("");

                for(int i=0; i<rightPage.length; i++) {
                    addScore += Integer.parseInt(rightPage[i]);
                    mulScore *= Integer.parseInt(rightPage[i]);
                }
                rightScore = Math.max(addScore, mulScore);
            }
        }
        rest = 0;
        result = Math.max(leftScore, rightScore);
        return result;
    }

    static int compareScore(int pobi, int crong){
        int result = 0;

        return result;
    }
}