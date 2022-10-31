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

    // 번호 배열을 받아 합 점수를 반환
    private static int add(int [] arrNum){

        int result = 0;
        for(int i = 0; i < arrNum.length; i++) {
            result += arrNum[i];
        }
        return result;
    }

    // 번호 배열을 받아 곱 점수를 반환
    private static int product(int [] arrNum){

        int result = 1;
        for(int i = 0; i < arrNum.length; i++){
            result *= arrNum[i];
        }
        return result;
    }
}