package onboarding;

import java.util.List;

/* 기능 목록
  1. 입력값 예외처리
  2. 포비와 크롱의 최대 점수를 비교
  3. 각 자리 숫자를 모두 더하기
  4. 각 자리 숫자를 모두 곱하기  */

class Problem1 {

    // 입력 예외처리
    public static void inputException(List<Integer> pobi, List<Integer> crong) throws Exception {
        if (pobi.get(1) - pobi.get(0) != 1 || crong.get(1) - crong.get(0) != 1) throw new Exception();
        if (pobi.get(0) < 0 || pobi.get(1) > 400) throw new Exception();
        if (crong.get(0) < 0 || crong.get(1) > 400) throw new Exception();
        if (pobi.get(0) % 2 != 1 || crong.get(0) % 2 != 1) throw new Exception();
        if (pobi.get(1) % 2 != 0 || crong.get(1) % 2 != 0) throw new Exception();
        if (pobi.size() != 2 || crong.size() != 2) throw new Exception();
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;

        try {
            inputException(pobi, crong);
        } catch (Exception e) {
            return answer;
        }
        
        return answer;
    }
}