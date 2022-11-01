package onboarding;

import java.util.List;
import java.util.Objects;

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
        if (validate(pobi) == -1 || validate(crong) == -1) {
            return INPUT_ERROR;
        }

        answer = Result.getWinner(new Friend(pobi), new Friend(crong));

        return answer;
    }

    private static int validate(final List<Integer> friend) {
        return Advice.validBookNumber(friend);
    }

    static class Result{
        private Result(){}

        public static int getWinner(Friend pobiFriend, Friend crongFriend) {
            if (pobiFriend.getMaxNumber() == crongFriend.getMaxNumber()) {
                return 0;
            }else if (pobiFriend.getMaxNumber() > crongFriend.getMaxNumber()) {
                return 1;
            } else {
                return 2;
            }
        }
    }

    static class Friend{
        private final int maxNumber;

        public Friend(final List<Integer> bookNumbers) {
            this.maxNumber = getMaxNumber(bookNumbers);
        }

        private int getMaxNumber(final List<Integer> bookNumbers) {
            return Math.max(calculateMaxNumber(bookNumbers.get(0)), calculateMaxNumber(bookNumbers.get(1)));
        }

        private int calculateMaxNumber(final Integer number) {
            String[] splitNumber =  String.valueOf(number).split("");
            return Math.max(calculateMultiplication(splitNumber), calculatePlus(splitNumber));
        }
        private int calculatePlus(String[] splitNumber) {
            int tmpNumber = 0;
            for (String step : splitNumber) {
                tmpNumber += Integer.parseInt(step);
            }
            return tmpNumber;
        }
        private int calculateMultiplication(String[] splitNumber) {
            int tmpNumber = 1;
            for (String step : splitNumber) {
                tmpNumber *= Integer.parseInt(step);
            }
            return tmpNumber;
        }

        public int getMaxNumber() {
            return maxNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Friend friend = (Friend)o;
            return maxNumber == friend.maxNumber;
        }

        @Override
        public int hashCode() {
            return Objects.hash(maxNumber);
        }
    }


    static class Advice{
        public static final int MAX_VALUE = Integer.MAX_VALUE;
        private Advice(){}
        public static int validBookNumber(final List<Integer> friend) {
            if (checkInputDataCount(friend) == -1) {
                return INPUT_ERROR;
            }
            if (checkInputDataValidRange(friend) == -1) {
                return INPUT_ERROR;
            }
            if (checkFistEndPage(friend) == -1) {
                return INPUT_ERROR;
            }
            if (checkEachPageIsSerialize(friend) == -1) {
                return INPUT_ERROR;
            }
            if (checkPageNumberValidation(friend) == -1) {
                return INPUT_ERROR;
            }
            return MAX_VALUE;
        }

        private static int checkInputDataCount(final List<Integer> friend) {
            if (friend.size() != 2){
                return -1;
            }
            return MAX_VALUE;
        }

        private static int checkInputDataValidRange(final List<Integer> friend) {
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

        private static int checkFistEndPage(final List<Integer> friend) {
            if (friend.get(0).equals(1) || friend.get(1).equals(2)) {
                return -1;
            }
            if (friend.get(0).equals(399) || friend.get(1).equals(400)) {
                return -1;
            }
            return MAX_VALUE;
        }

        private static int checkEachPageIsSerialize(final List<Integer> friend) {
            if ((friend.get(0) + 1) != friend.get(1)) {
                return -1;
            }
            return MAX_VALUE;
        }

        private static int checkPageNumberValidation(final List<Integer> friend) {
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
}



