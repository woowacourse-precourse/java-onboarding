package onboarding;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        int bookFirstPage = 1;
        int bookLastPage = 400;

        try {
            int[] pobisPageByPageResult = new int[2];
            int[] crongsPageByPageResult = new int[2];

            for(int index = 0; index <2 ; index ++) {
                if ( bookFirstPage <= pobi.get(index)  &&  pobi.get(index) <= bookLastPage ) {
                    ArrayList<Integer> pobisEachDigit = getEachDigit(pobi.get(index));
                    pobisPageByPageResult[index] = calculationMyScore(pobisEachDigit);

                }

                if ( bookFirstPage <= crong.get(index)  &&  crong.get(index) <= bookLastPage ) {
                    ArrayList<Integer> crongsEachDigit = getEachDigit(crong.get(index));
                    crongsPageByPageResult[index] = calculationMyScore(crongsEachDigit);
                }
            }
        } catch (Exception exception) {
            System.out.println("입력값은 1이상 400이하의 숫자만 가능합니다.(null 불가)");
        }
        return answer;
    }

    public static ArrayList<Integer> getEachDigit(int page) {
        ArrayList<Integer> eachDigitArray = new ArrayList<>();
        while(page > 0) {
            int eachDigit = page % 10;
            eachDigitArray.add(eachDigit);
            page /= 10;
        }
        return(eachDigitArray);
    }

    public static int calculationMyScore(ArrayList<Integer> whoesEachDigit) {
        int plusTotal = 0;
        int multiplicationTotal = 0;
        for(int loopCount = 0; loopCount < whoesEachDigit.size(); loopCount++) {
            plusTotal += whoesEachDigit.get(loopCount);
            multiplicationTotal += whoesEachDigit.get(loopCount);
        }
        int pageResult = Math.max(plusTotal, multiplicationTotal);

        return pageResult;
    }

}