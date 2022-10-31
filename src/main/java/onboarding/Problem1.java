package onboarding;

import java.util.List;

class Problem1 {
    public static final int size = 2;
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int addNumber(int num){
        int result = 0;
        while(num != 0){
            result += (num % 10);
            num /= 10;
        }
        return result;
    }

    public static int multiNumber(int num){
        int result = 1;
        while(num != 0){
            result *= (num % 10);
            num /= 10;
        }
        return result;
    }

    public static int getResult(int left, int right){
        int left_result = Integer.max(addNumber(left), multiNumber(left));
        int right_result = Integer.max(addNumber(right), multiNumber(right));

        return Integer.max(left_result, right_result);
    }

    public static int getAnswer(int pobiResult, int crongResult){
        int answer;

        if(pobiResult > crongResult){
            answer = 1;
        }else if(pobiResult < crongResult){
            answer = 2;
        }else{
            answer = 0;
        }
        return answer;
    }
    public static boolean checkPageSize(List<Integer> pobi, List<Integer> crong){
        if(pobi.size() == size && crong.size() == size){
            return true;
        }
        return false;
    }
    public static boolean isOdd(int left){
        if(left % 2 == 1){
            return true;
        }
        return false;
    }
    public static boolean isEven(int right){
        if(right % 2 == 0){
            return true;
        }
        return false;
    }
    public static boolean checkPageNumber(List<Integer> user){
        int left = user.get(0);
        int right = user.get(1);
        if(isOdd(left) && isEven(right)){
            return true;
        }
        return false;
    }
    public static boolean isNext(List<Integer> user){
        int left = user.get(0);
        int right = user.get(1);
        if((right - left) == 1){
            return true;
        }
        return false;
    }
    public static boolean checkRange(List<Integer> pobi, List<Integer> crong){
        for(int i = 0; i < size; i++){
            if(!(pobi.get(i) > 1 && pobi.get(i) < 400)){
                return false;
            }
            if(!(crong.get(i) > 1 && crong.get(i) < 400)){
                return false;
            }
        }
        return true;
    }
}