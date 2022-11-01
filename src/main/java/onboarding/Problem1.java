package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        boolean page = page_val(pobi, crong);
        if(!page){
            return -1;
        }


        int pobi_sum = sum(pobi);
        int pobi_mul = mul(pobi);
        int pobi_score = Math.max(pobi_sum,pobi_mul);
        int crong_sum = sum(crong);
        int crong_mul = mul(crong);
        int crong_score = Math.max(crong_sum, crong_mul);

        if (pobi_score> crong_score){
            return 1;
        }else if(pobi_score < crong_score){
            return 2;
        }else if(pobi_score == crong_score){
            return 0;
        }else {
            return -1;
        }
    }
    static private int sum(List<Integer> value){

        int s1 = 0;
        int s2 = 0;
        int a1 = 0;
        int a2 = 0;
        s1 = value.get(0);
        s2 = value.get(1);
        while(s1 >0){
            a1 += s1%10;
            s1/=10;
        }

        while(s2 >0){
            a2 += s2%10;
            s2 /=10;
        }
        int answer = Math.max(a1,a2);


        return answer;
    }
    static private int mul(List<Integer> value){

        int s1 = 0;
        int s2 = 0;
        int a1 = 1;
        int a2 = 1;
        s1 = value.get(0);
        s2 = value.get(1);
        while(s1 >0){
            a1 *= s1%10;
            s1/=10;
        }

        while(s2 >0){
            a2 *= s2%10;
            s2 /=10;
        }
        int answer = Math.max(a1,a2);


        return answer;
    }
    static private boolean page_val(List<Integer> pobi, List<Integer> crong){

        boolean result = true;

        if(1 != (pobi.get(1)-pobi.get(0))){
            return false;
        } else if(1 != (crong.get(1)-crong.get(0))) {
            return false;
        } else {
            return result;
        }
    }
}