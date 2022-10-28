package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        if (check(pobi) && check(crong)) {

        }
        return -1;

    }
    /* 기능1 : input 확인 */
    private static boolean check(List<Integer> list) {
        if (isCountTwo(list) && isLeftOdd(list) && isRightEven(list) && isConsecutive(list) && isInBook(list)) return true;
        return false;
    }

    private static boolean isCountTwo(List<Integer> list){
        if(list.size() == 2) return true;
        return false;
    }

    private static boolean isLeftOdd(List<Integer> list){
        if (list.get(0) % 2 == 1) return true;
        return false;
    }

    private static boolean isRightEven(List<Integer> list){
        if (list.get(1) % 2 == 0) return true;
        return false;
    }

    private static boolean isConsecutive(List<Integer> list){
        if (list.get(1) - list.get(0) == 1) return true;
        return false;
    }

    private static boolean isInBook(List<Integer> list){
        if(Math.max(list.get(0),list.get(1)) < 400 && Math.min(list.get(0),list.get(1)) > 1) return true;
        return false;
    }


    /* 기능2 : 각 자리 숫자를 더하는 기능 */
    private static int SumPage(int Page){
        int sum = 0;
        while(Page > 0){
            sum += Page % 10;
            Page /= 10;
        }
        return sum;
    }

    /* 기능3 : 각 자리 숫자를 곱하는 기능 */
    private static int MultiPage(int Page){
        int multi = 1;
        while(Page > 0){
            multi *= Page % 10;
            Page /= 10;
        }
        return multi;
    }


}