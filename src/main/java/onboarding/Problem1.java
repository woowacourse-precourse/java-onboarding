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
    public static int calculator(Integer num){
        //입력받은 페이지 번호를 계산을 위해 정수 배열로 변환
        int[] nums= Stream.of(String.valueOf(num).split("")).mapToInt(Integer::parseInt).toArray();
        int sum=0,mul=1;
        for(int n:nums){
            sum+=n;
            mul*=n;
        }
        return Math.max(sum, mul);
    }
    public static boolean exceptionHandler(List<Integer> pobi, List<Integer> crong){
        if(rangeMatch(pobi) || rangeMatch(crong))
            return true;
        if(evenOddMatch(pobi) || evenOddMatch(crong))
            return true;
        if(numberMatch(pobi) || numberMatch(crong))
            return true;
        return false;
    }
    public static boolean rangeMatch(List<Integer> pages){
        return (pages.get(0)<3) || (pages.get(1)>399);
    }
    public static boolean evenOddMatch(List<Integer> pages){
        return (pages.get(0) % 2 != 1) || (pages.get(1) % 2 != 0);
    }
    public static boolean numberMatch(List<Integer> pages){
        return (pages.get(1) - pages.get(0)) != 1;
    }

}