package onboarding;

import java.util.List;

class Problem1 {
    static final int TOTAL_PAGES = 400;

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int getScore(List<Integer> pageNums){
        int score = 0;
        int leftPage = pageNums.get(0);
        int rightPage = pageNums.get(1);

        //왼쪽 페이지에서 얻어지는 가장 큰 수 구하기
        int leftScore = getBiggerNum(leftPage);

        //오른쪽 페이지에서 얻어지는 가장 큰 수 구하기
        int rightScore = getBiggerNum(rightPage);

        //최종 점수 선택
        score = Math.max(leftScore, rightScore);

        return score;
    }

    public static int getBiggerNum(int page){
        int biggerNum = 0;

        int sumOfEachDigit = getSumOfEachDigit(page);
        int productOfEachDigit = getProductOfEachDigit(page);

        biggerNum = Math.max(sumOfEachDigit, productOfEachDigit);

        return biggerNum;
    }

    public static int getSumOfEachDigit(int num){
        int sum = 0;
        while(num != 0){
            int digit = num % 10;
            sum += digit;
            num /= 10;
        }
        return sum;
    }

    public static int getProductOfEachDigit(int num){
        int product = 1;
        while(num != 0){
            int digit = num % 10;
            product *= digit;
            num /= 10;
        }
        return product;
    }

}