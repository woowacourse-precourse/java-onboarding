package onboarding.problem1;

import java.util.List;

public class Returner {
    private final List<Integer> grades;

    public Returner(List<Integer> grades) {
        this.grades = grades;
    }

    public int result() {
        if (grades.size() != 2) {
            return -1;
        }
        switch (Integer.signum(grades.get(0) - grades.get(1))) {
            case 0 :
                return 0;
            case 1 :
                return 1;
            default :
                return 2;
        }
    }
}
