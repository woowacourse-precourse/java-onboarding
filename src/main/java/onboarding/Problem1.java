package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = 0;
        if(pobi.get(1)-pobi.get(0)!= 1 || crong.get(1)-crong.get(0)!= 1) return -1;

        ArrayList<Integer> pobinum = new ArrayList<>();
        ArrayList<Integer> crongnum = new ArrayList<>();
        int pobiAnswer = 0;
        int crongAnswer = 0;

        for (int i = 0; i < 2; i++) {
            int pobicheck = pobi.get(i);

            int j = pobicheck;
            while (pobicheck>0){
                pobinum.add(j%10);
                j/=10;
                pobicheck/=10;
            }
            int a = 1;
            int b = 0;
            for (int k = 0; k < pobinum.size(); k++) {
                a *= pobinum.get(k);
                b += pobinum.get(k);
            }
            pobiAnswer= Math.max(pobiAnswer,Math.max(a,b));
            pobinum.clear();
        }

        for (int i = 0; i < 2; i++) {
            int crongcheck = crong.get(i);

            int j = crongcheck;
            while (crongcheck>0){
                crongnum.add(j%10);
                j/=10;
                crongcheck/=10;
            }
            int a = 1;
            int b = 0;
            for (int k = 0; k < crongnum.size(); k++) {
                a *= crongnum.get(k);
                b += crongnum.get(k);
            }
            crongAnswer= Math.max(crongAnswer,Math.max(a,b));
            crongnum.clear();
        }

       // answer = pobiAnswer>crongAnswer? 1: (pobiAnswer<crongAnswer ? 2:0);
        if(pobiAnswer>crongAnswer){
            answer = 1;
        } else if (pobiAnswer<crongAnswer) {
            answer =2;
        }else {
            answer =0;
        }


        return answer;
    }
}