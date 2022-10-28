package onboarding;

import java.util.List;

class Problem1 {
    public static int getBiggerNum(int pageNum){
        int addedNum = 0; //각 자릿수 덧셈
        int multipliedNum = 1; //각 자릿수 곱셈
        int mod;

        while(pageNum != 0){
            mod = pageNum % 10;
            addedNum = addedNum + mod;
            multipliedNum = multipliedNum * mod;
            pageNum = pageNum / 10;
        }

        return Math.max(addedNum, multipliedNum);
    }

    public static boolean isValidInput(int leftPageNum, int rightPageNum){
        if (0 > leftPageNum || 400 < rightPageNum){
            return false;
        }
        if (leftPageNum%2 != 1 || rightPageNum - leftPageNum != 1){
            return false;
        }
        return true;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiLeftPageNum = pobi.get(0);
        int pobiRightPageNum = pobi.get(1);

        int crongLeftPageNum = crong.get(0);
        int crongRightPageNum = crong.get(1);

        //예외사항
        if (!isValidInput(pobiLeftPageNum,pobiRightPageNum) || !isValidInput(crongLeftPageNum,crongRightPageNum)){
            return -1;
        }

        int pobiMaxNum = Math.max(getBiggerNum(pobiLeftPageNum), getBiggerNum(pobiRightPageNum));
        int crongMaxNum = Math.max(getBiggerNum(crongLeftPageNum), getBiggerNum(crongRightPageNum));

        //무승부 0 포비승리 1 크롱승리 2
        if (pobiMaxNum == crongMaxNum){ //무승부
            return 0;
        }

        else if (pobiMaxNum > crongMaxNum){ //포비 승리
            return 1;
        }

        else { //크롱 승리
            return 2;
        }
    }
}