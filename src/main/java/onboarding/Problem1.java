package onboarding;

import java.util.List;

//------기능------
//1. 곱하기
//2. 더하기
//3. 곱하기 더하기 중 더 큰 수 구하기
//3. max

class Problem1 {
    private int addNum(int pageNum)    {
        int num = 0;

        while (pageNum > 0)
        {
            num += pageNum % 10;
            pageNum /= 10;
        }

        return num;
    }

    private int mulNum(int pageNum)    {
        int num = 1;

        while (pageNum > 0)
        {
            num *= pageNum % 10;
            pageNum /= 10;
        }

        return num;
    }

    private int pickNum(int pageNum) {
        return Math.max(addNum(pageNum), mulNum(pageNum));
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobiNum, crongNum;

        pobiNum = Math.max();
        return answer;
    }
}