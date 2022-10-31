package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int pobi1 = pobi.get(0);
        int pobi2 = pobi.get(1);
        int crong1 = crong.get(0);
        int crong2 = crong.get(1);
        if (errorCheck(pobi1, pobi2) == 0 && errorCheck(crong1, crong2) == 0) {
            answer = returnNum(
                    compareNum(calculator(cutNum(pobi1)), calculator(cutNum(pobi2))),
                    compareNum(calculator(cutNum(crong1)), calculator(cutNum(crong2))));
        }
        else
            return (-1);
        return answer;
    }
    public static int errorCheck(int num1, int num2) {
        if (num2 - num1 != 1)
            return (-1);
        if (num1 % 2 != 1)
            return (-1);
        if (num1 < 1 || num2 < 1 || num1 > 400 || num2 > 400)
            return (-1);
        return (0);
    }
    public static List<Integer> cutNum(int num){
        List<Integer> numList = new ArrayList<Integer>();
        while (num > 0){
            numList.add(num % 10);
            num = num / 10;
        }
        return numList;
    }

    public static int calculator(List<Integer> num) {
        int num1 = 0;
        int num2 = 1;

        for (int i=0;i<num.size();++i) {
            num1 += num.get(i);
            num2 *= num.get(i);
        }
        return (compareNum(num1, num2));
    }
    public static int compareNum(int num1, int num2) {
        if (num1 > num2)
            return num1;
        else
            return num2;
    }

    public static int returnNum(int num1, int num2) {
        if (num1 == num2)
            return (0);
        else if (compareNum(num1, num2) == num1)
            return (1);
        else if (compareNum(num1, num2) == num2)
            return (2);
        else
            return (-1);
    }
}