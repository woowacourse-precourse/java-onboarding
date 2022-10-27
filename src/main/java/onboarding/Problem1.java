package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    /**
     * 리스트의 문자열을 나눠서 배열에 저장하는 함수
     * 배열에서 문자열을 더하거나 곱해서 나온 숫자 중 가장 큰 수를 뽑는 함수
     * 가장 큰 수 끼리 비교하는 함수
     * 예외사항
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /*
     *리스트의 문자열을 나눠서 배열에 저장하는 함수
     */
    static List<Integer> splitList(int number) {
        List<Integer> split = new ArrayList<>();
        while(number != 0){
            split.add(number % 10);
            number = number/10;
        }
        return split;
    }
}