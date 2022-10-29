package onboarding;

import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        openBook(pobi);
        openBook(crong);
        int answer = Integer.MAX_VALUE;
        return answer;
    }
    public static void openBook(List<Integer> list) {
        Random random = new Random();

        while(random.equals(0)| random.equals(1)| random.equals(398)| random.equals(399)){
            random = new Random();
        }

        int randomValue = random.nextInt(399) + 1;

        if (randomValue % 2 == 0) {
            list.add(randomValue - 1);
            list.add(randomValue);
        } else {
            list.add(randomValue);
            list.add(randomValue + 1);
        }
    }
//    public static int getScore() {}
//    public static int result() {}
}