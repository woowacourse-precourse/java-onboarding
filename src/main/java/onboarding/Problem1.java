package onboarding;

import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        boolean check1 = validateInput(pobi.get(0), pobi.get(1));
        boolean check2 = validateInput(crong.get(0), crong.get(1));

        answer = -1;
        if (check1 && check2) {

            int pobiScore = findMaxScore(pobi);
            int crongScore = findMaxScore(crong);

            answer = getWinner(pobiScore, crongScore);
        }

        return answer;
    }

    /**
     * Function for validating input conditions
     * */
    public static boolean validateInput(int leftPage, int rightRight) {

        //왼쪽 페이지는 홀수 오른쪽 페이지는 짝수 검증
        if ((leftPage%2) != 1 || (rightRight%2) != 0) {
            return false;
        }

        //왼쪽 페이지와 오른쪽 페이지가 한페이지 차이인지 검증
        if ((leftPage+1) != rightRight) {
            return false;
        }

        //페이지 범위 검증
        if ((leftPage < 1 || leftPage > 400) || (rightRight < 1 || rightRight > 400)) {
            return false;
        }
        return true;
    }

    /**
     * Function for Finding User's Plus score
     * */
    public static int findPlusScore(List<String> scoreList) {
        int score = 0;
        score += scoreList.stream().mapToInt(Integer::parseInt).sum();
        return score;
    }

    /**
     * Function for Finding User's Multiple score
     * */
    public static int findMultipleScore(List<String> scoreList) {
        int score = 1;
        score *= scoreList.stream().mapToInt(Integer::parseInt).reduce(1, (a, b) -> a * b);
        return score;
    }

    /**
     * Function for Finding User's Max score
     * */
    public static int findMaxScore(List<Integer> user) {

        List<String> leftPage = Arrays.asList(user.get(0).toString().split(""));
        int leftScore = Math.max(findPlusScore(leftPage), findMultipleScore(leftPage));

        List<String> rightPage = Arrays.asList(user.get(1).toString().split(""));
        int rightScore = Math.max(findPlusScore(rightPage), findMultipleScore(rightPage));

        return Math.max(leftScore, rightScore);
    }

    /**
     * Function for Finding Winner
     * */
    private static int getWinner(int pobiScore, int crongScore) {
        int answer = -1;
        if (pobiScore > crongScore) {
            answer = 1;
        } else if (pobiScore < crongScore) {
            answer = 2;
        } else {
            answer = 0;
        }
        return answer;
    }
}