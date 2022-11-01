package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    static int left = 0, right = 1;
    static boolean isAvail(List<Integer> player) {
        int leftPage = player.get(0);
        int rightPage = player.get(1);
        return leftPage > 1 && rightPage < 400 && (rightPage - leftPage == 1);
    }
    static int calculateScore(List<Integer> player, int dir) {
        int[] Page = Stream.of(String.valueOf(player.get(dir)).split("")).mapToInt(Integer::parseInt).toArray();
        int sumScore = 0;
        int multipleScore = 1;
        for(int num : Page) {
            sumScore += num;
            multipleScore *= num;
        }
        return Math.max(sumScore, multipleScore);

    }

    static int getScore(List<Integer> player) {
        int leftScore = calculateScore(player, left);
        int rightScore = calculateScore(player, right);

        return Math.max(leftScore, rightScore);
    }
    static int playGame(List<Integer> pobi, List<Integer> crong) {
        if(!(isAvail(pobi) && isAvail(crong))) {
            return -1;
        }
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if(pobiScore > crongScore) {
            return 1;
        }
        if(pobiScore < crongScore) {
            return 2;
        }
        if(pobiScore == crongScore) {
            return 0;
        }
        return -1;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = playGame(pobi, crong);
        return answer;
    }
}