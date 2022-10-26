package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    static boolean book_range_check(int left, int right) {
        if(left<0 || right<0 || left>400 || right >400){
            return false;
        }
        if(left%2 != 1 || right%2 != 0) {
            return false;
        }
        if(left+1 != right){
            return false;
        }
        return true;
    }
}
