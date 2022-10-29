package onboarding;

import java.util.List;

class Problem1 {

    static boolean isException(List<Integer> pobi, List<Integer> crong) {
        return (subtractPagenum(getPagenum(pobi,1),getPagenum(pobi,0))!=1 ||
                subtractPagenum(getPagenum(crong, 1),getPagenum(crong,0))!=1);
    }
    static int getPagenum(List<Integer> arr, int index){
        return arr.get(index);
    }

    static int subtractPagenum(int rightpage, int leftpage){
        return rightpage-leftpage;
    }

    static int setMaxValue(int Max, int sum, int mul) {
        return (sum>mul)?Math.max(Max,sum):Math.max(Max,mul);
    }

    static int calculateSum(int pagenum){
        int sum = 0;
        while (pagenum > 0){
            sum += pagenum%10;
            pagenum /= 10;
        }
        return sum;
    }

    static int calculateMul(int pagenum){
        int mul = 1;
        while (pagenum > 0){
            mul *= pagenum%10;
            pagenum /= 10;
        }
        return mul;
    }

    static int getAnswer(List<Integer> pobi, List<Integer> crong){
        int pagenum, pobiMax = 0, crongMax = 0;

        if (isException(pobi,crong)) return -1;

        for (int index = 0; index < 2; index++) {
            pagenum = getPagenum(pobi,index);
            pobiMax = setMaxValue(pobiMax,calculateSum(pagenum),calculateMul(pagenum));
            pagenum = getPagenum(crong, index);
            crongMax = setMaxValue(crongMax,calculateSum(pagenum),calculateMul(pagenum));
        }
        return (pobiMax>crongMax)?1:(pobiMax<crongMax)?2:0;
    }


    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = getAnswer(pobi,crong);
        return answer;
    }
}