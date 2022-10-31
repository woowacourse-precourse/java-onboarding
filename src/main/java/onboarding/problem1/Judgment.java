package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class Judgment {

    private static final int MIN_VALUE = 0;
    private static final int MAX_VALUE = 400;

    public int compare(List<Integer> pobi, List<Integer> crong) {

        BookCalculation calculation = new BookCalculation();

        List<Integer> pobiPlayer = calculation.calculation(pobi);
        int pobiMax = calculation.maxNumber(pobiPlayer);

        List<Integer> crongPlayer = calculation.calculation(crong);
        int crongMax = calculation.maxNumber(crongPlayer);

        if (pobiMax < crongMax) {
            return 2;
        } else if (pobiMax > crongMax) {
            return 1;
        }

        return 0;
    }

    public int verification(List<Integer> pobi, List<Integer> crong) {

        List<Integer> verification = new ArrayList<>();

        verification.addAll(pobi);
        verification.addAll(crong);

        for (int number : verification) {
            if (number <= MIN_VALUE || number > MAX_VALUE) {
                return -1;
            }
        }

        int pobiLeftPage = pobi.get(0); // 100
        int pobiRightPage = pobiLeftPage + 1;

        if (!(pobiRightPage == pobi.get(1))) {
            return -1;
        }

        int crongLeftPage = crong.get(0); // 100
        int crongRightPage = crongLeftPage + 1;

        if (!(crongRightPage == crong.get(1))) {
            return -1;
        }

        return 0;
    }

}
