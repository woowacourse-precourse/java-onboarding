package onboarding.problem1.domain;

import java.util.List;

public class Calculator {

    public int compareScore(List<Integer> pobi, List<Integer> crong) {

        Book pobiBook = new Book();
        Book crongBook = new Book();

        if (hasList(pobi)) {
            if (wrongInput(pobi)) return -1;
            pobiBook = new Book(pobi.get(0), pobi.get(1));
        }
        else pobiBook.openBook();

        if (hasList(crong)) {
            if (wrongInput(crong)) return -1;
            crongBook = new Book(crong.get(0), crong.get(1));
        }
        else crongBook.openBook();

        int pobiScore = pobiBook.getLastScore();
        int crongScore = crongBook.getLastScore();

        if (pobiScore == crongScore) return 0;
        else if (pobiScore > crongScore) return 1;
        else return 2;
    }

    public boolean wrongInput(List<Integer> list) {
        Book book = new Book();
        return (book.isEvenPage(list.get(0)) || (list.get(0) + 1 != list.get(1)));
    }

    private boolean hasList(List<Integer> list) {
        return !list.isEmpty();
    }
}
