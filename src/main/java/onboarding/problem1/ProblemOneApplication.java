package onboarding.problem1;

import onboarding.problem1.domain.Book;
import onboarding.problem1.domain.Calculator;

import java.util.ArrayList;
import java.util.List;

public class ProblemOneApplication {

    public static void main(String[] args) {
        Book book = new Book();
        List<Integer> pobiBook = book.openBook();
        System.out.println("pobiBook = " + pobiBook);

        int lastScore = book.getLastScore();
        System.out.println("lastScore = " + lastScore);

        Book book2 = new Book(269, 270);
        int lastScore2 = book2.getLastScore();
        System.out.println("lastScore2 = " + lastScore2);

        Calculator calculator = new Calculator();
        List<Integer> emptyList = new ArrayList<>();
        List<Integer> notEmptyList = List.of(11, 15);
        System.out.println("answer = " + calculator.compareScore(emptyList, notEmptyList));
    }
}
