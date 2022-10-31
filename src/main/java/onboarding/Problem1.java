package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 * 페이지 번호 게임 문제
 *
 * 문제 설명 :
 * 포비와 크롱이 페이지 번호가 1부터 시작되는 400 페이지의 책을 주웠다.
 * 책을 살펴보니 왼쪽 페이지는 홀수, 오른쪽 페이지는 짝수 번호이고 모든 페이지에는 번호가 적혀있었다.
 * 책이 마음에 든 포비와 크롱은 페이지 번호 게임을 통해 게임에서 이긴 사람이 책을 갖기로 한다.
 *
 * 게임 규칙 :
 * 1.책을 임의로 펼친다.
 * 2. 왼쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 3. 오른쪽 페이지 번호의 각 자리 숫자를 모두 더하거나, 모두 곱해 가장 큰 수를 구한다.
 * 4. 2~3 과정에서 가장 큰 수를 본인의 점수로 한다.
 * 5. 점수를 비교해 가장 높은 사람이 게임의 승자가 된다.
 * 6. 시작 면이나 마지막 면이 나오도록 책을 펼치지 않는다.
 * 7. 포비와 크롱이 펼친 페이지가 들어있는 리스트/배열 pobi와 crong이 주어질 때, 포비가 이긴다면 1, 크롱이 이긴다면 2, 무승부는 0, 예외사항은 -1로 return 하도록 solution 메서드를 완성하라.
 *
 * 제한사항 :
 * - pobi와 crong의 길이는 2이다.
 * - pobi와 crong에는 [왼쪽 페이지 번호, 오른쪽 페이지 번호]가 순서대로 들어있다.
 *
 * @author scyllacore
 * @version 1.1 2022/10/31
 */

class Problem1 {
    /*
     * 구현 사항 :
     * 1. isValidPage : page 쌍 오류 검사.
     * 2. createSeparatedDigitList : 각 자리를 분리하고 그 값을 list로 만들어 줌.
     * 3-1. getBiggerCalculation : getSeparatedDigits에서 반환된 list를 가지고 score 계산.
     * 3-2. getBiggerPageScore : getBiggerCalculation에서 반환된 값을 가지고 최종 score 계산.
     * 4. solution : getBiggerPageScore을 통해 두 user의 최종 score를 비교하고 승부 결과 return.
     */


    /**
     * 1. user의 page에 대해 예외 검사.
     * @param pairPages user가 펼친 page의 쌍.
     * @return 정상적인 page쌍인 경우 return ture 아니면 false.
     */
    static boolean isValidPage(List<Integer> pairPages) {

        int leftPage = pairPages.get(0);
        int rightPage = pairPages.get(1);

        /* 1-1. 홀짝 확인 : 왼쪽 페이지가 홀수,오른쪽 페이지는 짝수이어야함. */
        if (leftPage % 2 != 1 || rightPage % 2 != 0)        // 왼쪽이 홀수가 아니거나, 오른쪽이 짝수가 아닌 경우 오류.
        {
            return false;
        }

        /* 1-2. 1~400 범위 확인 : page 범위는 1~400 까지이어야함. */
        if (leftPage < 1 || leftPage > 400 || rightPage < 1 || rightPage > 400) {       // page 범위를 벗어 나는 경우 오류.
            return false;
        }

        /* 1-3. page 차이가 1인 것을 확인 : page가 쌍으로 존재할 때 그 차이가 1이어야함. */
        if (rightPage - leftPage != 1) {        // page 차이가 1이 아닌 경우 오류.
            return false;
        }

        /* 1-4. 그 외에는 오류 없음 처리. */
        return true;
    }


    /**
     * 2. user의 page에 대해 각 자릿수 분리 후, 이 값들을 list에 저장해 반환.
     * @param pageNumber 두 쌍 중 한 page의 번호.
     * @return 각 자리 값을 저장한 list.
     */
    static List<Integer> createSeparatedDigitList(int pageNumber) {

        List<Integer> separatedDigitList = new ArrayList<>();
        int digit;
        int remainedNumber = pageNumber;

        /* 각 자리를 떼어서 list에 저장. */
        while (remainedNumber > 0) {
            digit = remainedNumber % 10;
            separatedDigitList.add(digit);

            remainedNumber /= 10;
        }

        return separatedDigitList;

    }


    /**
     * 3-1. getSeparatedDigits에서 반환된 각 자리 List를 가지고 총합,곱을 계산 후, 둘 중 더 큰 값 반환.
     * @param separatedDigitList 분리된 자리 list.
     * @return 연산 결과가 더 큰 값.
     */
    static int getBiggerCalculation(List<Integer> separatedDigitList) {

        int summation = 0;
        int multiplication = 1;


        /* 총합, 총 곱셈 메소드 하나로 통합. */
        for (int digit : separatedDigitList) {
            summation += digit;
            multiplication *= digit;
        }

        return Math.max(summation, multiplication);
    }


    /**
     * 3-2. getBiggerCalculation에서 반환된 페이지 값에 대해 대소관계 비교 후, 더 큰 값 반환.
     * @param pairPages user가 펼친 page의 쌍.
     * @return 최종적으로 연산된 user의 score 값.
     */
    static int getBiggerPageScore(List<Integer> pairPages) {

        int leftPage = pairPages.get(0);
        int rightPage = pairPages.get(1);

        /* 각 자리수 list 가져오기. */
        List<Integer> leftDigitList = createSeparatedDigitList(leftPage); 
        List<Integer> rightDigitList = createSeparatedDigitList(rightPage);

        /* 가장 크게 만들 수 있는 score 계산. */
        int leftPageScore = getBiggerCalculation(leftDigitList); 
        int rightPageScore = getBiggerCalculation(rightDigitList);

        return Math.max(leftPageScore, rightPageScore);
    }

    
    /**
     * 4. getBiggerPageScore을 통해 두 user의 최종 score를 비교하고 승부 결과 return.
     * @param pobi user1의 page 쌍 정보를 담고있음.
     * @param crong user2의 page 쌍 정보를 담고있음.
     * @return 승부 결과.
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (!isValidPage(pobi) || !isValidPage(crong)) {
            return -1;      // 게임 진행 불가
        }

        int pobiScore = getBiggerPageScore(pobi);
        int crongScore = getBiggerPageScore(crong);

        if (pobiScore > crongScore) {
            return 1;       // pobi 승
        } else if (pobiScore < crongScore) {
            return 2;       // crong 승
        } else {
            return 0;       // 무승부
        }

    }
}