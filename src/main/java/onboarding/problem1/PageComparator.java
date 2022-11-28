package onboarding.problem1;

public class PageComparator {

    public static int compare(int value1, int value2) {
        if (value1 > value2) {
            return 1;
        } else if (value1 < value2) {
            return 2;
        } else {
            return 0;
        }
    }
}
