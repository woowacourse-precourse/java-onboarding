package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    /*
     * 기능 정리
     * 1. 각 user에 대한 page error 검사(홀짝 확인, 1~400 범위 확인, page 차이 1인 것 확인)
     * 2. user의 페이지에 대해 자리수 분리 후, 분리한 각 자리 list 반환
     * 3-1. 반환된 list를 가지고 한 페이지에 대한 총합 및 총 곱셈 계산 후, 더 큰 계산값 반환
     * 3-2. 반환된 두 페이지 값에 대해 대소관계 비교 후, 더 큰 값 반환하며 user의 값 결정.
     * 4. 이렇게 결정된 두 user의 값을 비교하여 최종 answer값 return
     * */

    //1. 기능1
    static boolean isValidPage(List<Integer> pairPages) {

        // #유의 사항 : 메소드,변수명을 정의할 때는 카멜 표기법을 따르며, 메소드명은 동사로 시작하도록 한다.

        int leftPage = pairPages.get(0);
        int rightPage = pairPages.get(1); // 자주 사용하는 값을 변수에 담음. 한 번만 메소드를 호출하고 값에 의미 부여

        //1-1. 왼쪽 페이지가 홀수,오른쪽 페이지는 짝수이어야함.
        if (leftPage % 2 != 1 || rightPage % 2 != 0) //  왼쪽이 홀수가 아니거나, 오른쪽이 짝수가 아닌 경우 오류
        {
            return false;
        }

        // 1-2. 페이지는 1~400 까지이어야함.
        if (leftPage < 1 || leftPage > 400 || rightPage < 1 || rightPage > 400) { // 페이지 범위를 벗어 나는 경우 오류
            return false;
        }

        // 1-3. 페이지는 쌍으로 존재함으로 그 차이가 1이어야함.
        if (rightPage - leftPage != 1) { // 페이지 차이가 1이 아닌 경우 오류
            return false;
        }

        // 1-4. 그 외에는 오류 없음 처리
        return true;
    }

    //2. 기능2
    static List<Integer> getSeparatedDigits(int pageNumber) {
        
        List<Integer> separatedDigitList = new ArrayList<>();
        int digit;
        int remainedNumber = pageNumber;

        while (remainedNumber > 0) {
            digit = remainedNumber % 10;
            separatedDigitList.add(digit);

            remainedNumber /= 10;
        }

        return separatedDigitList;

    }

    
    //3. 기능3

    //3-1. 한 페이지에 대해 총합 및 총 곱셈 계산 후, 더 큰 계산값 반환
    static int getBiggerCalculation(List<Integer> separatedDigitList) {
        
        int summation = 0;
        int multiplication = 1;

        
        //총합, 총 곱셈 메소드 하나로 통합
        for (int digit : separatedDigitList) {
            summation += digit;
            multiplication *= digit;
        }

        return Math.max(summation,multiplication);
    }


    //3-2. 기능3 페이지 쌍끼리 대소관계 비교 (실행 순서에 따라 함수를 배치할 것인지, 중요도에 따라 배치할 것인지 고민해볼 것)
    static int getBiggerPageScore(List<Integer> pairPages) {

        int leftPage = pairPages.get(0);
        int rightPage = pairPages.get(1);

        List<Integer> leftDigitList = getSeparatedDigits(leftPage);
        List<Integer> rightDigitList = getSeparatedDigits(rightPage);

        int leftPageScore = getBiggerCalculation(leftDigitList);
        int rightPageScore = getBiggerCalculation(rightDigitList);

        return Math.max(leftPageScore,rightPageScore);
    }

    //4. 기능4
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isValidPage(pobi) || !isValidPage(crong)){
            return -1;
        }

        int pobiScore = getBiggerPageScore(pobi);
        int crongScore = getBiggerPageScore(crong);

        if(pobiScore > crongScore){
            return 1;
        }
        else if(pobiScore < crongScore){
            return 2;
        }
        else{
            return 0;
        }

    }
}