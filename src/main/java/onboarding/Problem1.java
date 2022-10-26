package onboarding;

import java.util.List;

class Problem1 {

    public static boolean checkException(int n1, int n2){
        if(n1%2 == 1 && n2%2 == 0) {
            if (n2 - n1 == 1){
                if( (n1 != 1 && n2 != 2) && (n1 != 399 && n2 != 400) )
                    return true;
            }
        }
        return false;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}