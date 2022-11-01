package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int maxAddPobi, maxMulPobi, maxAddCrong, maxMulCrong, maxPobi, maxCrong;

        if(exception(pobi) || exception(crong)) answer = -1;

        maxAddPobi = compareNum(addPageNumber(pobi.get(0)), addPageNumber(pobi.get(1)));
        maxMulPobi = compareNum(multiplyPageNumber(pobi.get(0)), multiplyPageNumber(pobi.get(1)));
        maxPobi = compareNum(maxAddPobi, maxMulPobi);

        maxAddCrong = compareNum(addPageNumber(crong.get(0)), addPageNumber(crong.get(1)));
        maxMulCrong = compareNum(multiplyPageNumber(crong.get(0)), multiplyPageNumber(crong.get(1)));
        maxCrong = compareNum(maxAddCrong, maxMulCrong);

        if (maxPobi > maxCrong) answer = 1;
        else if (maxPobi < maxCrong) answer = 2;
        else if (maxPobi == maxCrong) answer = 0;
        else answer = -1;

        return answer;

    }

    public static int compareNum(int number1, int number2){

        return Math.max(number1, number2);
    }

    public static int addPageNumber(int number){
        int addSum=0;
        while(number > 0){
            addSum += (number%10);
            number/=10;
        }
        return addSum;
    }

    public static int multiplyPageNumber(int number){
        int mulSum = 1;
        while(number > 0){
            mulSum *= (number%10);
            number/=10;
        }
        return mulSum;
    }

    public static boolean exception(List<Integer> list){
        if(list.size () !=2) return true;
        else if (list.get(0) == null || list.get(1)==null) return true;
        else if (list.get(0) <=1 || list.get(0) <= 1) return true;
        else if (list.get(0) >= 400 || list.get(1) >= 400) return true;
        else if (list.get(0) % 2 == 0 || list.get(1)%2 == 1) return true;
        else return false;
    }

}