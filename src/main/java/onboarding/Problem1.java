package onboarding;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        return answer;
    }

    private static int calculatePersonalScore(List<Integer> page){
        int left = calculateSingePageScore(page.get(0));
        int right = calculateSingePageScore(page.get(1));

        if(left > right)
            return left;
        else
            return right;
    }

    private static int calculateSingePageScore(int number){
        int[] tokenizedNumber = tokenize(Integer.toString(number));

        // init
        int product = tokenizedNumber[0];
        int plus = tokenizedNumber[0];

        // 모든 자리수를 더한 값과 곱한 값을 계산
        for(int i = 1; i < tokenizedNumber.length; i++){
            product = product * tokenizedNumber[i];
            plus = plus + tokenizedNumber[i];
        }

        // 더 큰 값을 반환
        if(product > plus)
            return product;
        else
            return plus;
    }

    private static int[] tokenize(String number){
        String[] strArray = number.split("");

        int[] intArray = Arrays.stream(strArray)
                .mapToInt(Integer::parseInt)
                .toArray();

        return intArray;
    }
}