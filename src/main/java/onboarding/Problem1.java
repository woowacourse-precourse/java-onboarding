package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer;
        List<Integer> pobiScore = new ArrayList<>();
        List<Integer> crongScore = new ArrayList<>();
        Calculate pobiCal = new Calculate(pobi);
        Calculate crongCal = new Calculate(crong);

        if((pobiCal.exception() == -1) || (crongCal.exception() == -1)) {
            answer = -1;
        } else {
            pobiScore.add(pobiCal.add());
            crongScore.add(crongCal.add());

            pobiScore.add(pobiCal.multiply());
            crongScore.add(crongCal.multiply());

            pobiScore.add(pobiCal.compare(pobiScore.get(0), pobiScore.get(1)));
            crongScore.add(crongCal.compare(crongScore.get(0), crongScore.get(1)));

            answer = compare(pobiScore.get(2), crongScore.get(2));
        }

        return answer;
    }

    static int compare(int pobi, int crong) {
        if(pobi == crong) {
            return 0;
        } else if(pobi > crong) {
            return 1;
        } else {
            return 2;
        }
    }
}