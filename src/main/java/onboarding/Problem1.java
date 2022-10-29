package onboarding;

import java.util.List;
import java.util.Random;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
//        openBook(pobi);
//        openBook(crong);
//        int pobiScore, crongScore;
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);
        int answer = getResult(pobiScore, crongScore);
        return answer;
    }
    public static void openBook(List<Integer> list) {
        Random random = new Random();

        while(random.equals(0)| random.equals(1)| random.equals(398)| random.equals(399)){
            random = new Random();
        }

        int randomValue = random.nextInt(399) + 1;

        if (randomValue % 2 == 0) {
            list.add(0, randomValue - 1);
            list.add(1, randomValue);
        } else {
            list.add(0, randomValue);
            list.add(1, randomValue + 1);
        }
    }
    public static int getScore(List<Integer> list) {
        int leftPage = list.get(0);
        int rightPage = list.get(1);
        int addScore = 0, multplyScore = 1;
        int leftResult, rightResult, result;

        while(leftPage != 0) {
            addScore += leftPage%10;
            multplyScore *= leftPage%10;
            leftPage /= 10;
        }
        leftResult = addScore >= multplyScore ? addScore : multplyScore;

        addScore = 0;
        multplyScore = 1;

        while(rightPage != 0) {
            addScore += rightPage%10;
            multplyScore *= rightPage%10;
            rightPage /= 10;
        }
        rightResult = addScore >= multplyScore ? addScore : multplyScore;
        result = leftResult >= rightResult ? leftResult : rightResult;
        return result;
    }
    public static int getResult(int pobi, int crong) {
        if (pobi > crong) {
            return 1;
        } else if (pobi == crong) {
            return 0;
        } else if (pobi < crong) {
            return 2;
        } else {
            return -1;
        }
    }
}