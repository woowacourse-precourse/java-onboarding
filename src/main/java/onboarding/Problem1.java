package onboarding;

import java.util.ArrayList;
import java.util.Collections;
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

        // % operation -> integer split
        while (pobiLeftPage > 0) {
            pobiLeftPageList.add(pobiLeftPage % 10);
            pobiLeftPage /= 10;
        }

        while (pobiRightPage > 0) {
            pobiRightPageList.add(pobiRightPage % 10);
            pobiRightPage /= 10;
        }

        while (crongLeftPage > 0) {
            crongLeftPageList.add(crongLeftPage % 10);
            crongLeftPage /= 10;
        }

        while (crongRightPage > 0) {
            crongRightPageList.add(crongRightPage % 10);
            crongRightPage /= 10;
        }

        List<Integer> pobiMax = new ArrayList<>();
        List<Integer> crongMax = new ArrayList<>();

        int plus = 0;
        int multiple = 1;

        // 포비의 최대값 구하는 과정
        for (Integer integer : pobiLeftPageList) {
            plus += integer;
            multiple *= integer;
        }
        pobiMax.add(plus);
        pobiMax.add(multiple);
        plus = 0;       // reset
        multiple = 1;

        for (Integer integer : pobiRightPageList) {
            plus += integer;
            multiple *= integer;
        }
        pobiMax.add(plus);
        pobiMax.add(multiple);
        plus = 0;       // reset
        multiple = 1;

        // 크롱의 최대값 구하는 과정
        for (Integer integer : crongLeftPageList) {
            plus += integer;
            multiple *= integer;
        }
        crongMax.add(plus);
        crongMax.add(multiple);
        plus = 0;       // reset
        multiple = 1;

        for (Integer integer : crongRightPageList) {
            plus += integer;
            multiple *= integer;
        }
        crongMax.add(plus);
        crongMax.add(multiple);

        int pobiMaxValue = Collections.max(pobiMax);
        int crongMaxValue = Collections.max(crongMax);

        if (pobiMaxValue > crongMaxValue)
            return 1;

        if (pobiMaxValue < crongMaxValue)
            return 2;

        if (pobiMaxValue == crongMaxValue)
            return 0;

        return -1;
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

