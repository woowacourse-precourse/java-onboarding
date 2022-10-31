package onboarding;

import java.util.List;

class Problem1 {
    public static int getMaxPoint(int pageNum){
        int point1 = 0, point2 = 1;

        while (pageNum>0){
            point1 += pageNum%10;
            point2 *= pageNum%10;
            pageNum /= 10;
        }
        return Math.max(point1,point2);
    }

    public static boolean isWrong(int left, int right){
        boolean check1 = right-left != 1;
        boolean check2 = left == 1;
        boolean check3 = right == 400;

        return check1 || check2 || check3;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {

        if(isWrong(pobi.get(0), pobi.get(1)) || isWrong(crong.get(0), crong.get(1)) ){
            return -1;
        }

        int pobiPoint = Math.max(getMaxPoint(pobi.get(0)),getMaxPoint(pobi.get(1)));
        int crongpoint = Math.max(getMaxPoint(crong.get(0)),getMaxPoint(crong.get(1)));

        if(pobiPoint > crongpoint) {
            return 1;
        }
        if(pobiPoint < crongpoint){
            return 2;
        }
        //pobiPoint == crongpoint
        return 0;
    }
}