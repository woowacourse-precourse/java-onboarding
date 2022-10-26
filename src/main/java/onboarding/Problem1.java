package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        final int pageMax = 400;
        int pobiNum = 0;
        int crongNum = 0;
        //임의로 페이지 선택
        //예외 검사 비연속,마지막이나 첫페이지, 왼쪽이 더큼, 홀짝 안맞음 ,400넘어감

        for(Integer page:pobi){
            //pobi 왼쪽 오른쪽 중 큰 것 결정
            int result = getPageBiggest(page);
            if(result > pobiNum){
                pobiNum = result;
            }
        }

        for(Integer page:crong){
            //crong 왼쪽 오른쪽 중 큰 것 결정
            int result = getPageBiggest(page);
            if(result > crongNum){
                crongNum = result;
            }
        }

        //점수 비교해 승자 결정 1,2,0,-1
        if(pobiNum>crongNum){
            answer = 1;
        } else if (pobiNum < crongNum) {
            answer = 2;
        } else {
            answer = 0;
        }

        return answer;
    }

    private static int getPageBiggest(Integer page){
        //합과 곱 중 큰 것 결정
        int addNum = 0;
        int multiplyNum = 1;
        char[] pageChars = page.toString().toCharArray();
        int[] pageNums = new int[pageChars.length];

        for(int i=0; i< pageChars.length; i++) {
            pageNums[i] = pageChars[i] - '0';
        }
        addNum = getAddPageNum(pageNums);
        multiplyNum = getMultiPageNum(pageNums);

        return Math.max(addNum,multiplyNum);
    }

    private static int getAddPageNum(int[] pageNums){
        int addNum = 0;

        for(int i=0; i<pageNums.length; i++){
            addNum+=pageNums[i];
        }

        return addNum;
    }
    private static int getMultiPageNum(int[] pageNums){
        int multiNum = 1;

        for(int i=0; i<pageNums.length; i++){
            multiNum*=pageNums[i];
        }

        return multiNum;
    }
}


