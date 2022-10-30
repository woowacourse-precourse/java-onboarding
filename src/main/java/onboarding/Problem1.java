package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static void main(String[] args) {
        List<Integer> test1 = List.of(97,98);
        List<Integer> test2 = List.of(197,198);

        solution(test1, test2);
        System.out.println("Finish");
    }

    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int oddP = pobi.get(0);
        int evenP = pobi.get(1);
        int oddC = crong.get(0);
        int evenC = crong.get(1);

        if(evenP - oddP == evenC - oddC){
            int[] pobiArr = new int[4];
            int[] crongArr = new int[4];

            for(int i = 0; i < pobiArr.length; i++)
                pobiArr[i] = getPlace(oddP, evenP)[i];

            for(int i = 0; i < crongArr.length; i++)
                crongArr[i] = getPlace(oddC, evenC)[i];


            answer = 1;
        }
        else {
            answer = 0;
        }
        return answer;
    }

    public static int[] getPlace(int pageOdd, int pageEven) {
        int resultArr[] = new int[4];

        int lengthOdd = (int) Math.log10(pageOdd);
        int arrOdd[] = new int[lengthOdd+1];
        int lengthEven = (int) Math.log10(pageEven);
        int arrEven[] = new int[lengthEven+1];

        for(int i = lengthOdd; i > 0; i--){
            arrOdd[lengthOdd-i] = (int) (pageOdd / Math.pow(10, i));
            arrOdd[lengthOdd-i+1] = pageOdd = (int) (pageOdd % Math.pow(10, i));
        }

        for(int i = lengthEven; i > 0; i--){
            arrEven[lengthEven-i] = (int) (pageEven / Math.pow(10, i));
            arrEven[lengthEven-i+1] = pageEven = (int) (pageEven % Math.pow(10, i));
        }
        resultArr[0] = sum(arrOdd, lengthOdd);
        resultArr[1] = sum(arrEven, lengthEven);
        resultArr[2] = mul(arrOdd, lengthOdd);
        resultArr[3] = mul(arrEven, lengthEven);

        return resultArr;
    }

    public static int sum(int[] arr, int leng) {
        int result = 0;
        for(int i = 0; i <= leng; i++)
            result += arr[i];

        return result;
    }

    public static int mul(int[] arr, int leng) {
        int result = 1;
        for(int i = 0; i <= leng; i++)
            result *= arr[i];

        return result;
    }
}