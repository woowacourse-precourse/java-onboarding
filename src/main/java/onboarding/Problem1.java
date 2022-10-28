package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //페이지 연속성에 대한 예외처리
        if(!pobi.get(1).equals(pobi.get(0)+1) || !crong.get(1).equals(crong.get(0)+1) || crong.size() != pobi.size()){
            return -1;
        }
        List<Integer> pobiResult = new ArrayList<Integer>();
        List<Integer> crongResult = new ArrayList<Integer>();

        //각 페이지를 더하고 곱한 값을 리스트에 넣는다.
        for(int i=0; pobi.size() > i; i++){
            List<Integer> pobiPageNumber = splitInteger(pobi.get(i));
            List<Integer> crongPageNumber = splitInteger(crong.get(i));

            pobiResult.add(sumIntegerList(pobiPageNumber));
            pobiResult.add(multipleIntegerList(pobiPageNumber));
            crongResult.add(sumIntegerList(crongPageNumber));
            crongResult.add(multipleIntegerList(crongPageNumber));
        }
        //각 리스트의 가장 큰 값을 추출한다.
        int pobiMax = Collections.max(pobiResult);
        int crongMax = Collections.max(crongResult);

        return answer;
    }

    /**
     * @param number : 정수
     * @return number에 각 자리수를 역순으로 List형태로 반환
     */
    private static List<Integer> splitInteger(int number) {
        List<Integer> numberList = new ArrayList<Integer>();

        while(number > 0){
            numberList.add(number % 10);
            number /= 10;
        }
        return numberList;
    }

    /**
     * @param numberList : 정수 리스트
     * @return numberList의 모든 값들의 합 반환
     */
    private static int sumIntegerList(List<Integer> numberList) {
        return numberList.stream().mapToInt(Integer::intValue).sum();
    }

    /**
     * @param numberList : 정수 리스트
     * @return numberList의 모든 값들의 곱 반환
     */
    private static int multipleIntegerList(List<Integer> numberList) {
        int number = 1;

        for(int i=0; numberList.size() > i; i++){
            number *= numberList.get(i);
        }
        return number;
    }
}