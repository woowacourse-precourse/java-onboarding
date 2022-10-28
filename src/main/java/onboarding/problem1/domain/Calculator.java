package onboarding.problem1.domain;

import java.util.List;

public class Calculator {

    public int compareScore(Book pobiBook, Book crongBook) {
        int pobiScore = pobiBook.getLastScore();
        int crongScore = crongBook.getLastScore();
        if (pobiScore == crongScore) {
            return 0;
        } else if (pobiScore > crongScore) {
            return 1;
        }
        else return 2;
    }

    public boolean hasList(List<Integer> list) {
        return list.isEmpty();
    }
}
