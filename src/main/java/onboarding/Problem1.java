package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {

    //pobi와 crong의 길이는 2이다.
    //pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        // 왼쪽, 오른쪽 페이지로 만들 수 있는 숫자 만들기
        int pobiLeftMakeNum = makeNum(pobi.get(0));
        int pobiRightMakeNum = makeNum(pobi.get(1));
        int crongLeftMakeNum = makeNum(crong.get(0));
        int crongRightMakeNum = makeNum(crong.get(1));

        // 만든 수 중 가장 큰 수 찾기
        int pobiMaxNum = returnMaxNum(pobiLeftMakeNum,pobiRightMakeNum);
        int crongMaxNum = returnMaxNum(crongLeftMakeNum,crongRightMakeNum);
        
        // 가장 큰 수를 찾은 것 중 비교하여 결과값 return
        return compareNums(pobiMaxNum,crongMaxNum);
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

    public static int returnMaxNum(int num1, int num2){
        return (num1 > num2) ? num1 : num2;
    }

    public static int compareNums(int pobi, int crong){
        if (pobi == crong) return 0;
        else if (pobi > crong) return 1;
        else return 2;
    }

}