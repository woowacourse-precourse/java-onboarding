package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pnum_left,pnum_right,cnum_left,cnum_right;
        int max_pleft,max_pright,max_cleft,max_cright;

        pnum_left = pobi.get(0);
        pnum_right = pobi.get(1);
        cnum_left = crong.get(0);
        cnum_right = crong.get(1);




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