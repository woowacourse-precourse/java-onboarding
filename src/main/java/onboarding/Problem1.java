package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    /**
     * 숫자의 각 자릿수 합과 곱 중 최댓값을 반환하는 함수
     * @param number
     * @return the maximum value of the sum and product of each digit of a number
     */
    public static int getMaxValueInHapGop(int number){

        int[] arrNum = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();

        int hap = Arrays.stream(arrNum).reduce(0, (int a, int b) -> a + b);
        int gop = Arrays.stream(arrNum).reduce(1, (int a, int b) -> a * b);
        return Math.max(hap, gop);
    }

    /**
     * 두 개의 연속된 숫자가 들어있는 배열 2개가 입력으로 주어짐.
     * 해당 조건을 만족하지 않는 경우 -1 반환
     * 이후에는 조건에 맞는 결과 반환
     * @param pobi
     * @param crong
     * @return 2(crong wins), 1(pobi wins), 0(draw), -1(exception)
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (pobi.get(0) + 1 != pobi.get(1) || pobi.get(0) % 2 != 1) {
            return -1;
        }

        if (crong.get(0) + 1 != crong.get(1) || crong.get(0) % 2 != 1) {
            return -1;
        }

        for (int i=0; i < 1; i++) {
            int p = pobi.get(i);
            int c = crong.get(i);
            int pobiMax = Math.max(getMaxValueInHapGop(p), getMaxValueInHapGop(p+1));
            int crongMax = Math.max(getMaxValueInHapGop(c), getMaxValueInHapGop(c+1));

            if (pobiMax > crongMax) {
                answer = 1;
            }
            else if (pobiMax < crongMax) {
                answer = 2;
            }
            else {
                answer = 0;
            }
        }
        System.out.println(answer);
        return answer;
    }

//    public static void main(String[] args) {
//        List<Integer> pobi = new ArrayList<>();
//        List<Integer> crong = new ArrayList<>();
//
//        pobi.add(110);
//        pobi.add(111);
//
//        crong.add(21);
//        crong.add(22);
//
//        Problem1 prob = new Problem1();
//        int result = prob.solution(pobi, crong);
//    }
}