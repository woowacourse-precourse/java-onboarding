package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    static boolean book_range_check(int left, int right) {
        if(left<=2 || right<=2 || left>=399 || right >=399){
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

    static int max_number(int num) {
        int sum =-1;
        int multiple =-1;

        while (num>0){
            sum += num%10;
            multiple *= num%10;

            num /=10;
        }

        return Math.max(sum,multiple);
    }

}

