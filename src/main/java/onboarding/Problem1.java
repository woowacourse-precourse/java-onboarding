package onboarding;

import java.util.List;
import java.util.stream.Stream;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        try{
            Game game=new Game(pobi,crong);
            answer=game.decideWinner();
            System.out.println(answer);
            return answer;
        }catch (IllegalStateException e){
            System.out.println(-1);
            return -1;
        }
    }
}

abstract class Page {

    private static final Integer MIN_PAGE = 1;
    private static final Integer MAX_PAGE = 400;
    private static final String NOT_ALLOWED_UNDER_MIN_PAGE = "책의 최소 페이지 수는 1입니다.";
    private static final String NOT_ALLOWED_OVER_MAX_PAGE = "책의 최대 페이지 수는 400입니다.";

    public Page(int pageNumber) {
        validateMinPage(pageNumber);
        validateMaxPage(pageNumber);
        this.pageNumber = pageNumber;
    }

    private final Integer pageNumber;

    public Integer getPageNumber() {
        return pageNumber;
    }

    public int sumPage() {
        return Stream.of(String.valueOf(pageNumber).split(""))
                .mapToInt(Integer::parseInt)
                .sum();
    }

    public int multiplePage() {
        return Stream.of(String.valueOf(pageNumber).split(""))
                .mapToInt(Integer::parseInt)
                .reduce(1, (a, b) -> a * b);
    }

    private void validateMinPage(int pageNumber) {
        if (pageNumber < MIN_PAGE) {
            throw new IllegalStateException(NOT_ALLOWED_UNDER_MIN_PAGE);
        }
    }

    private void validateMaxPage(int pageNumber) {
        if (pageNumber > MAX_PAGE) {
            throw new IllegalStateException(NOT_ALLOWED_OVER_MAX_PAGE);
        }
    }

    protected abstract void validateEvenOrOdd(int pageNumber);
}

class LeftPage extends Page {
    private static final Integer ODD_NUMBER = 2;
    private static final Integer REMAINDER_DIVIDIED_BY_ODD = 1;
    private static final String NOT_ALLOWED_ODD_NUMBER = "책의 왼쪽 페이지는 홀수여야 합니다.";

    public LeftPage(int pageNumber) {
        super(pageNumber);
    }

    @Override
    protected void validateEvenOrOdd(int pageNumber) {
        if (pageNumber % ODD_NUMBER != REMAINDER_DIVIDIED_BY_ODD) {
            throw new IllegalStateException(NOT_ALLOWED_ODD_NUMBER);
        }
    }
}

class RightPage extends Page {
    private static final Integer ODD_NUMBER = 2;
    private static final Integer REMAINDER_DIVIDIED_BY_ODD = 0;
    private static final String NOT_ALLOWED_ODD_NUMBER = "책의 오른쪽 페이지는 짝수여야 합니다.";

    public RightPage(int pageNumber) {
        super(pageNumber);
    }

    @Override
    protected void validateEvenOrOdd(int pageNumber) {
        if (pageNumber % ODD_NUMBER != REMAINDER_DIVIDIED_BY_ODD) {
            throw new IllegalStateException(NOT_ALLOWED_ODD_NUMBER);
        }
    }
}

class Book {
    private static final int LEFT_PAGE_INDEX = 0;
    private static final int RIGHT_PAGE_INDEX = 1;
    private static final int LEFT_AND_RIGHT_INTERVAL = 1;
    private static final int PAGE_SIZE_BY_OPENEING_BOOK = 2;
    private static final String LEFT_RIGHT_PAGE_DIFFERENCE = "왼쪽과 오른쪽 페이지는 1 차이 나야합니다.";
    private static final String PAGE_PER_OPENING_BOOK = "책을 펼치면 총 2개의 페이지 번호를 얻어야합니다.";

    private final LeftPage leftPage;
    private final RightPage rightPage;

    public Book(List<Integer> pageByOpeningBook) {
        validateLeftAndRightInterval(pageByOpeningBook);
        validateArraySize(pageByOpeningBook);
        leftPage = new LeftPage(pageByOpeningBook.get(LEFT_PAGE_INDEX));
        rightPage = new RightPage(pageByOpeningBook.get(RIGHT_PAGE_INDEX));
    }

    private void validateLeftAndRightInterval(List<Integer> pageByOpeningBook) {
        if (pageByOpeningBook.get(RIGHT_PAGE_INDEX) - pageByOpeningBook.get(LEFT_PAGE_INDEX) != 1) {
            throw new IllegalStateException(LEFT_RIGHT_PAGE_DIFFERENCE);
        }
    }

    private void validateArraySize(List<Integer> pageByOpeningBook) {
        if (pageByOpeningBook.size() != PAGE_SIZE_BY_OPENEING_BOOK) {
            System.out.println(pageByOpeningBook.size());
            throw new IllegalStateException(PAGE_PER_OPENING_BOOK);
        }
    }

    public LeftPage getLeftPage() {
        return leftPage;
    }

    public RightPage getRightPage() {
        return rightPage;
    }

    public int getBigSumPageByLeftAndRight() {
        if (leftPage.sumPage() >= rightPage.sumPage()) {
            return leftPage.sumPage();
        }
        return rightPage.sumPage();
    }

    public int getBigMultiplePageByLeftAndRight() {
        if (leftPage.multiplePage() >= rightPage.multiplePage()) {
            return leftPage.multiplePage();
        }
        return rightPage.multiplePage();
    }

    public int getBookScore() {
        if (getBigSumPageByLeftAndRight() >= getBigMultiplePageByLeftAndRight()) {
            return getBigSumPageByLeftAndRight();
        }
        return getBigMultiplePageByLeftAndRight();
    }
}


class Game {
    private final Book bookByOneUser;
    private final Book bookByTwoUser;


    public Game(List<Integer> user1Page, List<Integer> user2Page) {
        bookByOneUser = new Book(user1Page);
        bookByTwoUser = new Book(user2Page);
    }

    public int decideWinner() {
        if (bookByOneUser.getBookScore() > bookByTwoUser.getBookScore()) {
            return 1;
        }
        if (bookByOneUser.getBookScore() < bookByTwoUser.getBookScore()) {
            return 2;
        }
        if (bookByOneUser.getBookScore() == bookByTwoUser.getBookScore()) {
            return 0;
        }
        return -1;
    }
}