package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    private static final int DRAW=0;
    private static final int POBI_WIN = 1;
    private static final int CRONG_WIN = 2;
    private static final int EXCEPTION = -1;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer=Integer.MAX_VALUE;
        if(exceptionHandler(pobi, crong))
            return EXCEPTION;
        return answer;
    }

    public static boolean exceptionHandler(List<Integer> pobi, List<Integer> crong){
        return false;
    }

}