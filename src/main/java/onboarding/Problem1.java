package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {

        // 에러 체크
        if (isError(pobi) || isError(crong)) {
            return -1;
        }

        // 포비와 크롱의 최대 값 구하기
        Integer pobiNum = getLargestNum(pobi);
        Integer crongNum = getLargestNum(crong);

        // 포비와 크롱의 숫자 비교 후 결과 반환
        int answer = returnAnswer(pobiNum, crongNum);

        return answer;
    }

    private static int returnAnswer(Integer pobiNum, Integer crongNum) {

        if (pobiNum > crongNum) {
            return 1;
        } else if (pobiNum == crongNum) {
            return 0;
        } else if (pobiNum < crongNum) {
            return 2;
        }
        
        // 위의 세가지 경우가 아니라면 뭔가가 잘못된 경우
        return -1;
    }

    private static Integer getLargestNum(List<Integer> pages) {

        // 페이지 값
        Integer left = pages.get(0);
        Integer right = pages.get(1);

        // 스트림 연산을 위한 리스트화
        List<Integer> leftNumList = getNumberList(left);
        List<Integer> rightNumList = getNumberList(right);

        // 최대값 구하기
        Integer leftLargestNum = cal(leftNumList);
        Integer rightLargestNum = cal(rightNumList);

        return Math.max(leftLargestNum , rightLargestNum);
    }

    private static Integer cal(List<Integer> list) {
        // 총합 , 총곱 중 최대 값 구하기
        return Math.max(
                list.stream().reduce((total, now) -> total + now).get() ,
                list.stream().reduce((total, now) -> total * now).get()
        );
    }

    private static List<Integer> getNumberList(Integer num) {
        List<Integer> list = new ArrayList<>();
        // 모듈러 연산을 통해 각 자리별 숫자 리스트 생성
        while (num != 0) {
            list.add(num % 10);
            num /= 10;
        }
        return list;
    }

    private static boolean isError(List<Integer> pages) {
        if (pages.size() != 2) {
            return true;
        }
        // 페이지 값
        Integer left = pages.get(0);
        Integer right = pages.get(1);

        // 왼쪽 | 오른쪽 페이지 번호 차이가 1이 아닐 때 , 왼쪽이 홀수가 아닐 때 , 오른쪽이 짝수가 아닐 때
        if(Math.abs(left - right) != 1 || left % 2 != 1 || right % 2 != 0) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        List<Integer> pobi = List.of(89, 11);
        List<Integer> crong = List.of(211, 212);

        solution(pobi, crong);
    }
}