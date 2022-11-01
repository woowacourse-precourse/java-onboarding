package onboarding;

import java.util.List;

class Problem1 {
    //유효한 인자 확인
    public static boolean isVaildInput(List<Integer> list){
        if (list.get(1) - list.get(0) != 1 || (list.get(0) % 2 != 1) || (list.get(1) % 2 != 0) || list.size() != 2)
            return false;
        else if(list.get(0) < 0 || list.get(0) > 400 || list.get(1) < 0 || list.get(1) > 400)
            return false;
        else
            return true;
    }
    //각 페이지의 최대값 만들기
    public static int getMaxValue(List<Integer> list) {
        int leftMax;
        int rightMax;

        leftMax = calculateMax(list.get(0));
        rightMax = calculateMax(list.get(1));
        return (leftMax > rightMax) ? leftMax : rightMax;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}