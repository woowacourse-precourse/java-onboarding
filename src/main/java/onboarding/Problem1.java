package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int pobiNum = getMax(pobi);
        int crongNum = getMax(crong);
        return getResult(pobiNum, crongNum);
    }

    static int getResult(int i, int j){
        if( i > j){
            return 1;
        }
        if (i < j){
            return 2;
        }
        return 0;
    }

    static int getMax(List<Integer> list){
        int page1 = list.get(0);
        int page2 = list.get(1);

        return Math.max(chooseMultiSum(page1), chooseMultiSum(page2));
    }



    static int chooseMultiSum(int page){
        int len = page+"".length();
        int sum = 0;
        int multi = 1;

        int tmp = page;
        for (int i = 0; i < len - 1; i++) {
            sum += tmp % 10;
            tmp /= 10;
        }

        tmp = page;
        for (int i = 0; i < len - 1; i++) {
            multi *= tmp % 10;
            tmp /= 10;
        }

        return Math.max(sum, multi);
    }
}