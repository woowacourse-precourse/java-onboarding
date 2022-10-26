package onboarding;

import java.util.List;

//------기능------
//1. 곱하기
//2. 더하기
//3. 곱하기 더하기 중 더 큰 수 구하기
//3. max

class Problem1 {
    private static int addNum(int pageNum)    {
        int num = 0;

        while (pageNum > 0)
        {
            num += pageNum % 10;
            pageNum /= 10;
        }

        return num;
    }

    private static int mulNum(int pageNum)    {
        int num = 1;

        while (pageNum > 0)
        {
            num *= pageNum % 10;
            pageNum /= 10;
        }

        return num;
    }

    private static int pickNum(int pageNum) {
        return Math.max(addNum(pageNum), mulNum(pageNum));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        int pobiNum, crongNum;

        pobiNum = Math.max(pickNum(pobi.get(0)), pickNum(pobi.get(1)));
        crongNum = Math.max(pickNum(crong.get(0)), pickNum(pobi.get(1)));

        if (pobiNum == crongNum)
            return 0;
        else if (pobiNum > crongNum)
            return 1;
        else if (pobiNum < crongNum)
            return 2;

        return -1;
    }
}