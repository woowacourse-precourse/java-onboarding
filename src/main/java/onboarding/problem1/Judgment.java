package onboarding.problem1;

import java.util.List;

public class Judgment {

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

}
