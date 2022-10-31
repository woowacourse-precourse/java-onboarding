package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi_left, pobi_right, crong_left, crong_right;
        pobi_left = pobi.get(0);
        pobi_right = pobi.get(1);
        crong_left = crong.get(0);
        crong_right = crong.get(1);
        if (pobi_left%2 != 1 || pobi_right%2 != 0 || crong_left%2 != 1 || crong_right%2 != 0) {
            return -1;
        }
        if (pobi_right - pobi_left != 1 || crong_right - crong_left != 1) {
            return -1;
        }
        int p;
        int m;
        int[] resp = new int[4];
        int[] resc = new int[4];
        int[] arrp = {pobi_left, pobi_right};
        int[] arrc = {crong_left, crong_right};
        for(int i=0; i<2; i++) {
            p = 0;
            m = 1;
            while (arrp[i] > 0) {
                p += arrp[i] % 10;
                m *= arrp[i] % 10;
                arrp[i] /= 10;
            }
            resp[2 * i] = p;
            resp[2 * i + 1] = m;
        }
        for(int i=0; i<2; i++) {
            p = 0;
            m = 1;
            while (arrc[i] > 0) {
                p += arrc[i] % 10;
                m *= arrc[i] % 10;
                arrc[i] /= 10;
            }
            resc[2 * i] = p;
            resc[2 * i + 1] = m;
        }
        Arrays.sort(resp);
        Arrays.sort(resc);
        int max_p = resp[3];
        int max_c = resc[3];
        if(max_p == max_c) {
            answer = 0;
        }else if(max_p > max_c){
            answer = 1;
        }else{
            answer = 2;
        }
        return answer;
    }
}