package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pLeftPage = pobi.get(0);
        int pRightPage = pobi.get(1);
        int cLeftPage = crong.get(0);
        int cRightPage = crong.get(1);

        if (pLeftPage % 2 != 1 || cLeftPage % 2 != 1){
            return -1;
        }
        if(pRightPage - pLeftPage != 1 || cRightPage - cLeftPage != 1){
            return -1;
        }

        int pMaxLeftNum = max(sum(pLeftPage), multi(pLeftPage));
        int pMaxRightNum = max(sum(pRightPage), multi(pRightPage));
        int pMaxNum = max(pMaxLeftNum, pMaxRightNum);

        int cMaxLeftNum = max(sum(cLeftPage), multi(cLeftPage));
        int cMaxRightNum = max(sum(cRightPage), multi(cRightPage));
        int cMaxNum = max(cMaxLeftNum, cMaxRightNum);

        if (pMaxNum < cMaxNum){
            answer = 2;
        }else if(pMaxNum > cMaxNum){
            answer = 1;
        }else{
            answer = 0;
        }

        return answer;
    }

    public static int max(int num1, int num2){
        if (num1 < num2){
            return num2;
        }else if(num1 > num2){
            return num1;
        }else{
            return num1;
        }
    }
    public static int sum(int num){
        int result = 0;
        while (num != 0){
            int units = num % 10;
            result += units;
            num = num / 10;
        }
        return result;
    }

    public static int multi(int num){
        int result = 1;
        while (num != 0){
            int units = num % 10;
            result *= units;
            num = num / 10;
        }
        return result;
    }
}