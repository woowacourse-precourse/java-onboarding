package onboarding.problem1;

import java.util.ArrayList;
import java.util.List;

public class Judgment {

    public static final int MIN = 0;
    public static final int MAX = 400;

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
            if (number <= MIN || number >= MAX) {
                return -1;
            }
        }

        int pobiLeftPage = pobi.get(MIN); // 100
        int pobiRightPage = pobiLeftPage + 1;

        if (!(pobiRightPage == pobi.get(MIN + 1))) {
            return -1;
        }

        int crongLeftPage = crong.get(MIN); // 100
        int crongRightPage = crongLeftPage + 1;

        if (!(crongRightPage == crong.get(MIN + 1))) {
            return -1;
        }

        return 0;
    }

}
