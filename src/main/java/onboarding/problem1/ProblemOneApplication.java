package onboarding.problem1;

import onboarding.problem1.domain.Book;
import onboarding.problem1.domain.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProblemOneApplication {

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> notEmptyList = Arrays.asList(1);

        System.out.println("calculator.hasList(emptyList) = " + calculator.hasList(emptyList));
        System.out.println("calculator.hasList(notEmptyList) = " + calculator.hasList(notEmptyList));

        Book book = new Book();

        int page = book.openBook();
        System.out.println("page = " + page);

        int page2 = 20;
        int page3 = 21;
        System.out.println("book.isEvenPage(page2) = " + book.isEvenPage(page2));
        System.out.println("book.isEvenPage(page3) = " + book.isEvenPage(page3));

        book.setPage(page2);
        System.out.println("book.getLeftPage() = " + book.getLeftPage());
        System.out.println("book.getRightPage() = " + book.getRightPage());

        book.setPage(page3);
        System.out.println("book.getLeftPage() = " + book.getLeftPage());
        System.out.println("book.getRightPage() = " + book.getRightPage());

        book.setPage(notEmptyList.get(0));
        System.out.println("book.getLeftPage() = " + book.getLeftPage());
        System.out.println("book.getRightPage() = " + book.getRightPage());
    }
}
