package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean validateInput(List<Integer> input){
        if (input == null) {
            // 페이지 번호가 null 인지 확인
            return false;
        }else if (input.get(0) == 0 && input.get(0)>= 400 && input.get(1) == 0 && input.get(1)>= 400){
            // 페이지의 범위가 1-400 인지 확인
            return false;
        }else if (input.get(0) % 2 != 1 || input.get(1) != input.get(0)+1) {
            // 왼쪽 페이지 번호가 홀수이고, 오른쪽 페이지 번호가 왼쪽 페이지 번호 + 1 인지 확인
            return false;
        }
        return true;
    }
}