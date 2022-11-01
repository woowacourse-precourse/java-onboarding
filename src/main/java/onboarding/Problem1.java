package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobi_num = 0; int crong_num = 0;
        if (pobi.get(0)+1 != pobi.get(1)){
            return -1;
        }
        if (crong.get(0)+1 != crong.get(1)){
            return -1;
        }
        for (Integer page:pobi){
            int sum = 0; int mul = 1;
            while (page > 0) {
                sum += page%10;
                mul *= page%10;
                page/=10;
            }
            if (sum > mul) {
                if (pobi_num < sum) {
                    pobi_num = sum;
                }
            }
            else {
                if (pobi_num < mul) {
                    pobi_num = mul;
                }
            }
        }

        for (Integer page:crong){
            int sum = 0; int mul = 1;
            while (page > 0) {
                sum += page%10;
                mul *= page%10;
                page/=10;
            }
            if (sum > mul) {
                if (crong_num < sum) {
                    crong_num = sum;
                }
            }
            else {
                if (crong_num < mul) {
                    crong_num = mul;
                }
            }
        }
        int answer;
        if (pobi_num > crong_num){
            answer = 1;
        }
        else if (crong_num > pobi_num) {
            answer = 2;
        }
        else {
            answer = 0;
        }
        return answer;
    }
}