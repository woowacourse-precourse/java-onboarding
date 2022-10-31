package onboarding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        System.out.println("pobi: "+ Arrays.toString(pobi.toArray()));
        System.out.println("crong: "+Arrays.toString(crong.toArray()));
        //예외 사항이 나오면 -1 리턴
        int exceptionCase = -1;
        if(pobi.get(0) <= 1 || crong.get(0) <= 1) return exceptionCase;
        if(pobi.get(1) >= 400 || crong.get(1) >= 400) return exceptionCase;
        if(pobi.get(0)+1 != pobi.get(1) || crong.get(0)+1 != crong.get(1)) return exceptionCase;

        //왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        //오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
        ArrayList<Integer> tmpPobi = new ArrayList<>();
        ArrayList<Integer> tmpCrong = new ArrayList<>();

        int pobiPage = pobi.get(0);
        int crongPage = crong.get(0);

        setTmpList(tmpPobi, pobiPage);
        setTmpList(tmpCrong, crongPage);

        // 포비와 크롱의 양쪽 페이지 배열
        int[] leftPobi = new int[tmpPobi.size()]; int[] rightPobi = new int[tmpPobi.size()];
        int[] leftCrong = new int[tmpCrong.size()]; int[] rightCrong = new int[tmpCrong.size()];

        getIntArr(leftPobi, rightPobi, tmpPobi);
        getIntArr(leftCrong, rightCrong, tmpCrong);

        int cobiResult = Math.max(Math.max(addNumber(leftPobi), multiNumber(leftPobi)), Math.max(addNumber(rightPobi), multiNumber(rightPobi)));
        int crongResult = Math.max(Math.max(addNumber(leftCrong), multiNumber(leftCrong)), Math.max(addNumber(rightCrong), multiNumber(rightCrong)));

        System.out.println("cobiResult: "+cobiResult);
        System.out.println("crongResult: "+crongResult);
        return (cobiResult-crongResult == 0) ? 0 : (cobiResult > crongResult) ? 1 : 2;
    }

    public static void setTmpList(ArrayList<Integer> tmp, int page) {
        // 페이지 각 번호가 들어있는 임시 페이지 리스트 만들기
        while(page!=0) {
            tmp.add(page%10);
            page/=10;
        }
    }

    private static int addNumber(int[] numbers) {
        //페이지 더하기
        int sum = numbers[0];
        for(int i=1; i<numbers.length; i++) {
            sum += numbers[i];
        }
        return sum;
    }

    private static int multiNumber(int[] numbers) {
        //페이지 곱하기
        int sum = numbers[0];
        for(int i=1; i<numbers.length; i++) {
            sum *= numbers[i];
        }
        return sum;
    }

    private static void getIntArr(int[] arr1, int[] arr2, ArrayList<Integer> tmp) {
        //페이지 배열 구하기
        for(int i=0; i<arr1.length; i++) {
            if(i==arr1.length-1) {
                arr1[i] = tmp.get(i);
                arr2[i] = arr1[i] + 1;
            }
            arr1[i] = arr2[i] = tmp.get(i);
        }
    }
}