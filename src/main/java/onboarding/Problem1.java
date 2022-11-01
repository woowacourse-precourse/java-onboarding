package onboarding;

import java.util.List;

class Problem1 {
    private static int section = 0;
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
    public static int cal(List scoreData){
        int result = 0;
        int leftscore = 0;
        int rightscore = 0;

        if(Math.abs((int)scoreData.get(1)-(int)scoreData.get(0)) != 1){
            result = -1;
            return result;
        }
        if((int)scoreData.get(0) == 1 || (int)scoreData.get(1) == 400){
            result = -1;
            return result;
        }

        while(section++ <=2){
            if(section==1){
                String[] leftPage = scoreData.get(0).toString().split("");
                leftscore = calLeftPage(leftPage);
            }
            if(section==2){
                String[] rightPage = scoreData.get(1).toString().split("");
                rightscore = calRightPage(rightPage);
            }
        }
        section = 0;
        result = Math.max(leftscore, rightscore);
        return result;
    }
    private static int calLeftPage(String[] leftpage){
        int addScore = 0;
        int mulScore = 1;
        int leftscore = 0;

        for(int i=0; i<leftpage.length; i++) {
            addScore += Integer.parseInt(leftpage[i]);
            mulScore *= Integer.parseInt(leftpage[i]);
        }
        leftscore = Math.max(addScore, mulScore);
        return leftscore;
    }
    private static int calRightPage(String[] rightpage){
        int addScore = 0;
        int mulScore = 1;
        int rightscore = 0;

        for(int i=0; i<rightpage.length; i++) {
            addScore += Integer.parseInt(rightpage[i]);
            mulScore *= Integer.parseInt(rightpage[i]);
        }
        rightscore = Math.max(addScore, mulScore);
        return rightscore;
    }
    private static int compareScore(int pobi, int crong){
        int result = 0;
        if(pobi>crong) result = 1;
        if(crong>pobi) result = 2;
        if(crong==pobi) result = 0;

        return result;
    }
}