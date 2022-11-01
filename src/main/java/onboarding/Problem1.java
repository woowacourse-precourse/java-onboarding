package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static Boolean notFirst(int firstPage) {
        if (firstPage == 1) return false;
        return true;
    }

    public static Boolean notLast(int lastPage) {
        if (lastPage == 400) return false;
        return true;
    }

    public static Boolean firstLastCheck(List<Integer> user) {
        if (notFirst(user.get(0)) || notLast(user.get(1))) return false;
        return true;
    }

    public static Boolean notSequence(int firstPage, int lastPage) {
        if ((firstPage + 1) != lastPage) return true;
        return false;
    }

    public static List<Integer> eachDigit(int num) {
        List<Integer> digitList = new ArrayList<>();

        while(num > 0) {
            digitList.add(num % 10);
            num /= 10;
        }

        return digitList;
    }

    public static int sumOfDigit(List<Integer> digitList) {
        int result = 0;

        for (Integer list: digitList) {
            result += list;
        }

        return result;
    }

    public static int multiplyOfDigit(List<Integer> digitList) {
        int result = 1;

        for (Integer list: digitList) {
            result *= list;
        }

        return result;
    }

    public static int pageBiggerCalculation(int page) {
        int pageSum = sumOfDigit(eachDigit(page));
        int pageMultiply = multiplyOfDigit(eachDigit(page));

        int Max = pageSum;
        if(pageMultiply > pageSum) Max = pageMultiply;

        return Max;
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        if (firstLastCheck(pobi) || firstLastCheck(crong)) return -1;
        if(notSequence(pobi.get(0), pobi.get(1)) || notSequence(crong.get(0), crong.get(1))) return -1;

        // Case of pobi
        int first = pobi.get(0);
        int second = pobi.get(1);
        int firstCal = pageBiggerCalculation(first);
        int secondCal = pageBiggerCalculation(second);

        int pobiSol = firstCal;
        if(firstCal < secondCal) pobiSol = secondCal;

        // Case of crong
        first = crong.get(0);
        second = crong.get(1);
        firstCal = pageBiggerCalculation(first);
        secondCal = pageBiggerCalculation(second);

        int crongSol = firstCal;
        if(firstCal < secondCal) crongSol = secondCal;

        answer = 0;
        if (pobiSol > crongSol) answer = 1;
        if (crongSol > pobiSol) answer = 2;

        return answer;
    }
}