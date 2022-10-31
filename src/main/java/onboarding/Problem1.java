package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1){
            answer = -1;
        } else{
            int[] pobis = new int[2];
            int[] crongs = new int[2];

            for (int i=0; i<=1; i++) {
                int page_p = pobi.get(i);
                int page_c = crong.get(i);
                int sum_p = 0;
                int mul_p = 1;
                int sum_c = 0;
                int mul_c = 1;
                while (page_p > 0) {
                    sum_p += page_p%10;
                    mul_p *= page_p%10;
                    page_p/=10;
                }
                while (page_c > 0) {
                    sum_c += page_c%10;
                    mul_c *= page_c%10;
                    page_c/=10;
                }
                pobis[i] = Math.max(sum_p, mul_p);
                crongs[i] = Math.max(sum_c, mul_c);
            }
            int score_p;
            int score_c;
            if (pobis[0] > pobis[1]) {
                score_p = pobis[0];
            } else {
                score_p = pobis[1];
            }
            if (crongs[0] > crongs[1]) {
                score_c = crongs[0];
            } else {
                score_c = crongs[1];
            }

            if(score_p > score_c) {
                answer = 1;
            } else if(score_p < score_c){
                answer = 2;
            } else{
                answer = 0;
            }
        }
        return answer;
    }
}