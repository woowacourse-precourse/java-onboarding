package onboarding;

import java.util.List;

class Problem1 {
    /*
        calculate
        % input : page list [int, int]
        % output : result    int

        calculate sum, mul
        return larger value
     */
    public static int calculate(List<Integer> numbs){
        int res = 0;

        for(int i = 0; i < 2; i ++){
            int sum = 0;
            int mul = 1;
            int n = numbs.get(i);
            while(n > 0) {
                sum += n % 10;
                mul *= n % 10;
                n /= 10;
            }
            res = Math.max(Math.max(sum, mul), res);
        }

        return res;
    }
    /*
        check_except
        % input : page list [int, int]
        % output : boolean

        if list[1] - list[0] -> wrong page
     */
    public static boolean check_except(List<Integer> numbs){
        if(numbs.get(1) - numbs.get(0) != 1) return false;
        return true;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // if wrong page return -1
        if(!check_except(pobi)) return -1;
        if(!check_except(crong)) return -1;

        return answer;
    }
}