package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_sum =0,pobi_mul =1;
        int crong_sum=0, crong_mul=1;
        if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)) answer=-1;
        else if (pobi.get(0)==1 || pobi.get(1)==400 || crong.get(0)==1||crong.get(1)==400) {
            answer = -1;
        } else{
            for (int tmp : pobi) {
                while (tmp != 0) {
                    pobi_sum += tmp % 10;
                    pobi_mul *= tmp % 10;
                    tmp /= 10;
                }
            }
            int pobi_max = Math.max(pobi_sum,pobi_mul);
            for (int tmp : crong) {
                while (tmp != 0) {
                    crong_sum += tmp % 10;
                    crong_mul *= tmp % 10;
                    tmp /= 10;
                }
            }
            int crong_max = Math.max(crong_sum,crong_mul);
            if(pobi_max==crong_max) answer= 0;
            else if(pobi_max>crong_max) answer=1;
            else answer=2;
        }
        return answer;
    }
}