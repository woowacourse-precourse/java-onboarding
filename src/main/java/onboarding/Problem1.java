package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        myfunc01 mf= new myfunc01(); // 메소드 임포트
        return answer;
    }
    public static class myfunc01 {
        // 분리가 된 자릿수를 더하는 기능
        int sum(List<Integer> nums) {
            return (int) nums.stream().reduce((x, y) -> x + y).stream().toArray()[0];
        }
    }
}