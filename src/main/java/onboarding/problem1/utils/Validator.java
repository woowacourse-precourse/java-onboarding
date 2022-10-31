package onboarding.problem1.utils;

import java.util.List;

public class Validator {
    public static boolean validatePages(List<Integer> pageList) {
        for (int page : pageList) {
            if (page == 1 || page == 400) {
                return false;
            }
        }

        if (pageList.get(1) - pageList.get(0) != 1) {
            return false;
        }

        return true;
    }
}
