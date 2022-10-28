package onboarding;

import java.util.List;

class Problem1 {
    public static int getPageMaxValue(int pageNum){
        int plus = 0;
        int mul = 1;
        while(pageNum > 0){
            plus += pageNum%10;
            mul *= pageNum%10;
            pageNum /= 10;
        }
        return Math.max(plus,mul);
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int p_left = getPageMaxValue(pobi.get(0));
        int p_right = getPageMaxValue(pobi.get(1));
        int p_max = Math.max(p_left,p_right);

        int c_left = getPageMaxValue(crong.get(0));
        int c_right = getPageMaxValue(crong.get(1));
        int c_max = Math.max(c_left,c_right);

        return answer;
    }
}