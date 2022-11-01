package onboarding.problem1;

import onboarding.exception.InputException;

import java.util.List;

public class BookPage {

    private int leftPage;
    private int rightPage;
    private final int MAX_PAGE_NUMBER = 400;

    public BookPage(List<Integer> bookPage){
        if (!isProperBookPage(bookPage))
            throw new InputException(Problem1ExceptionMessage.NOT_VALID_BOOK_PAGE);

        this.leftPage = bookPage.get(0);
        this.rightPage = bookPage.get(1);
    }

    public int getLeftPage(){
        return leftPage;
    }
    public int getRightPage(){
        return rightPage;
    }

    private boolean isProperBookPage(List<Integer> bookPage){
        return isListSize2(bookPage) && isLeftPageNumberOdd(bookPage)
                && isNextPage(bookPage) && isPageNumberInBook(bookPage);
    }

    private boolean isListSize2(List<Integer> list){
        return list.size() == 2;
    }

    private boolean isLeftPageNumberOdd(List<Integer> book){
        return book.get(0) % 2 == 1;
    }

    private boolean isNextPage(List<Integer> book){
        return book.get(0) + 1 == book.get(1);
    }

    private boolean isPageNumberInBook(List<Integer> book){
        return 1 <= book.get(0) && book.get(0) <= MAX_PAGE_NUMBER;
    }
}
