package onboarding;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Problem1 {

    // 어떤 값을 낼지 결정하는 함수
    public static int maxComparator(List<Integer> list) {
        int sum = 0;
        int mul = 0;
        int max = 0;
        int previous = list.get(0)-1;
        for (int var : list) {
            if (previous+1 == var) {
                int[] arrNum = Stream.of(String.valueOf(var).split("")).mapToInt(Integer::parseInt).toArray();
                sum = Arrays.stream(arrNum).sum();
                mul = multipleCalculator(arrNum);

                if (sum > mul) { max = sum; }
                else { max = mul; }

                previous = var;
            }
            else { max = -1; break; }
        }
        return max;
    }


    // 각 자리 곱셈은 따로 계산하기 위해 별도의 함수 생성
    public static int multipleCalculator(int[] arr) {
        int mul = 1;
        for (int var : arr) {
            mul *= var;
        }
        return mul;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        int pobiAnswer = maxComparator(pobi);
        int crongAnswer = maxComparator(crong);

        if (pobiAnswer == -1 || crongAnswer == -1 ) { answer = -1; }
        else {
            switch (Integer.compare(pobiAnswer, crongAnswer)) {
                case 1:
                    answer = 1;
                    break;
                case 0:
                    answer = 0;
                    break;
                case -1:
                    answer = 2;
                    break;
                default:   // exception은 -1 출력
                    answer = -1;
                    break;
            }
        }

        return answer;
    }
}