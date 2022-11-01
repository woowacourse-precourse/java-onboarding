package onboarding;

import java.util.List;

class Problem1 {
    public Problem1(){

    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(listSizeException(pobi) || listSizeException(crong)){
            return -1;
        }
        if(pageNumException(pobi) || pageNumException(crong)){
            return -1;
        }
        if(pageIndexException(pobi) || pageIndexException(crong)){
            return -1;
        }
        int pobiScore = getScore(pobi);
        int crongScore = getScore(crong);

        if (pobiScore < crongScore){
            return 2;
        } else if (pobiScore > crongScore) {
            return 1;
        }
        return 0;
    }

    public static boolean listSizeException(List<Integer> list){
        return list.size() != 2;
    }

    public static boolean pageNumException(List<Integer> list){
        int start = list.get(0);
        int end = list.get(1);
        return start == 1 || end == 400;
    }

    public static boolean pageIndexException(List<Integer> list){
        int left = list.get(0);
        int right = list.get(1);
        return !isOdd(left) || right != left + 1;
    }

    private static boolean isOdd(int num){
        return num % 2 == 1;
    }

    public static int getScore(List<Integer> list){
        int left = list.get(0);
        int right = list.get(1);
        return Math.max(getMaxLeftPage(left), getMaxRightPage(right));
    }

    private static int getMaxLeftPage(int left){
        return Math.max(sumEachNum(left), multiEachNum(left));
    }

    private static int getMaxRightPage(int right){
        return Math.max(sumEachNum(right), multiEachNum(right));
    }

    public static int sumEachNum(int num){
        int sum = 0;
        while(num != 0){
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }

    public static int multiEachNum(int num){
        int multi = 1;
        while(num != 0){
            multi *= num % 10;
            num /= 10;
        }
        return multi;
    }
}