package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        int pobiLeftNum = pobi.get(0); //포비 왼쪽 페이지
        int pobiRightNum = pobi.get(1); //포비 오른쪽 페이지
        int crongLeftNum = crong.get(0); //크롱 왼쪽 페이지
        int crongRightNum = crong.get(1); //크롱 오른쪽 페이지

        answer=pageCheck(pobiLeftNum,pobiRightNum,crongLeftNum,crongRightNum);

        return answer;

    }//public static int solution

    public static int pageCheck(int pobiLeftNum,int pobiRightNum
                                ,int crongLeftNum,int crongRightNum){
        int result = 0;
        int pLeftWinNum = 0;
        int pRightWinNum = 0;
        int cLeftWinNum = 0;
        int cRightWinNum = 0;
        int pobiNum = 0;
        int crongNum = 0;

        if (pobiLeftNum == pobiRightNum - 1
            && crongLeftNum == crongRightNum - 1
            && pobiLeftNum > 1
            && crongLeftNum > 1
            && 400 > pobiRightNum
            && 400 > crongRightNum
            && pobiLeftNum % 2 == 1
            && crongLeftNum % 2 == 1
            && pobiRightNum % 2 == 0
            && crongRightNum % 2 == 0) {

            pLeftWinNum = pageCompare(pageSum(pobiLeftNum),pageSum(pobiLeftNum));
            pRightWinNum = pageCompare(pageSum(pobiRightNum),pageMul(pobiRightNum));

            cLeftWinNum = pageCompare(pageSum(crongLeftNum),pageMul(crongRightNum));
            cRightWinNum = pageCompare(pageSum(crongRightNum),pageMul(crongRightNum));

            pobiNum = pageCompare(pLeftWinNum,pRightWinNum);
            crongNum = pageCompare(cLeftWinNum,cRightWinNum);

            result = pageMatch(pobiNum,crongNum);

            return result;
        }
        return -1;
    }// public static int pageCheck

    public static int pageSum(int page){
        int page1 = 0;
        int page2 = 0;
        int page3 = 0;
        int sum = 0;

        if(page>=10){
            page1 = page / 100;
            page2 = (page % 100) / 10;
            page3 = page % 10;
            sum = page1 + page2 + page3;
            return sum;
        }
        sum = page;
        return sum;
    }//public static int sum

    public static int pageMul(int page){
        int page1 = 0;
        int page2 = 0;
        int page3 = 0;
        int mul = 0;

        page1 = page / 100;
        page2 = (page % 100) / 10;
        page3 = page % 10;

        if(page1 != 0) {
            mul = page1 * page2 * page3;
            return mul;
        }
        if(page2 != 0) {
            mul = page2 * page3;
            return mul;
        }
        mul = page;
        return mul;
    }//public static int mul

    public static int pageCompare(int num1,int num2){
        int winNum = 0;

        if(num1 > num2){
            winNum = num1;
            return winNum;
        }
        winNum = num2;
        return winNum;
    }//public static int pageCompare

    public static int pageMatch(int pobiNum,int crongNum){
        if (pobiNum > crongNum) {//포비>크롱
            return 1;
        }
        if (pobiNum < crongNum) {//포비<크롱
            return 2;
        }
        //포비=크롱
        return 0;
    }//public static int pageMatch

}//class Problem1