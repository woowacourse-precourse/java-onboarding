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

    /*
     * 리스트의 전체 값을 더하거나, 곱해서 가장 큰 수를 반환하는 함수
     * parameter : List
     * return : int
     * */
    public static int maxNum(List<Integer> list) {
        int result = Integer.max(
                list.stream().reduce(0, Integer::sum),
                list.stream().reduce(1, (a, b) -> a*b));

        return result;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}