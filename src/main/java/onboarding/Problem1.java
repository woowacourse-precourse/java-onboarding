package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pnum_left,pnum_right,cnum_left,cnum_right;
        int max_pnum_left,max_pnum_right,max_cnum_left,max_cnum_right;
        int max_pnum,max_cnum;

        pnum_left = pobi.get(0);
        pnum_right = pobi.get(1);
        cnum_left = crong.get(0);
        cnum_right = crong.get(1);

        if((pnum_right-pnum_left!=1) || (cnum_right-cnum_left!=1)){
            answer = -1;
        }else{
            max_pnum_left = compare_num(add_num(pnum_left),multi_num(pnum_left));
            max_pnum_right = compare_num(add_num(pnum_right),multi_num(pnum_right));
            max_cnum_left = compare_num(add_num(cnum_left),multi_num(cnum_left));
            max_cnum_right = compare_num(add_num(cnum_right),multi_num(cnum_right));

            max_pnum = compare_num(max_pnum_left,max_pnum_right);
            max_cnum = compare_num(max_cnum_left,max_cnum_right);

            if(max_pnum>max_cnum) answer = 1;
            else if(max_pnum<max_cnum) answer = 2;
            else answer = 0;
        }




        return answer;
    }

    static int add_num(int num){
        int result=0;

        while(num>0){
            result += num%10;
            num /= 10;
        }
        return result;
    }

    static int multi_num(int num){
        int result=1;

        while(num>0){
            result *= (num%10);
            num /= 10;
        }
        return result;
    }

    static int compare_num(int num1,int num2){
        return Math.max(num1,num2);
    }


}