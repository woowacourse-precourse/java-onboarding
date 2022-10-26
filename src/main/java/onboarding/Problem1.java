package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiScore = getMaxValue(pobi);
        int crongScore = getMaxValue(crong);

        if(isExceptionPage(pobiScore, crongScore)){
            return -1;
        }

        if(pobiScore > crongScore){
            answer = 1;
        }
        else if(pobiScore < crongScore){
            answer = 2;
        }
        else{
            answer = 0;
        }

        return answer;
    }

    private static int getMaxValue(List<Integer> list) {
        // 양쪽 페이지의 차이는 무조건 1이여야 함
        if(Math.abs(list.get(0) - list.get(1)) != 1){
            return -1;
        }

        int result = 0;

        int getSum = 0;
        List<Integer> temp = List.of();
        for (int num: list){

        }

        int getMul = 0;

        if(getSum > getMul){
            result = getSum;
        }
        else{
            result = getMul;
        }

        return result;
    }

    private static boolean isExceptionPage(int pobiScore, int crongScore) {
        if(pobiScore == -1 || crongScore == -1)
            return true;
        return false;
    }
}