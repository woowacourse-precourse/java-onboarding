package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Problem5 {
    public static List<Integer> solution(int money) {
        List<Integer> answer = Collections.emptyList();
        Integer fif_th=0;int ten_th=0; int fiv_th=0; int th=0;
        int f_hund=0; int hund_d=0; int fif_ten=0;
        int ten_d=0; int one=0;
        fif_th=money/50000;
        ten_th=(money%50000)/10000;
        fiv_th=(money%10000)/5000;
        th=(money%5000)/1000;
        f_hund=(money%1000)/500;
        hund_d=(money%500)/100;
        fif_ten=(money%100)/50;
        ten_d=(money%50)/10;
        one=(money%10);

        answer= Arrays.asList(fif_th,ten_th,fiv_th,th,f_hund,hund_d,fif_ten,ten_d,one);



        return answer;
    }
}