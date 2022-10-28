package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 예외처리
        if (pobi.get(0) != pobi.get(1) - 1) {
            return -1;
        }
        if (crong.get(0) != crong.get(1) - 1) {
            return -1;
        }

        int pobiBigNum = 0;
        for (Object obj : pobi) {
            String pobiBookNum = obj.toString();
            char[] pobiArr = pobiBookNum.toCharArray();
            int addNum = 0;
            int mulNum = 1;
            for (char c : pobiArr) {
                addNum += (c - 48);
                mulNum *= (c - 48);

            }
            if (addNum >= mulNum && addNum >= pobiBigNum) {
                pobiBigNum = addNum;
            } else if (addNum <= mulNum && mulNum >= pobiBigNum) {
                pobiBigNum = mulNum;
            }
        }

        int crongBigNum = 0;
        for (Object obj : crong) {
            String crongBookNum = obj.toString();
            char[] crongArr = crongBookNum.toCharArray();
            int num = 0;
            int addNum = 0;
            int mulNum = 1;
            for (int i = 0; i < crongArr.length; i++) {
                addNum += (crongArr[i] - 48);
                mulNum *= (crongArr[i] - 48);
            }
            if (addNum >= mulNum && addNum >= crongBigNum) {
                crongBigNum = addNum;
            } else if (addNum <= mulNum && mulNum >= crongBigNum) {
                crongBigNum = mulNum;
            }
        }

        if (pobiBigNum > crongBigNum) {
            return 1;
        } else if (pobiBigNum < crongBigNum) {
            return 2;
        } else return 0;
    }
}