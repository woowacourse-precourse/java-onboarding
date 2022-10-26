package onboarding;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class Problem1 {

//    public static void main(String[] args) {
//        List<Integer> pobi = new ArrayList<>();
//        pobi.add(103);
//        pobi.add(99);
//        List<Integer> crong = new ArrayList<>();
//        crong.add(222);
//        crong.add(222);
//
//        System.out.println("result = " + solution(pobi, crong));
//    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        try {
            if (pobi.get(1) - pobi.get(0) > 1 || crong.get(1) - crong.get(1) > 1 ||     //Edge Case
              pobi.get(1) - pobi.get(0) <= 0 || crong.get(1) - crong.get(0) <= 0) {
                return -1;
            }
            return pageGame(pobi, crong);           //페이지 게임 규칙 알고리즘
        } catch (Exception e) {
            return -1;
        }
    }

    private static int pageGame(List<Integer> pobi, List<Integer> crong) {
        int pobiResult = 0, crongResult = 0;
        for (int i = 0; i < pobi.size(); i++) {
            int pobiValue = pobi.get(i);
            int crongValue = crong.get(i);
            int pDigit, cDigit;
            int pAdd = 0, cAdd = 0;
            int pMult = 1, cMult = 1;
            while (pobiValue > 0 || crongValue > 0) {
                pDigit = pobiValue % 10;
                cDigit = crongValue % 10;
                pAdd += pDigit;
                cAdd += cDigit;
                pMult *= Math.max(pDigit, 1);
                cMult *= Math.max(cDigit, 1);
                pobiValue /= 10;
                crongValue /= 10;
            }
            pobiResult = Math.max(pAdd, pMult);
            crongResult = Math.max(cAdd, cMult);
        }
        if (pobiResult > crongResult) {     //포비 우승
            return 1;
        } else if (crongResult > pobiResult) {     //크롱 우승
            return 2;
        }
        return 0;   //무승부
    }
}