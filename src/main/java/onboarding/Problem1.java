package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int max_le;
        int max_ri;

        int sum = 0;
        int mul = 1;

        if (!(pobi.get(0) - pobi.get(1) == -1))
            return -1;
        if (!(crong.get(0) - crong.get(1) == -1))
            return -1;

        for (int i = 0; i < pobi.size(); i++) {
            int val = pobi.get(i);
            while (val != 0){
                sum += val % 10;
                mul *= val % 10;
                val /= 10;
            }
        }

        if (sum > mul) {
            max_le = sum;
        }
        else {
            max_le = mul;
        }

        sum = 0;
        mul = 1;
        for (int i = 0; i < crong.size(); i++) {
            int val = crong.get(i);
            while (val != 0){
                sum += val % 10;
                mul *= val % 10;
                val /= 10;
            }
        }
        if (sum > mul) {
            max_ri = sum;
        }
        else {
            max_ri = mul;
        }

        if (max_le == max_ri)
            answer = 0;
        else if (max_le > max_ri) {
            answer = 1;
        }
        else if (max_le < max_ri){
            answer = 2;
        }
        else answer = -1;
        return answer;
    }
}