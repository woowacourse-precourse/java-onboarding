package onboarding.feature1;

import static onboarding.feature1.Constants.*;

public class CompareMaximums {
    //메소드
    public static int WhoIsOwner (Integer pobiMaximum, Integer crongMaximum) {
        if (pobiMaximum > crongMaximum) {
            return POBI_WIN;
        }
        if (pobiMaximum < crongMaximum) {
            return CRONG_WIN;
        }
        return DRAW;
    }
}
