package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if(pageCheck(pobi) == -1 || pageCheck(crong) == -1)
            return -1;

        int pobiMaxNumber = getMaxNumber(pobi);
        int crongMaxNumber = getMaxNumber(crong);

        if(pobiMaxNumber > crongMaxNumber)
            answer = 1;
        else if(pobiMaxNumber < crongMaxNumber)
            answer = 2;
        else if(pobiMaxNumber == crongMaxNumber)
            answer = 0;

        return answer;
    }

    private static int pageCheck(List<Integer> list){
        int leftPage = list.get(0);
        int rightPage = list.get(1);

        if(leftPage <= 1 || rightPage >= 400)
            return -1;

        if(rightPage - leftPage != 1)
            return -1;

        return 0;
    }

    private static int getMaxNumber(List<Integer> list){
        int leftPageNumber = Math.max(addEachNumber(list.get(0)), multiplyEachNumber(list.get(0)));
        int rightPageNumber = Math.max(addEachNumber(list.get(1)), multiplyEachNumber(list.get(1)));

        return Math.max(leftPageNumber, rightPageNumber);
    }

    private static int addEachNumber(int num){
        int sum = 0;

        while(num != 0){
            sum += num % 10;
            num /= 10;
        }

        return sum;
    }

    private static int multiplyEachNumber(int num) {
        int multiply = 1;

        while(num != 0){
            multiply *= num % 10;
            num /= 10;
        }

        return multiply;
    }
}