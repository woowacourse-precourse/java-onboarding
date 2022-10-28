package onboarding;

import java.util.List;

public class Page {
    private final int leftPage;
    private final int rightPage;

    public Page(List<Integer> list) {
        this.leftPage = list.get(0);
        this.rightPage = list.get(1);
    }

    public boolean validationCheck() {
        if (oddEvenCheck()) return false;
        if (outOfRangeLeftCheck()) return false;
        if (outOfRangeRightCheck()) return false;
        if (differenceCheck()) return false;
        if (firstPageLastPageCheck()) return false;
        return true;
    }

    private boolean firstPageLastPageCheck() {
        if ((this.leftPage == 1) || (this.rightPage == 400)) {
            return true;
        }
        return false;
    }

    private boolean differenceCheck() {
        if ((this.rightPage - this.leftPage) != 1) {
            return true;
        }
        return false;
    }

    private boolean outOfRangeRightCheck() {
        if ((rightPage < 2) || (rightPage > 401)) {
            return true;
        }
        return false;
    }

    private boolean outOfRangeLeftCheck() {
        if ((leftPage < 1) || (leftPage > 400)) {
            return true;
        }
        return false;
    }

    private boolean oddEvenCheck() {

        if (((leftPage % 2) == 0) || ((rightPage % 2) == 1)) {
            return true;
        }
        return false;
    }
}
