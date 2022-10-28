package onboarding;

import java.util.List;

public class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (isException(pobi) || isException(crong)) {
            return -1;
        }

        // pobi = [97, 98] crong = [197, 198]
        String[] pobiStrArr = new String[2];
        String[] crongStrArr = new String[2];

        for (int index = 0; index < 2; index++) {
            pobiStrArr[index] = String.valueOf(pobi.get(index));
            crongStrArr[index] = String.valueOf(crong.get(index));
        }

        int valuePobi = getMaxValue(pobiStrArr);
        int valueCrong = getMaxValue(crongStrArr);

        int answer = getAnswer(valuePobi, valueCrong);
        return answer;
    }

    private static boolean isException(List<Integer> list) {
        // 범위를 넘었는가 검사
        if (list.get(0) < 1 || list.get(0) > 400
                || list.get(1) < 1 || list.get(1) > 400) {
            return true;
        }
        // left가 홀수인가, right가 짝수인가
        else if (list.get(0) % 2 != 1
                || list.get(1) % 2 != 0) {
            return true;
        }
        // left와 right가 연달아 있는가
        else if (list.get(1) - list.get(0) != 1) {
            return true;
        } else {
            return false;
        }
    }

    private static int getAnswer(int valuePobi, int valueCrong) {
        if (valuePobi == valueCrong) {
            return 0;
        } else if (valuePobi > valueCrong) {
            return 1;
        } else if (valuePobi < valueCrong) {
            return 2;
        } else {
            return -1;
        }
    }

    private static int getMaxValue(String[] strArr) {
        int left = 0, right = 1;
        int[] valueArr = new int[4];
        valueArr[0] = getSumParseString(strArr[left]);
        valueArr[1] = getSumParseString(strArr[right]);
        valueArr[2] = getMultiplParseString(strArr[left]);
        valueArr[3] = getMultiplParseString(strArr[right]);
        int addMax = Math.max(valueArr[0], valueArr[1]);
        int MultiplMax = Math.max(valueArr[2], valueArr[3]);

        return Math.max(addMax, MultiplMax);
    }

    public static int getSumParseString(String str) {
        String[] strArr = getSplitArr(str);
        int sum = 0;
        for (String value : strArr) {
            sum = sum + Integer.parseInt(value);
        }
        return sum;
    }

    public static int getMultiplParseString(String str) {
        String[] strArr = getSplitArr(str);
        int sum = 1;
        for (String value : strArr) {
            sum = sum * Integer.parseInt(value);
        }
        return sum;
    }

    public static String[] getSplitArr(String strArr) {
        return (strArr.split(""));
    }
}