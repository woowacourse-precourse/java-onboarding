package onboarding;

import java.util.List;
/**
 * TODO
 * 1. 책을 임의로 펼친다.v
 * 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
 * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 *
 * end : 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.
 *
 */
class Problem1 {
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    public static final int INPUT_ERROR = -1;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = MAX_VALUE;
        System.out.println(pobi + " " + crong);
        if (validBookNumber(pobi) == -1 || validBookNumber(crong) == -1) {
            return INPUT_ERROR;
        }

        int pobiMaxNumber = pickFriendMaxNumber(pobi);
        int crongMaxNumber = pickFriendMaxNumber(crong);



        return answer;
    }

    public static int pickFriendMaxNumber(List<Integer> friend) {
        return Math.max(calculateMaxNumber(friend.get(0)), calculateMaxNumber(friend.get(1)));
    }

    public static int calculateMaxNumber(Integer num) {
        int multiValue = 1;
        int plusValue = 0;
        String[] splitNum = String.valueOf(num).split("");
        for (String stepNum : splitNum) {
            multiValue *= Integer.parseInt(stepNum);
            plusValue += Integer.parseInt(stepNum);
        }
        if (multiValue > plusValue) {
            return multiValue;
        }
        return plusValue;

    }

    private static int validBookNumber(List<Integer> friend) {
        if (Advice.checkInputDataCount(friend) == -1) {
            return INPUT_ERROR;
        }
        if (Advice.checkInputDataValidRange(friend) == -1) {
            return INPUT_ERROR;
        }
        if (Advice.checkFistEndPage(friend) == -1) {
            return INPUT_ERROR;
        }
        if (Advice.checkEachPageIsSerialize(friend) == -1) {
            return INPUT_ERROR;
        }
        if (Advice.checkPageNumberValidation(friend) == -1) {
            return INPUT_ERROR;
        }
        return MAX_VALUE;
    }
}

class Advice{
    public static final int MAX_VALUE = Integer.MAX_VALUE;
    private Advice(){}

    /**
     * 1. List의 길이가 2가 아닐 때
     */
    public static int checkInputDataCount(final List<Integer> friend) {
        if (friend.size() != 2){
            return -1;
        }
        return MAX_VALUE;
    }

    /**
     * 2. 페이지 수가 요구사항에서 벗어날 때
     */
    public static int checkInputDataValidRange(final List<Integer> friend) {
        Integer isValid = 0;
        for (Integer num : friend) {
            isValid = isValidRange(num);
        }
        return isValid;
    }
    private static Integer isValidRange(final Integer num) {
        if (num <= 0 || num > 400) {
            return -1;
        }
        return MAX_VALUE;
    }

    /**
     * 3. 시작면과 마지막 면이 나올 때
     */
    public static int checkFistEndPage(final List<Integer> friend) {
        if (friend.get(0).equals(1) || friend.get(1).equals(2)) {
            return -1;
        }
        if (friend.get(0).equals(399) || friend.get(1).equals(400)) {
            return -1;
        }
        return MAX_VALUE;
    }

    /**
     * 4. 양 옆 페이지 수가 연속적이지 않을 때
     */
    public static int checkEachPageIsSerialize(final List<Integer> friend) {
        if ((friend.get(0) + 1) != friend.get(1)) {
            return -1;
        }
        return MAX_VALUE;
    }

    /**
     * 5. 왼쪽이 짝수이거나 오른쪽이 홀수일 때
     */
    public static int checkPageNumberValidation(final List<Integer> friend) {
        if (!checkLeftNumber(friend.get(0)) || !checkRightNumber(friend.get(1))){
            return -1;
        }
        return MAX_VALUE;
    }

    private static Boolean checkLeftNumber(Integer leftNumber) {
        return leftNumber % 2 == 1;
    }

    private static Boolean checkRightNumber(Integer rightNumber) {
        return rightNumber % 2 == 0;
    }


}

