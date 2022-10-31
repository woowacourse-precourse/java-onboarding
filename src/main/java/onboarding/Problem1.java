package onboarding;

import java.util.ArrayList;
import java.util.List;

import static onboarding.PageNumber.*;
import static onboarding.PageNumber.makeRandomNumber;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        Referee1 referee = new Referee1();
        try {
            int pobiScore = referee.giveScore(pobi);
            int crongScore = referee.giveScore(crong);
            answer = referee.judge(pobiScore, crongScore);
            return answer;
        } catch (IllegalStateException e) {
            return -1;
        }
    }

    public static void main(String[] args) {
        Game1.start("pobi", "crong");
        int result = solution(Game1.user1.getChoiceNumbers(), Game1.user2.getChoiceNumbers());
        Game1.end(result);
    }
}

class Game1 {
    static User1 user1;
    static User1 user2;

    static void start() {
        Book book = new Book();
        user1 = new User1("pobi");
        user2 = new User1("crong");
        user1.choiceRandomNumbers(book.getPageStart(), book.getPageEnd());
        user2.choiceRandomNumbers(book.getPageStart(), book.getPageEnd());
    }

    static void start(String name1, String name2) {
        Book book = new Book();
        user1 = new User1(name1);
        user2 = new User1(name2);
        user1.choiceRandomNumbers(book.getPageStart(), book.getPageEnd());
        user2.choiceRandomNumbers(book.getPageStart(), book.getPageEnd());
    }

    static void start(int pageEnd, String name1, String name2) {
        Book book = new Book(pageEnd);
        user1 = new User1(name1);
        user2 = new User1(name2);
        user1.choiceRandomNumbers(book.getPageStart(), book.getPageEnd());
        user2.choiceRandomNumbers(book.getPageStart(), book.getPageEnd());
    }

    static void start(int pageStart,int pageEnd, String name1, String name2) {
        Book book = new Book(pageStart,pageEnd);
        user1 = new User1(name1);
        user2 = new User1(name2);
        user1.choiceRandomNumbers(book.getPageStart(), book.getPageEnd());
        user2.choiceRandomNumbers(book.getPageStart(), book.getPageEnd());
    }

    static void end(int result) {
        OutView1.printHead(user1, user2);
        OutView1.printResult(user1, user1, result);
    }
}

class Book {
    private final int pageStart;
    private final int pageEnd;

    private static final int defaultPageStart = 1;
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

class User1 {
    private final String name;
    private final List<Integer> choiceNumbers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public List<Integer> getChoiceNumbers() {
        return choiceNumbers;
    }

    User1(String name) {
        this.name = name;
    }

    public List<Integer> choiceRandomNumbers(int pageStart, int pageEnd) {
        int randomNumber = makeRandomNumber(pageStart, pageEnd);
        assignRandomNumber(randomNumber);
        return choiceNumbers;
    }

    private void assignRandomNumber(int randomNumber) {
        if (randomNumber % 2 == 0) {
            choiceNumbers.add(randomNumber - 1);
            choiceNumbers.add(randomNumber);
        } else {
            choiceNumbers.add(randomNumber);
            choiceNumbers.add(randomNumber + 1);
        }
    }
}

class PageNumber {
    static int makeRandomNumber(int pageStart, int pageEnd) {
        boolean pass = false;
        int randomNumber = 0;
        while (!pass) {
            randomNumber = (int) (Math.random() * pageEnd) + 1;
            boolean checkRandomNumber = checkRandomNumber(randomNumber, pageStart, pageEnd);
            if (checkRandomNumber) {
                pass = true;
            }
        }
        return randomNumber;
    }
    private static boolean checkRandomNumber(int randomNumber, int pageStart, int pageEnd) {
        if (randomNumber == pageStart) {
            return false;
        }
        if (randomNumber == pageStart + 1) {
            return false;
        }
        if (randomNumber == pageEnd) {
            return false;
        }
        if (randomNumber == pageEnd - 1) {
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
            } else {
                pass = true;
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

class Referee1 {
    private final String DEFUALTUSER1 = "pobi";
    private final String DEFUALTUSER2 = "crong";

    public int judge(int user1Score, int user2Score) {
        if (user1Score == user2Score) {
            return 0;
        }
        if (user1Score > user2Score) {
            return 1;
        }
        if (user1Score < user2Score) {
            return 2;
        }
        return -1;
    }

    public int giveScore(List<Integer> choiceNumbers) {
        int left = choiceNumbers.get(0);
        int right = choiceNumbers.get(1);
        if (left + 1 != right) {
            throw new IllegalStateException("연속된 숫자를 선택해주세요");
        }
        List<Integer> digitLeft = getDigit(left);
        List<Integer> digitRight = getDigit(right);
        return maxResult(digitLeft, digitRight);
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

class OutView1 {
    static void printHead(User1 user1, User1 user2) {
        System.out.println(user1.getName() + "\t" + user2.getName() + "\t" + "result");
    }

    static void printResult(User1 user1, User1 user2, int result) {
        System.out.println(user1.getChoiceNumbers() + "\t" + user2.getChoiceNumbers() + "\t" + result);
    }
}