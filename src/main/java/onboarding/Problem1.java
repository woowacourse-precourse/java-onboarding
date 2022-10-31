package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    // 페이지 번호(int)를 받아 배열(int[])로 반환
    private static int[] intToArray(int num){

        return Stream
                .of(String.valueOf(num).split(""))
                .mapToInt(Integer::parseInt).
                toArray();
    }
}