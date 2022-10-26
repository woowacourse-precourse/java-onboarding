package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외의 경우 처리
        if(!validChk(pobi) || !validChk(crong)) return answer = -1;

        return answer;
    }
    /**
     * 예외처리 함수
     * @param list
     * @return {boolean}
     */
    public static boolean validChk(List<Integer> list) {
        if(list.get(1) - list.get(0) > 1) return false;
        else if(list.contains(400) || list.contains(1)) return false;
        return true;
    }
}