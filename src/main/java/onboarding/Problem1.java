package onboarding;

import java.util.List;

class Problem1 {
    /*
     *  간단한 구현문제
     *  1. 입력값이 올바른지 확인
     *  2. digitSum, digitMul 함수 (각각 자릿수를 더해주는 함수와 곱해주는 함수임)를 사용해 점수를 계산
     *  3. 계산된 점수에 따라 결과값 반환
     */
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if(!isValid(pobi) || !isValid(crong))
            return -1;
        int answer = -1;

        // 포비의 점수 구하기
        int pobiMax = 0;
        for(int i =0; i<pobi.size(); i++){
            if(pobi.get(i) <= 0 || pobi.get(i) > 400)
                return -1;
            int pageMax = Integer.max(digitMul(pobi.get(i)), digitSum(pobi.get(i)));
            pobiMax = Integer.max(pageMax, pobiMax);
        }

        // 크롱의 점수 구하기
        int crongMax = 0;
        for(int i =0; i<crong.size(); i++){
            if(crong.get(i) <= 0 || crong.get(i) > 400)
                return -1;
            int pageMax = Integer.max(digitMul(crong.get(i)), digitSum(crong.get(i)));
            crongMax = Integer.max(pageMax, crongMax);
        }

        // 결과 생성
        if(pobiMax == crongMax)
            answer = 0;
        else if(pobiMax > crongMax)
            answer = 1;
        else
            answer = 2;

        return answer;
    }

    private static boolean isValid(List<Integer> input){
        if(input == null) // 혹시 null이 들어온다면
            return false;
        if(input.size() != 2) // 길이가 2가 아닐경우
            return false;
        if(input.get(0)%2 == 0) // 왼쪽 페이지가 홀수가 아닐 경우
            return false;
        if(input.get(1) - input.get(0) != 1) // 두페이지가 연속된 페이지가 아닐 경우
            return false;
        return true;
    }

    private static int digitSum(Integer number){
        int result = 0;
        while(number != 0){
            result += number%10;
            number /= 10;
        }
        return result;
    }

    private static int digitMul(Integer number){
        int result = 1;
        while(number != 0){
            result *= number%10;
            number /= 10;
        }
        return result;
    }
}