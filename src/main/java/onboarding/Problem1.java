package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (checkInput(pobi.get(0), pobi.get(1)) || checkInput(crong.get(0), crong.get(1)))
            return -1;

        //todo: 점수 계산, 승부 발표
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private static boolean checkInput(int left, int right){
        if (left < 1 || left > 400 || right < 1 || right > 400)
            return true;
        if (left % 2 == 0 || right % 2 == 1)
            return true;
        return right - left != 1;
    }

}