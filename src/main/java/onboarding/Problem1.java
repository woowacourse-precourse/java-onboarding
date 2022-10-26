package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(Math.abs(pobi.get(0) - pobi.get(1)) != 1 || Math.abs(crong.get(0) - crong.get(1)) != 1) return -1;
        int pobi_max = Math.max(sum_max(pobi), mul_max(pobi));
        int crong_max = Math.max(sum_max(crong), mul_max(crong));
        if(pobi_max > crong_max) return 1;
        else if(pobi_max == crong_max) return 0;
        else return 2;
    }


    public static int mul_max(List<Integer> pages) {
        int max = 0;
        int[] sum = {0, 0};
        for(int i = 0; i < pages.size(); i++){
            int num = pages.get(i);
            int re = 0;
            while(num > 0) {
                if(re == 0) re = num % 10;
                else re *= num % 10;
                num /= 10;

            }
            sum[i] = re;
        }
        return Math.max(sum[0], sum[1]);
    }

    public static int sum_max(List<Integer> pages){
        int max = 0;
        int[] sum = {0, 0};
        for(int i = 0; i < pages.size(); i++){
            int num = pages.get(i);
            int re = 0;
            while(num > 0){
                re += num % 10;
                num /= 10;
            }
            sum[i] = re;
        }
        return Math.max(sum[0], sum[1]);
    }

    public static void main(String[] args) {
        List<Integer> pobi = new ArrayList<>();
//        pobi.add(97);
//        pobi.add(98);
        pobi.add(132);
        pobi.add(133);
        List<Integer> crong = new ArrayList<>();
//        crong.add(197);
//        crong.add(198);
        crong.add(211);
        crong.add(212);

        System.out.println(solution(pobi, crong));

    }
}