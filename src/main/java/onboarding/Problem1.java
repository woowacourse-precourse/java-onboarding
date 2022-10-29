package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    private ArrayList<Integer> drawTwoNumbersInRow() {
        Random random = new Random(); //랜덤 객체 생성(디폴트 시드값 : 현재시간)
        random.setSeed(System.currentTimeMillis());
        int randomNumber = 2 * (random.nextInt(197) + 1) + 1;
        ArrayList<Integer> result = new ArrayList<>();
        result.add(randomNumber, randomNumber + 1);
        return result;
    }

    private int[] splitEachNumbers(int number) {
        int[] arrNum = Stream.of(String.valueOf(number).split("")).mapToInt(Integer::parseInt).toArray();
        return arrNum;
    }
}