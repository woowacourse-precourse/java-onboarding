package onboarding;

import java.util.List;

class Problem1 {
    public static int getmult(int[] page){
        int mult=0;
        int k;
        int flag = 0;
        for(k=0;k<3;k++){ // get multiplied number of the right page number of pobi
            if (flag == 0){
                if(page[k] != 0){
                    flag = 1;
                    mult = 1;
                }
            }
            if(flag == 1) {mult *= page[k];}
        }

        return mult;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobil_int[] = {0,0,0};
        int pobir_int[] = {0,0,0};
        int pobil, pobir, crongl, crongr;
        int pobi_max;
        int crongl_int[] = {0,0,0};
        int crongr_int[] ={0,0,0};
        int crong_max;
        int k, i=0, s;

        // if the left, right number is not valid, return -1
        if((pobi.get(1) - 1 != pobi.get(0)) || (crong.get(1) - 1 != crong.get(0))){
            return -1;
        }

        pobil = pobi.get(0);
        pobir = pobi.get(1);
        crongl = crong.get(0);
        crongr = crong.get(1);

        // get individual int from the given number
        for(s=100;s>0;s/=10){
            pobil_int[i] = pobil / s;
            pobir_int[i] = pobir / s;
            crongl_int[i] = crongl / s;
            crongr_int[i] = crongr / s;
            pobil -= pobil / s * s;
            pobir -= pobir / s * s;
            crongl -= crongl / s * s;
            crongr -= crongr / s * s;
            i++;
        }
        // use as the sum of the number
        pobil = pobir = crongl = crongr = 0;
        for(k=0;k<3;k++){
            pobil += pobil_int[k];
            pobir += pobir_int[k];
            crongl += crongl_int[k];
            crongr += crongr_int[k];
        }

        // max of the sum
        pobi_max = Math.max(pobil, pobir);
        crong_max = Math.max(crongl, crongr);

        //get the multiplied number
        pobil = pobir = crongl = crongr = 0;

        pobi_max = Math.max(pobi_max, getmult(pobil_int));
        pobi_max = Math.max(pobi_max, getmult(pobir_int));

        crong_max = Math.max(crong_max, getmult(crongl_int));
        crong_max = Math.max(crong_max, getmult(crongr_int));


        if(crong_max == pobi_max){
            answer = 0;
        }if(crong_max > pobi_max){
            answer = 2;
        }if(crong_max < pobi_max){
            answer = 1;
        }

        return answer;
    }
}