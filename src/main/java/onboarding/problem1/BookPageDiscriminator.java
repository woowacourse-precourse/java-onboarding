package onboarding.problem1;

import java.util.Arrays;
import java.util.List;

public class BookPageDiscriminator {
    private static final int MAX_PAGE_NUMBER = 400;

    public static boolean isProperBookPage(List<Integer>... books){
        return Arrays.stream(books)
                .map(book -> isProperBookPage(book))
                .reduce(true, (a,b) -> a && b);
    }

    public static boolean isProperBookPage(List<Integer> book){
        return isListSize2(book) && isLeftPageNumberOdd(book)
                && isNextPage(book) && isPageNumberInBook(book);
    }

    private static boolean isListSize2(List<Integer> list){
        return list.size() == 2;
    }

    private static boolean isLeftPageNumberOdd(List<Integer> book){
        return book.get(0) % 2 == 1;
    }

    private static boolean isNextPage(List<Integer> book){
        return book.get(0) + 1 == book.get(1);
    }

    private static boolean isPageNumberInBook(List<Integer> book){
        return 1 <= book.get(0) && book.get(0) <= MAX_PAGE_NUMBER;
    }
}
