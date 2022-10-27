package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // if right-left value is not one (exception), it isn't book. then return -1
        if (pobi.get(1) - pobi.get(0) != 1)
            return -1;

        if (crong.get(1) - crong.get(0) != 1)
            return -1;

        List<Integer> pobiLeftPageList = new ArrayList<>();
        List<Integer> pobiRightPageList = new ArrayList<>();
        List<Integer> crongLeftPageList = new ArrayList<>();
        List<Integer> crongRightPageList = new ArrayList<>();

        Integer pobiLeftPage = pobi.get(0);
        Integer pobiRightPage = pobi.get(1);
        Integer crongLeftPage = crong.get(0);
        Integer crongRightPage = crong.get(1);

        return 0;
    }

    public static void main(String[] args) {
        List<Integer> pobi = new ArrayList<>();
        List<Integer> crong = new ArrayList<>();

        pobi.add(88);
        pobi.add(89);

        crong.add(188);
        crong.add(189);

        System.out.println("pobi = " + pobi);
        System.out.println("crong = " + crong);

        int result = solution(pobi, crong);
        System.out.println("result = " + result);
    }
}

