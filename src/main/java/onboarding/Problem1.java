package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        final int EXECPTION = -1;
        final int POBIWIN = 1;
        final int CRONGWIN = 2;
        final int DRAW = 0;
        final int PAGEMAX = 400;
        int pobiNum = 0;
        int crongNum = 0;

        //예외 페이지 연속성, 오른쪽이 더 큰수 검사
        if ((pobi.get(1) - pobi.get(0) != 1) || (crong.get(1) - crong.get(0) != 1)) {
            return EXECPTION;
        }

        for (int i=0; i<pobi.size(); i++) {
            Integer page = pobi.get(i);
            //예외 시작면이나 마지막면,400페이지 미만 검사
            if ((page <= 1) || (page >= PAGEMAX)) {
                return EXECPTION;
            }
            //예외 왼쪽면 홀수,오른쪽 면 짝수 검사
            if (page%2 != (i + 1)%2) {
                return EXECPTION;
            }
            //pobi 왼쪽 오른쪽 중 큰 것 결정
            int result = getPageBiggest(page);

            if (result > pobiNum) {
                pobiNum = result;
            }
        }

        for (int i=0; i<crong.size(); i++) {
            Integer page = crong.get(i);
            //예외 시작면이나 마지막면,400페이지 미만 검사
            if ((page <= 1) || (page >= PAGEMAX)) {
                return EXECPTION;
            }
            //예외 왼쪽면 홀수,오른쪽 면 짝수 검사
            if (page%2 != (i + 1)%2) {
                return EXECPTION;
            }
            //crong 왼쪽 오른쪽 중 큰 것 결정
            int result = getPageBiggest(page);

            if (result > crongNum) {
                crongNum = result;
            }
        }

        //점수 비교해 승자 결정 1,2,0
        if (pobiNum > crongNum) {
            answer = POBIWIN;
        } else if (pobiNum < crongNum) {
            answer = CRONGWIN;
        } else {
            answer = DRAW;
        }

        return answer;
    }

    //합과 곱 중 큰 것 결정
    private static int getPageBiggest(Integer page) {
        int addNum = 0;
        int multiplyNum = 1;
        char[] pageChars = page.toString().toCharArray();
        int[] pageNums = new int[pageChars.length];

        for (int i=0; i< pageChars.length; i++) {
            pageNums[i] = pageChars[i] - '0';
        }

        addNum = getAddPageNum(pageNums);
        multiplyNum = getMultiPageNum(pageNums);

        return Math.max(addNum,multiplyNum);
    }

    private static int getAddPageNum(int[] pageNums) {
        int addNum = 0;

        for (int i=0; i<pageNums.length; i++) {
            addNum += pageNums[i];
        }

        return addNum;
    }
    private static int getMultiPageNum(int[] pageNums) {
        int multiNum = 1;

        for (int i=0; i<pageNums.length; i++) {
            multiNum *= pageNums[i];
        }

        return multiNum;
    }
}


