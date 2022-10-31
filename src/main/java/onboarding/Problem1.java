package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = -1;
        if (pobi.get(0) + 1 != pobi.get(1) || pobi.get(0) % 2 != 1 || pobi.get(1) % 2 != 0 || crong.get(0) + 1 != crong.get(1) || crong.get(0) % 2 != 1 || crong.get(1) % 2 != 0) {
            return answer;
        } else {
            int pobiNum = compare(pobi);
            int crongNum = compare(crong);

            if (pobiNum == crongNum) {
                answer = 0;
            } else if (pobiNum > crongNum) {
                answer = 1;
            } else {
                answer = -1;
            }
        }
        return answer;
    }

    public static int compare(List<Integer> numList) {
        int leftNum = makeNum(numList.get(0));
        int rightNum = makeNum(numList.get(1));
        if (leftNum > rightNum) {
            return leftNum;
        } else {
            return rightNum;
        }
    }

    public static int makeNum(int number) {
        int startNum = number;
            int[] arrNum = {};
            int i = 0;
            while (startNum > 0) {
                arrNum[i] = startNum % 10;
                startNum /= 10;
                i++;
            }
            int addNum = 0;
            int mulNum = 1;
            for (int a = 0; a < arrNum.length; a++) {
                addNum += arrNum[a];
                mulNum *= arrNum[a];
            }
            if (addNum > mulNum) {
                return addNum;
            } else {
                return mulNum;
            }
    }
}