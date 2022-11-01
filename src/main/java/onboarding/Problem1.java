package onboarding;

import java.util.List;

// first commit
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_left_sum = 0;
        int pobi_right_sum = 0;
        int pobi_left_mul = 1;
        int pobi_right_mul = 1;
        int crong_left_sum = 0;
        int crong_right_sum = 0;
        int crong_left_mul = 1;
        int crong_right_mul = 1;
        int num = 10;

        for (int pobi_left_num = pobi.get(0); pobi_left_num != 0;){
            pobi_left_sum += pobi_left_num % num;
            pobi_left_num -= pobi_left_num % num;
            pobi_left_num /= num;
        }// pobi_left_sum

        for (int pobi_right_num = pobi.get(1); pobi_right_num != 0;){
            pobi_right_sum += pobi_right_num % num;
            pobi_right_num -= pobi_right_num % num;
            pobi_right_num /= num;
        }// pobi_right_sum

        for (int pobi_left_num = pobi.get(0); pobi_left_num != 0;){
            pobi_left_mul *= pobi_left_num % num;
            pobi_left_num -= pobi_left_num % num;
            pobi_left_num /= num;
        }// pobi_left_mul

        for (int pobi_right_num = pobi.get(1); pobi_right_num != 0;){
            pobi_right_mul *= pobi_right_num % num;
            pobi_right_num -= pobi_right_num % num;
            pobi_right_num /= num;
        }// pobi_right_mul

        int[] pobiarray = new int[] {pobi_left_sum, pobi_left_mul, pobi_right_mul, pobi_right_sum};
        int pobimax = pobiarray[0];
        for(int i=1 ; i<pobiarray.length ; i++) {
            if(pobiarray[i]>pobimax) {
                pobimax = pobiarray[i];
            }
        }// pobimax


        for (int crong_left_num = crong.get(0); crong_left_num != 0;){
            crong_left_sum += crong_left_num % num;
            crong_left_num -= crong_left_num % num;
            crong_left_num /= num;
        }// crong_left_sum

        for (int crong_right_num = crong.get(1); crong_right_num != 0;){
            crong_right_sum += crong_right_num % num;
            crong_right_num -= crong_right_num % num;
            crong_right_num /= num;
        }// crong_right_sum

        for (int crong_left_num = crong.get(0); crong_left_num != 0;){
            crong_left_mul *= crong_left_num % num;
            crong_left_num -= crong_left_num % num;
            crong_left_num /= num;
        }// crong_left_mul

        for (int crong_right_num = crong.get(1); crong_right_num != 0;){
            crong_right_mul *= crong_right_num % num;
            crong_right_num -= crong_right_num % num;
            crong_right_num /= num;
        }// crong_right_mul

        int[] crongarray = new int[] {crong_left_sum, crong_left_mul, crong_right_mul, crong_right_sum};
        int crongmax = crongarray[0];
        for(int i=1 ; i<crongarray.length ; i++) {
            if(crongarray[i]>crongmax) {
                crongmax = crongarray[i];
            }
        }// crongmax

        if (pobi.get(1) - pobi.get(0) == 1 && crong.get(1) - crong.get(0) == 1 && pobi.get(0) != 1 && pobi.get(1) != 400 && crong.get(0) != 1 && crong.get(1) != 400){
            if (pobimax > crongmax){
                answer = 1;
            } else if (pobimax < crongmax){
                answer = 2;
            } else {
                answer = 0;
            }
        } else {
            answer = -1;
        }
        return answer;
    }
}