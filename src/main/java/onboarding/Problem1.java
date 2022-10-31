package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        List<BookPage> bookPages = new ArrayList<>();
        try {
            bookPages.add(new BookPage(pobi));
            bookPages.add(new BookPage(crong));
        } catch (Exception e) {
            return -1;
        }
        List<Integer> bookPageScores = new ArrayList<>();
        for (int i = 0; i < bookPages.size(); i++) {
            BookPage bookPage = bookPages.get(i);

            List<Integer> pageNumbers = new ArrayList<>();
            pageNumbers.add(bookPage.getLeftNumber());
            pageNumbers.add(bookPage.getRightNumber());
            
            int bookPageScore = 0;
            for (final Integer page_number: pageNumbers) {
                int n = page_number;
                int sumDigits = 0;
                int productDigits = 1;
                while (n != 0) {
                    final int digit = n % 10;
                    sumDigits += digit;
                    productDigits *= digit;
                    n /= 10;
                }
                final int page_score = Math.max(sumDigits, productDigits);
                bookPageScore = Math.max(bookPageScore, page_score);
            }
            bookPageScores.add(i, bookPageScore);
        }
        int answer = bookPageScores.get(0).compareTo(bookPageScores.get(1));
        if (answer > 0) {
            answer = 1;
        } else if (answer < 0) {
            answer = 2;
        }
        return answer;
    }
}

/**
 * Two pages you can see when you open a book
 * whose 1st page starts from the left
 * 
 * @author  Yunho Kee
 */
class BookPage {

    /* ---------------- Fields -------------- */

    /**
     * The number written in the left page of two consecutive pages;
     * i.e. an odd number.
     */
    private final int leftNumber;

    /* ---------------- Public operations -------------- */

    /**
    * Constructs an empty {@code BookPage} with the specified list
    * of two pages.
    *
    * @param  pages the list of two pages.
    * @throws PagesSizeException if the list size is larger than two.
    * @throws PagesFarException if the two pages are not consecutive.
    * @throws PageNumberException if the left page number is less than 1.
    * @throws PageOrderException if the left page number is not odd.
    */
    public BookPage(List<Integer> pages) throws PagesSizeException, PagesFarException, PageNumberException, PageOrderException {
        if (pages.size() != 2) {
            throw new PagesSizeException();
        }
        if (pages.get(0) + 1 != pages.get(1)) {
            throw new PagesFarException();
        }
        for (int i = 0; i < 2; i++) {
            final int number = pages.get(i).intValue();
            if (number < 1) {
                throw new PageNumberException();
            }
            if ((number ^ i) == 0) {
                throw new PageOrderException();
            }
        }
        this.leftNumber = pages.get(0);
    }

    /**
    * Get the left number of two pages.
    */
    public int getLeftNumber() {
        return leftNumber;
    }
    /**
    * Get the right number of two pages.
    */
    public int getRightNumber() {
        return leftNumber + 1;
    }

    /* ---------------- Exceptions -------------- */

    class PagesSizeException extends Exception {}
    class PagesFarException extends Exception {}
    class PageNumberException extends Exception {}
    class PageOrderException extends Exception {}
}