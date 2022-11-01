package onboarding;

import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // List<Integer> -> int[]배열로 전환
        int[] pobiArray = pobi.stream().mapToInt(i -> i).toArray();
        int[] crongArray = crong.stream().mapToInt(i -> i).toArray();

        boolean page = validation(pobiArray, crongArray);
        if (!page) {
            return -1;
        }

        int pobiSum = sum(pobiArray);
        int pobiMul = mul(pobiArray);
        int pobiMaxScore = maxScore(pobiSum, pobiMul);

        int crongSum = sum(crongArray);
        int crongMul = mul(crongArray);
        int crongaxScore = maxScore(crongSum, crongMul);


        if(pobiMaxScore > crongaxScore) {
            return  1;
        } else if (pobiMaxScore < crongaxScore) {
            return 2;
        } else if (pobiMaxScore == crongaxScore) {
            return 0;
        } else {
            return -1;
        }

    }

    private static int sum(int[] value) {
            int val_1 = 0;
            int val_2 = 0;

            String[] array1 = String.valueOf(value[0]).split("");
            for (String val : array1) {
                val_1 = val_1 + Integer.valueOf(val);
            }

            String[] array2 = String.valueOf(value[1]).split("");
            for (String val : array2) {
                val_2 = val_2 + Integer.valueOf(val);
            }

            return maxScore(val_1, val_2);
        }

    static private int mul(int value[]) {

        int val_1 = 1;
        int val_2 = 2;

        String[] array1 = String.valueOf(value[0]).split("");
        for (String val : array1) {
            val_1 = val_1 * Integer.valueOf(val);
        }

        String[] array2 = String.valueOf(value[1]).split("");
        for (String val : array2) {
            val_2 = val_2 * Integer.valueOf(val);
        }

        return maxScore(val_1, val_2);
    }

    static private int maxScore(int a, int b) {
        if (a > b){
            return a;
    } else {
            return b;
        }
    }

    static private boolean validation(int[] pobi, int[] crong) {

        boolean result = true;

        if (1 != Math.abs(pobi[0] - pobi[1])) {
            return false;
        } else if (1 != Math.abs(crong[0] - crong[1])) {
            return false;
        } else {
            return result;
        }
    }

    }