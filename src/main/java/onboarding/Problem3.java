package onboarding;

import java.util.Arrays;
import java.util.stream.Stream;

public class Problem3 {
    /**
     * 1 ~ number 까지 3, 6, 9가 포함된 숫자 개수 세는 함수
     * @param number
     * @return Number of numbers with 3, 6, 9
     */
    public static int solution(int number) {
        int answer = 0;
        for (int i=1; i <= number; i++) {
            int[] arrNum = Stream.of(String.valueOf(i).split("")).mapToInt(Integer::parseInt).toArray();

            int[] game = new int[]{3, 6, 9};
            for (int val: arrNum) {
                if (Arrays.stream(game).anyMatch(v -> v == val)) {
                    answer++;
                }
            }
        }
        return answer;
    }
//    public static void main(String[] args) {
//        Problem3 prob = new Problem3();
//        int number = 14;
////        System.out.println(cryptogram);
//        int result = prob.solution(number);
//        System.out.println(result);
//    }
}
