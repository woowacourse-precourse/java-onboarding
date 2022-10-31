package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiMax = 0;
        int crongMax = 0;

        pobiMax = maxScore(pobi);
        crongMax = maxScore(crong);

        return answer;
    }

    static int maxScore(List<Integer> list) {
        int sum=0;
        int multiple=0;

        for(int number:list) {
            int[] numArray = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
            sum = Math.max(sum, sumCal(numArray));
            multiple = Math.max(multiple, mulCal(numArray));
        }

        return Math.max(sum, multiple);
    }

    static int sumCal(int[] array){
        int sum=0;
        for (int num:array) {
            sum+=num;
        }

        return sum;
    }

    static int mulCal(int[] array){
        int multiple=1;
        for (int num:array) {
            multiple*=num;
        }

        return multiple;
    }

}