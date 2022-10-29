package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        //제한사항에 대한 예외처리
        if(checkBookPage(pobi) || checkBookPage(crong)){
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
        //비교해서 값을 반환한다.
        if(pobiMax > crongMax){
            answer = 1;
        }else if(crongMax > pobiMax){
            answer = 2;
        }else{
            answer = 0;
        }
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
    /**
     * @param pageList : 책 페이지 리스트
     * @return pageList가 두개의 값, 연속된 정수, 두개의 정수가 0과 400사이에 숫자가 아닐경우 true, 맞을경우 false를 반환
     */
    private static boolean checkBookPage(List<Integer> pageList){
        if(pageList.size() != 2 || !pageList.get(1).equals(pageList.get(0)+1) || !(pageList.get(1) > 0 && pageList.get(1) < 400) || !(pageList.get(0) > 0 && pageList.get(0) < 400)){
            return true;
        }else
            return false;
    }
}