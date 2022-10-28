package onboarding;

import java.util.List;

class Problem1 {
    public Problem1(){

    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(listSizeException(pobi) || listSizeException(crong)){
            return -1;
        }
        if(pageIndexException(pobi) || pageIndexException(crong)){
            return -1;
        }
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static boolean listSizeException(List<Integer> list){
        return list.size() != 2;
    }

    public static boolean pageIndexException(List<Integer> list){
        int left = list.get(0);
        int right = list.get(1);
        return !isOdd(left) || right != left + 1;
    }

    private static boolean isOdd(int num){
        return num % 2 == 1;
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