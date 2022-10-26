package onboarding;

import java.util.ArrayList;
import java.util.List;

import static onboarding.PageNumber.*;
import static onboarding.PageNumber.makeRandomNumber;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}

class Book {
    private final int pageStart;
    private final int pageEnd;

    private static final int defaultPageStart = 0;
    private static final int defaultPageEnd = 400;

    private static void validatePageStart(int pageStart) {
        if (pageStart % 2 == 0) {
            throw new IllegalArgumentException("페이지 번호 게임을 위해서는 시작 페이지가 홀수여야 합니다!");
        }
    }

    private static void validatePageEnd(int pageEnd) {
        if (pageEnd % 2 != 0) {
            throw new IllegalArgumentException("페이지 번호 게임을 위해서는 종료 페이지가 짝수여야 합니다!");
        }
    }

    Book(int pageStart, int pageEnd) {
        validatePageStart(pageStart);
        validatePageEnd(pageEnd);
        this.pageStart = pageStart;
        this.pageEnd = pageEnd;
    }

    Book() {
        this(defaultPageStart, defaultPageEnd);
    }

    Book(int pageEnd) {
        this(defaultPageStart, pageEnd);
    }

    public int getPageStart() {
        return pageStart;
    }

    public int getPageEnd() {
        return pageEnd;
    }
}

class User {
    private final String name;
    private final List<Integer> choiceNumbers = new ArrayList<>();

    private int score;

    public String getName() {
        return name;
    }

    public int getScore() {
        if (this.score != 0) {
            return this.score;
        }
        int left = choiceNumbers.get(0);
        int right = choiceNumbers.get(1);
        List<Integer> digitLeft = getDigit(left);
        List<Integer> digitRight = getDigit(right);
        int score = maxResult(digitLeft, digitRight);
        this.score = score;
        return score;
    }

    User(String name) {
        this.name = name;
    }

    public List<Integer> choiceRandomNumbers(int pageStart, int pageEnd) {
        int randomNumber = makeRandomNumber(pageStart, pageEnd);
        assignRandomNumber(choiceNumbers, randomNumber);
        return choiceNumbers;
    }

    private void assignRandomNumber(List<Integer> choiceNumbers, int randomNumber) {
        if (randomNumber % 2 == 0) {
            choiceNumbers.add(randomNumber - 1);
            choiceNumbers.add(randomNumber);
        } else {
            choiceNumbers.add(randomNumber);
            choiceNumbers.add(randomNumber + 1);
        }
    }

    private int maxResult(List<Integer> digitLeft, List<Integer> digitRight) {
        int digitPlusLeft = digitPlus(digitLeft);
        int digitMultipleLeft = digitMultiple(digitLeft);
        int digitPlusRight = digitPlus(digitRight);
        int digitMultipleRight = digitMultiple(digitRight);
        int arr[] = {digitPlusLeft, digitMultipleLeft, digitPlusRight, digitMultipleRight};
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}

class PageNumber {
    static int makeRandomNumber(int pageStart, int pageEnd) {
        boolean pass = false;
        int randomNumber = 0;
        while (!pass) {
            randomNumber = (int) (Math.random() * pageEnd) - 1;
            boolean checkRandomNumber = checkRandomNumber(randomNumber, pageStart);
            if (checkRandomNumber) {
                pass = true;
            }
        }
        return randomNumber;
    }
    private static boolean checkRandomNumber(int randomNumber, int pageStart) {
        if (randomNumber == pageStart) {
            return false;
        }
        if (randomNumber == pageStart + 1) {
            return false;
        }
        return true;
    }

    static List<Integer> getDigit(int number) {
        ArrayList<Integer> digit = new ArrayList<>();
        for (int i = getDigitCount(number); i > 0; i--) {
            digit.add(number / (int) Math.pow(10, i - 1) % 10);
        }
        return digit;
    }

    private static int getDigitCount(int number) {
        int digitCount = 1;
        boolean pass = false;
        while (!pass) {
            if (number / 10 != 0) {
                digitCount++;
                number = number / 10;
            }
        }
        return digitCount;
    }

    static int digitPlus(List<Integer> digit) {
        int sum = 0;
        for (int i = 0; i < digit.size(); i++) {
            sum += digit.get(i);
        }
        return sum;
    }

    static int digitMultiple(List<Integer> digit) {
        int multiple = 1;
        for (int i = 0; i < digit.size(); i++) {
            multiple *= digit.get(i);
        }
        return multiple;
    }
}

class Referee {
    private final String DEFUALTUSER1 = "pobi";
    private final String DEFUALTUSER2 = "crong";

    public int judge(User user1, User user2) {
        if (user1.getScore() == user2.getScore()) {
            return 0;
        }
        String winnerName = winnerName(user1, user2);
        if (winnerName == DEFUALTUSER1) {
            return 1;
        }
        if (winnerName == DEFUALTUSER2) {
            return 2;
        }
        return -1;
    }

    private String winnerName(User user1, User user2) {
        if (user1.getScore() > user2.getScore()) {
            return user1.getName();
        }
        return user2.getName();
    }
}
