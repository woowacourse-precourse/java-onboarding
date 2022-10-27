package onboarding;

import java.util.ArrayList;
import java.util.List;

class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        return answer;
    }

    /**
     * 참여자 두 명의 페이지 번호 리스트들을 받아 게임 결과를 반환
     * @param pages1 : 첫 번째 참여자의 page list
     * @param pages2 : 두 번째 참여자의 page list
     * @return 첫 번째 참여자가 이긴다면 1, 두 번째 참여자가 이긴다면 2, 무승부라면 0, 예외사항은 -1
     */
    private int getResult(List<Integer> pages1, List<Integer> pages2){
        try{
            //파라미터 유효성 검사
            checkParameterValidation(pages1, pages2);

            //각 페이지 리스트의 점수 측정
            int score1 = getScore(pages1);
            int score2 = getScore(pages2);

            return compareScore(score1, score2);
        } catch (RuntimeException e){
            return -1;
        }
    }

    /**
     * 두 개의 점수를 비교하여 결과를 리턴
     * @param score1 : 첫 번째 점수
     * @param score2 : 두 번째 점수
     * @return 첫 번째 점수가 더 높다면 1, 두 번째 점수가 더 높다면 2, 점수가 같다면 0
     */
    private int compareScore(int score1, int score2){
        if(score1 > score2){
            return 1;
        } else if (score2 < score1) {
            return 2;
        } else {
            return 0;
        }
    }

    /**
     * 게임 입력값의 유효성을 검사
     * @param pages1 : 첫 번째 참여자의 page list
     * @param pages2 : 두 번째 참여자의 page list
     */
    private void checkParameterValidation(List<Integer> pages1, List<Integer> pages2){
        //페이지 유효성 검사
        checkPagesValidation(pages1);
        checkPagesValidation(pages2);
    }

    /**
     * 페이지 리스트의 유효성을 검사
     * @param pages : 두 개의 페이지를 포함하고 있는 페이지리스트
     */
    private void checkPagesValidation(List<Integer> pages){
        int leftPage = pages.get(0);
        int rightPage = pages.get(1);

        //왼쪽페이지가 홀수 int type 인지, 오른쪽 페이지가 짝수 int type 인지 체크 (NPE 체크가 포함됨)
        if(leftPage % 2 == 1){
            throw new RuntimeException("왼쪽 페이지가 짝수입니다.");
        }
        if (rightPage % 2 == 1) {
            throw new RuntimeException("오른쪽 페이지가 홀수입니다.");
        }

        //오른쪽 페이지가 왼쪽페이지보다 1만큼 더 큰지 체크
        if(rightPage - leftPage != 1){
            throw new RuntimeException("오른쪽 페이지가 왼쪽페이지 보다 1만큼 더 크지 않습니다.");
        }

        //페이지가 1~400 페이지 안에 있는지 체크
        if (leftPage < 1 || rightPage > 400){
            throw new RuntimeException("페이지가 1~400의 범위 밖에 있습니다.");
        }

        //시작면 또는 마지막 면인지 체크
        if(leftPage == 1){
            throw new RuntimeException("시작 면이 나오도록 펼쳤습니다.");
        }
        if(rightPage == 400){
            throw new RuntimeException("마지막 면이 나오도록 펼쳤습니다.");
        }
    }

    /**
     * 숫자 리스트를 받아 각 자리의 한 자리 숫자 리스트를 반환하는 함수
     * @param numList
     * @return 숫자 리스트의 각 자리 수 리스트
     */
    private List<Integer> getDigitList(List<Integer> numList){
        List<Integer> digitList = new ArrayList<>();

        for(int num : numList){
            //일의 자리 추가
            digitList.add(num % 10);
            //10보다 클 경우 10의자리 추가
            if(num > 10){
                digitList.add((num % 100)/10);
            }
            //100보다 클 경우 100의자리 추가
            if(num > 100){
                digitList.add((num % 1000)/100);
            }
        }

        return digitList;
    }

    /**
     * 두 개의 페이지 번호를 받아 게임 점수를 반환
     * @param pages : 책을 펼쳤을 때 나온 두 개의 페이지 번호
     * @return 페이지 번호를 더한 값과 페이지 번호를 곱한 값 중 더 큰 값
     */
    private int getScore(List<Integer> pages){
        List digitList = getDigitList(pages);
        // 각 자리 수를 곱했을 때의 점수
        int multiScore = getMultiplicationOfList(digitList);
        // 각 자리 수를 더했을 때의 점수
        int sumScore = getSumOfList(digitList);

        // 두 점수중 더 큰 점수를 반환
        return getLargerNumber(multiScore, sumScore);
    }

    /**
     * 두 개의 숫자 중 더 큰 수를 반환
     * @param num1 : 첫 번째 숫자
     * @param num2 : 두 번째 숫자
     * @return 두 숫자 중 더 큰 수
     */
    private int getLargerNumber(int num1, int num2){
        if(num1 > num2){
            return num1;
        } else {
            return num2;
        }
    }

    /**
     * 숫자 리스트를 받아 곱을 반환하는 함수
     * @param numList : 숫자 리스트
     * @return 숫자 리스트의 곱
     */
    private int getMultiplicationOfList(List<Integer> numList){
        //결과 초기값 작성
        int result = 1;

        for(int num : numList){
            result *= num;
        }

        return result;
    }

    /**
     * 숫자 리스트를 받아 합을 반환하는 함수
     * @param numList : 숫자 리스트
     * @return 숫자 리스트의 합
     */
    private int getSumOfList(List<Integer> numList) {
        //결과 초기값 작성
        int result = 0;

        for (int num : numList){
            result += num;
        }

        return result;
    }
}