package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int answer = 0;

        if(errorCheck(pobi,crong) == 1){

            int pobibest = SumMulti(pobi);
            int crongbest = SumMulti(crong);

            if (crongbest < pobibest) {
                answer = 1;
            } else if (crongbest > pobibest) {
                answer = 2;
            } else if (crongbest == pobibest) {
                answer = 0;
            }

        }else{
            return answer = -1;
        }
        return answer;
    }

    static int errorCheck(List<Integer> a, List<Integer> b){
        if(a.get(1)-a.get(0) != 1 || b.get(1)-b.get(0) != 1 ){
            return 0;
        }
        if(a.get(0) < 1 || b.get(0) < 1 )
            return 0;

        if(a.get(1) > 400 || a.get(1) > 400){
            return 0;
        }
        return 1;
    }
    static int SumMulti(List<Integer> a){
        int bestnum = 0;
        int multiply = 1;
        int add = 0;

        for (int i = 0; i < a.size(); i++) {
            int tmp = a.get(i);
            while (tmp > 0) {
                add += tmp % 10;
                multiply *= tmp % 10;
                tmp /= 10;
            }
            bestnum = Math.max(bestnum, Math.max(add, multiply));
            multiply = 1;
            add = 0;
        }
        return bestnum;
    }

    public static void main(String[] args) {
        List<Integer> pobi = List.of(97, 98);
        List<Integer> crong = List.of(197, 198);
        Problem1 p = new Problem1();
        p.solution(pobi,crong);
    }
}