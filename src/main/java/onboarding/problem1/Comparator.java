package onboarding.problem1;

import java.util.List;
import static onboarding.problem1.Operator.*;

public class Comparator {
    public static int compare(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        int leftResult = max(add(leftPage), multiply(leftPage));
        int rightResult = max(add(rightPage), multiply(rightPage));

        return max(leftResult,rightResult);
    }
}
