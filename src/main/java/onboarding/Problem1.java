package onboarding;

import java.util.List;

class Problem1 {
    public static int getEleSum(int tmp){
        int res = 0;
        while(tmp != 0){
            res += tmp % 10;
            tmp /= 10;
        }
        return res;
    }
    public static int getEleProd(int tmp){
        int res = 1;
        while(tmp != 0){
            res *= tmp % 10;
            tmp /= 10;
        }
        return res;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(pobi.get(0) + 1 != pobi.get(1)) return -1;
        if(crong.get(0) + 1 != crong.get(1)) return -1;
        int pobimax = 0;
        int crongmax = 0;
        //포비 합
        pobimax = Math.max(getEleSum(pobi.get(0)),pobimax);
        pobimax = Math.max(getEleSum(pobi.get(1)),pobimax);
        //포비 곱
        pobimax = Math.max(getEleProd(pobi.get(0)),pobimax);
        pobimax = Math.max(getEleProd(pobi.get(1)),pobimax);
        //크롱 합
        crongmax = Math.max(getEleSum(crong.get(0)),crongmax);
        crongmax = Math.max(getEleSum(crong.get(1)),crongmax);
        //크롱 곱
        crongmax = Math.max(getEleProd(crong.get(0)),crongmax);
        crongmax = Math.max(getEleProd(crong.get(1)),crongmax);

        if(pobimax > crongmax) return 1;
        if(pobimax < crongmax) return 2;
        return 0;
    }
}