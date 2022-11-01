package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(!valid(pobi,crong)){
            return -1;
        }

        int pobi_sum = sum(pobi);
        int crong_sum = sum(crong);
        int pobi_mul = mul(pobi);
        int crong_mul = mul(crong);

        int pobi_max = compareInt(pobi_sum,pobi_mul);
        int crong_max = compareInt(crong_sum,crong_mul);

        if (pobi_max>crong_max){
            answer = 1;
        } else if (pobi_max<crong_max) {
            answer = 2;
        } else if (pobi_max == crong_max){
            answer = 0;
        } else {
            answer = -1;
        }

        return answer;
    }

    static private boolean valid(List<Integer> pobi, List<Integer> crong){

        if ((Math.abs(pobi.get(1)-pobi.get(0)) != 1)||(Math.abs(crong.get(1)-crong.get(0)) != 1)){
            return false;
        } else if (((pobi.get(0)%2) != 1) || ((pobi.get(1)%2) != 0)) {
            return false;
        } else if (((crong.get(0)%2) != 1) || ((crong.get(1)%2) != 0)) {
            return false;
        }
        return true;
    }

    static private int sum(List<Integer> l){
        int fir_sum = 0;
        int sec_sum = 0;

        String fir = Integer.toString(l.get(0));
        String sec = Integer.toString(l.get(1));

        String[] fir_arr = fir.split("");
        String[] sec_arr = sec.split("");

        for(String i:fir_arr){
            fir_sum += Integer.valueOf(i);
        }

        for(String i:sec_arr){
            sec_sum += Integer.valueOf(i);
        }

        return compareInt(fir_sum,sec_sum);
    }
    static private int mul(List<Integer> l){
        int fir_mul = 1;
        int sec_mul = 1;

        String fir = Integer.toString(l.get(0));
        String sec = Integer.toString(l.get(1));

        String[] fir_arr = fir.split("");
        String[] sec_arr = sec.split("");

        for(String i:fir_arr){
            fir_mul *= Integer.valueOf(i);
        }

        for(String i:sec_arr){
            sec_mul *= Integer.valueOf(i);
        }

        return compareInt(fir_mul,sec_mul);
    }

    static private int compareInt(int a, int b){
        if (a>=b){
            return a;
        }
        return b;
    }
}