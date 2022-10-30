package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    static final int LEFT = 0, RIGHT = 1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(check(pobi) && check(crong)){
            int pobiScore = calcMaxScore(pobi);
            int crongScore = calcMaxScore(crong);

            if(pobiScore > crongScore){
                answer = 1;
            }else if(pobiScore < crongScore){
                answer = 2;
            }else{
                answer = 0;
            }

        }else{
            answer = -1;
        }

        return answer;
    }

    public static boolean check(List<Integer> pageList){
        if(!pageList.contains(0) || !pageList.contains(400)){
            if((pageList.get(RIGHT) - pageList.get(LEFT)) == 1){
                return true;
            }
        }

        return false;
    }

    public static int calcMaxScore(List<Integer> pageList){
        List<Integer> scoreList = new ArrayList<>();

        for(int i = 0; i <= 1; i++) {

            int page = pageList.get(i);

            int sumScore = 0;
            int mulScore = 1;

            for (int j = 100; j > 0; j /= 10) {
                if (j > page) {
                    continue;
                }
                sumScore += page / j;
                mulScore *= page / j;

                page %= j;
            }

            scoreList.add(sumScore);
            scoreList.add(mulScore);
        }

        return Collections.max(scoreList);
    }
}