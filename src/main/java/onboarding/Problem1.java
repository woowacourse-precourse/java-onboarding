package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    public static int makeNum(int page){
        // 각 자리의 페이지 수를 저장할 ArrayList 생성
        // page가 한 자리수, 두 자리 수, 세 자리수가 될 수 있기 때문에 크기가 가변적으로 변하는 ArrayList 사용
        ArrayList<Integer> pageNums = new ArrayList<Integer>();
        int multiplyNums = 1;
        int addNums = 0;

        while(page > 0){
            // page값의 각 자리수를 pageNums에 저장
            pageNums.add(page %10);
            // page값을 계속 page를 10으로 나눈 몫으로 바꾸어주어 자릿수에 맞게 반복문이 실행되도록 설정
            page = page / 10;
        }

        // 페이지를 모두 더하거나 곱한 값을 계산
        for (int num : pageNums){
            multiplyNums *= num;
            addNums += num;
        }

        // 더 큰 수를 return
        return (multiplyNums > addNums) ? multiplyNums : addNums;
    }

}