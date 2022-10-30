package onboarding;

import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();

        answer=new LinkedList<>();


        Integer fiveman=0;
        Integer man=0;
        Integer fivechon=0;
        Integer chon=0;
        Integer fiveback=0;
        Integer back=0;
        Integer fiveship=0;
        Integer ship=0;
        Integer ill=0;

        fiveman=money/50000;
        money-=(fiveman*50000);

        man=money/10000;
        money-=(man*10000);

        fivechon=money/5000;
        money-=(fivechon*5000);

        chon=money/1000;
        money-=(chon*1000);

        fiveback=money/500;
        money-=(fiveback*500);

        back=money/100;
        money-=(back*100);

        fiveship=money/50;
        money-=(fiveship*50);

        ship=money/10;
        money-=(ship*10);

        ill=money;

        answer.add(fiveman);
        answer.add(man);
        answer.add(fivechon);
        answer.add(chon);
        answer.add(fiveback);
        answer.add(back);
        answer.add(fiveship);
        answer.add(ship);
        answer.add(ill);



        return answer;
    }
}
