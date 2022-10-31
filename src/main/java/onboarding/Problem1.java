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
        int answer = Integer.MAX_VALUE;
        return answer;
    }
}