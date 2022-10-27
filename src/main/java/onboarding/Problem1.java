package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

     /*
     * 페이지 번호의 각 자리 숫자의 값을 리스트로 반환하는 함수
     * parameter : int
     * return : List<Integer>
     * */
    public static List<Integer> toList(int x) {
        List<Integer> output = new ArrayList<>();
        while(x != 0) {
            output.add(x % 10);
            x = x / 10;
        }
        return output;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}