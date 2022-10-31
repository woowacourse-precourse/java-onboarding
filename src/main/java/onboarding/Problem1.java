package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        int large_pobi, large_crong;

        // exception check
        if(!page_check(pobi, crong)) {
            answer = -1;
            return answer;
        }

        // calculate large number
        large_pobi = large_num(pobi);
        large_crong = large_num(crong);

        //compare large number
        if(large_pobi - large_crong > 0) answer = 1;
        else if(large_crong - large_pobi < 0) answer = 2;
        else answer = 0;

        return answer;
    }

    // exception check
    private static boolean page_check(List<Integer> list_1, List<Integer> list_2) {
        if(list_1.get(1) - list_1.get(0) == 1 && list_2.get(1) - list_2.get(0) == 1){
            return !list_1.contains(1) && !list_1.contains(400) && !list_2.contains(1) && !list_2.contains(400);
        }
        else return false;
    }

    // calculate large number
    private static int large_num(List<Integer> list) {
        int large1, large2, num1, num2, num3, num4;

        num1 = num_plus(list.get(0)); // plus result out
        num2 = num_multi(list.get(0)); // multiply result out
        num3 = num_plus(list.get(1)); // plus result out
        num4 = num_multi(list.get(1)); // multiply result out

        large1 = Math.max(num1, num2); // compare left page result
        large2 = Math.max(num3, num4); // compare right page result

        // compare left page result and right page result
        return Math.max(large1, large2);
    }

    private static int num_plus(int num){
        int digit1, digit2, digit3;

        digit1 = num%1000 - num%100;
        digit2 = num%100 - num%10;
        digit3 = num%10;

        return digit1+digit2+digit3;
    }

    private static int num_multi(int num){
        int digit1, digit2, digit3;

        digit1 = num%1000 - num%100;
        digit2 = num%100 - num%10;
        digit3 = num%10;
        if(digit1 == 0) digit1 = 1;

        return digit1*digit2*digit3;
    }
}