package onboarding;

import java.util.List;
import java.util.stream.Stream;
class Problem1 {


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobi_left,pobi_right,pobiscore;
        pobi_left=pobi.get(0);
        pobi_right=pobi.get(1);
        if (pobi_right-pobi_left!=1){
            return -1;
        }
        int pobi_left_sum=0;
        int pobi_left_=1;
        while(pobi_left > 0) {
            pobi_left_sum+=(pobi_left %10);

            pobi_left_=pobi_left_*(pobi_left %10);

            pobi_left /= 10;
        }

        pobiscore=Math.max(pobi_left_sum,pobi_left_);
        int pobi_right_sum=0;
        int pobi_right_=1;
        while(pobi_right > 0) {
            pobi_right_sum+=(pobi_right %10);
            pobi_right_=pobi_right_*(pobi_right %10);
            pobi_right /= 10;
        }
        pobiscore=Math.max(pobiscore,Math.max(pobi_right_,pobi_right_sum));
        System.out.println(pobiscore);


        int crong_left,crong_right,crongscore;
        crong_left=crong.get(0);
        crong_right=crong.get(1);

        if (crong_right-crong_left!=1){
            return -1;
        }
        int crong_left_sum=0;
        int crong_left_=1;
        while(crong_left > 0) {
            crong_left_sum+=(crong_left %10);
            crong_left_=crong_left_*(crong_left %10);
            crong_left /= 10;
        }

        crongscore=Math.max(crong_left_sum,crong_left_);
        int crong_right_sum=0;
        int crong_right_=1;
        while(crong_right > 0) {
            crong_right_sum+=(crong_right %10);
            crong_right_=crong_right_*(crong_right %10);
            crong_right /= 10;
        }
        crongscore=Math.max(crongscore,Math.max(crong_right_,crong_right_sum));
        System.out.println(crongscore);


        if (pobiscore>crongscore) {
            answer= 1;
        }
        else if (pobiscore<crongscore) {
            answer= 2;
        }
        else if (pobiscore==crongscore) {
            answer= 0;
        }


        return answer;
    }
}