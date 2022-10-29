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
        List<Integer> notEmptyList = Arrays.asList(10, 50);

        System.out.println("calculator.hasList(emptyList) = " + calculator.hasList(emptyList));
        System.out.println("calculator.hasList(notEmptyList) = " + calculator.hasList(notEmptyList));

        Book book = new Book();
        List<Integer> pobiBook = book.openBook();
        System.out.println("pobiBook = " + pobiBook);

        int lastScore = book.getLastScore();
        System.out.println("lastScore = " + lastScore);

        Book book2 = new Book(169, 170);
        int lastScore2 = book2.getLastScore();
        System.out.println("lastScore2 = " + lastScore2);
    }
}
