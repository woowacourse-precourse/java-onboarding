package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(checkPage(pobi, crong))
            return -1;

        int pobiMax = Math.max(max(pobi.get(0)), max(pobi.get(1)));
        int crongMax = Math.max(max(crong.get(0)), max(crong.get(1)));

        if(pobiMax == crongMax)
            return 0;

        return pobiMax > crongMax ? 1 : 2;
    }

    private static boolean checkPage(List<Integer> pobi, List<Integer> crong) {

        if(pobi.get(0) + 1 != pobi.get(1) || pobi.get(0)%2 != 1 || pobi.get(1)%2 != 0) return true;
        if(crong.get(0) + 1 != crong.get(1) || crong.get(0)%2 != 1 || crong.get(1)%2 != 0) return true;

        return false;
    }

    public static int max(int num){

        int plusMax = 0;
        int multipleMax = 1;

        while( num > 0){
            plusMax += num % 10;
            multipleMax *= num % 10;
            num /= 10;
        }

        return plusMax > multipleMax ? plusMax : multipleMax;
    }
}