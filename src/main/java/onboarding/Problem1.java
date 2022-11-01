package onboarding;

import java.util.List;

class Problem1 {

    private static final int MIN_PAGE_NUM = 1;
    private static final int MAX_PAGE_NUM = 400;
    private static final int FIXED_SIZE = 2;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        final int POBISIZE = pobi.size();
        final int CRONGSIZE = crong.size();

        if (validatePageNum(pobi) == false){
            return -1;
        }
        if (validatePageNum(crong)==false){
            return -1;
        }

        validateMemberSize(POBISIZE, CRONGSIZE);

        if (validateWrongPageOrder(pobi, crong)) {
            return -1;
        }

        int pobiScore = getMaxScore(getPlusNum(pobi), getMultiplyNum(pobi));
        int crongScore = getMaxScore(getPlusNum(crong), getMultiplyNum(crong));

        return getGameResult(pobiScore, crongScore);
    }

    private static int getGameResult(int pobiScore, int crongScore) {
        if (pobiScore > crongScore) {
            return 1;
        }
        if (pobiScore < crongScore) {
            return 2;
        }
        return 0;
    }

    private static int getMaxScore(int plusNum, int multiplyNum) {
        return Math.max(plusNum, multiplyNum);
    }
    private static int getPlusNum(List<Integer> member) {
        int PlusNum = 0;
        for (int i = 0; i < 2; i++) {
            int now = member.get(i).intValue();
            int divAs100 = now / 100;
            PlusNum += divAs100;
            now %= 100;

            int divAs10 = now / 10;
            int mod = now % 10;
            PlusNum += divAs10;
            PlusNum += mod;
        }
        return PlusNum;
    }

    private static int getMultiplyNum(List<Integer> member) {

        int MultiplyNum = 1;

        for (int i = 0; i < 2; i++) {
            int now = member.get(i).intValue();
            int divAs100 = now / 100;

            now %= 100;

            if (divAs100 != 0) {
                MultiplyNum *= divAs100;
            }

            int divAs10 = now / 10;
            int mod = now % 10;

            MultiplyNum *= divAs10;
            MultiplyNum *= mod;
        }
        return MultiplyNum;
    }

    private static boolean validateWrongPageOrder(List<Integer> pobi, List<Integer> crong) {
        return pobi.get(0).intValue() + 1 != pobi.get(1).intValue()
            || crong.get(0).intValue() + 1 != crong.get(1).intValue();
    }

    private static void validateMemberSize(int POBISIZE, int CRONGSIZE) {
        if (POBISIZE != FIXED_SIZE || CRONGSIZE != FIXED_SIZE) {
            throw new IllegalArgumentException("pobi와 crong의 길이는 2여야 합니다");
        }
    }
    private static boolean validatePageNum(List<Integer> member) {
        for (Integer pageNum : member) {
            if (pageNum < MIN_PAGE_NUM || pageNum > MAX_PAGE_NUM) {
                return false;
            }
        }
        return true;
    }
}