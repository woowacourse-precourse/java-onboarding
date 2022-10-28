package onboarding.solution1;

import java.util.List;

public class ScoreCalculator {
    private static int lenNum (int num) {
        int count = 0;
        while (num != 0){
            num /= 10;
            count++;
        }
        return count;
    }
    private static int[] getEachNumber(int num) {
        int len = lenNum(num);
        int[] eachNum = new int[len];
        int i = 0;
        while (num > 0){
            eachNum[i++] = num % 10;
            num /= 10;
        }
        return eachNum;
    }
    private static int plus(int[] eachNum) {
        int res = 0;
        for (int i : eachNum){
            res += i;
        }
        return res;
    }

    private static int multiple(int[] eachNum){
        int res = 1;
        for (int i : eachNum){
            res *= i;
        }
        return res;
    }

    private static int maxNum(int plus, int multiple){
        if (plus >= multiple)
            return plus;
        return multiple;
    }

    private static int calculator(int num){
        int[] eachNum = getEachNumber(num);
        int numPlus = plus(eachNum);
        int numMultiple = multiple(eachNum);
        return maxNum(numPlus, numMultiple);
    }

    public static int findScore(List<Integer> page){
        int[] res = new int[2];
        int i = 0;
        for(int num : page){
            res[i++] = calculator(num);
        }
        return (maxNum(res[0], res[1]));
    }
}