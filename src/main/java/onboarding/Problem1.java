package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 예외 사항이 있다면 -1 리턴
        if(checkException(pobi, crong)) {
            answer = -1;
            return answer;
        }

        return answer;
    }
    // 예외 사항이 있는지 검사하는 메서드
    static boolean checkException(List<Integer> pobi, List<Integer> crong) {
        boolean pobiException = false;
        boolean crongException = false;
        for (int i = 0; i < 2; i++) {
            if(pobi.get(1) - pobi.get(0) != 1) {
                pobiException = true;
            }
            if(crong.get(1) - crong.get(0) != 1) {
                crongException = true;
            }
        }
        return pobiException || crongException;
    }
}