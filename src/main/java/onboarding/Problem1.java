package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (!Exception(pobi.get(0), pobi.get(1)) || !Exception(crong.get(0), crong.get(1))) {
            answer = -1;
        }else {
            int pobiscore = Math.max(Score(pobi.get(0)), Score(pobi.get(1)));
            int crongscore = Math.max(Score(crong.get(0)), Score(crong.get(1)));
            if (pobiscore > crongscore) {
                answer = 1;
            } else if (pobiscore == crongscore){
                answer = 0;
            } else{
                answer = 2;
            }
        }
        return answer;
    }

    public static boolean Exception(int page1, int page2){
        if(page1<=1 || page1>=399){
            return false;
        }else if(page1!=page2-1){
            return false;
        }else{
            return true;
        }
    }
    public static int Score(int idx){
        int sum = 0;
        int mul = 1;

        while(idx!=0){
            sum += idx%10;
            mul *= idx%10;
            idx /= 10;
        }
        return Math.max(sum, mul);
    }
}