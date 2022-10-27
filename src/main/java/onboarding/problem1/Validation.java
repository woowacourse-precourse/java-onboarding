package onboarding.problem1;

import java.util.List;

public class Validation {
    private static final int START_PAGE = 1;
    private static final int END_PAGE = 400;

    public static boolean validate(List<Integer> pobi, List<Integer> crong){
        return validateUser(pobi) && validateUser(crong);
    }
    private static boolean validateUser(List<Integer> user){
        return validatePages(user.get(0), user.get(1));
    }
    private static boolean validatePages(int leftPage, int rightPage){
        if (leftPage % 2 == 0 || rightPage % 2 != 0){
            return false;
        }

        if (rightPage - leftPage != 1){
            return false;
        }

        if (validateNotInRange(leftPage) || validateNotInRange(rightPage)){
            return false;
        }
        return true;
    }
    private static boolean validateNotInRange(int page){
        return page <= START_PAGE || page >= END_PAGE;
    }
}
