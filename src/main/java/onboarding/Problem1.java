package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int p1,p2, c1,c2;
        int[] p = new int[2];
        int[] c = new int[2];
        if(pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0 || crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0) {
            answer = -1;
            return answer;
        }
        if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)){
            answer = -1;
            return answer;
        }
        for(int i = 0; i < 2; i++){
            int tmp = pobi.get(i);
            int sum = 0, pro = 1;
            while (tmp != 0) {
                sum += tmp%10;
                pro *= tmp%10;
                tmp /= 10;
            }
            if(sum > pro) p[i] = sum;
            else p[i] = pro;
        }
        for(int i = 0; i < 2; i++){
            int tmp = crong.get(i);
            int sum = 0, pro = 1;
            while (tmp != 0) {
                sum += tmp%10;
                pro *= tmp%10;
                tmp /= 10;
            }
            if(sum > pro) c[i] = sum;
            else c[i] = pro;
        }
        int po, cr;
        if(p[0] > p[1]) po = p[0];
        else po = p[1];

        if(c[0] > c[1]) cr = c[0];
        else cr = c[1];

        if(po > cr) answer = 1;
        else if(po < cr) answer = 2;
        else answer = 0;

        return answer;
    }
}