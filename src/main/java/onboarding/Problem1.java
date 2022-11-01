package onboarding;

import java.util.List;

class Problem1 {

    // 각 자리수를 모두 더하거나 모두 곱해 가장 큰수 구하는 함수 calculation
    public static int calculation(Integer num){
        int plus = 0; // 모두 더한 값이 들어갈 변수
        int multi= 1; // 모두 곱한 값이 들어갈 변수. 곱하기 1은 자기자신임으로 1로 초기화
        int result = 0; // 결과값

        while (num > 0){
            plus += num%10; // 자리수별로 더하기
            multi *= num%10; // 자리수별로 곱하기
            num /= 10;
        }

        // 모두 더한 값과 모두 곱한 값 중 큰 값을 결과로 반환한다.
        result = Math.max(plus, multi);
        return result;
    }

    // 예외처리 함수 fail
    public static boolean fail(List<Integer> list){
        // 각 페이지 변수
        int left = list.get(0);
        int right = list.get(1);

        // 1. 왼쪽은 홀수, 오른쪽은 짝수가 아닐 경우
        if ((left % 2) == 0 )
            return true;
        else if ((right % 2) == 1 )
            return true;

        // 2. 첫페이지와 끝페이지 제외
        if (left == 1 )
            return true;
        else if (right == 400)
            return true;

        // 3. 책이기 때문에 연속된 페이지가 아닐 경우
        if ((left+1) != right)
            return true;

        // 4. list의 길이가 2가 아닐 경우
        if (list.size() != 2)
            return true;

        // 해당 사항 없으면 false
        return false;
    }
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;
        // 포비와 크롱 각각 책 페이지 자리수를 더하거나 곱한 수 중 큰 수를 저장할 변수
        int pAns = 0;
        int cAns = 0;

        // 예외처리 함수 true 일 경우 return -1
        if (fail(pobi) || fail(crong))
            return -1;

        // 포비와 크롱 각각 자리수를 모두 더하거나 모두 곱해 가장 큰수 구하기
        pAns = Math.max(calculation(pobi.get(0)), calculation(pobi.get(1)));
        cAns = Math.max(calculation(crong.get(0)), calculation(crong.get(1)));

        // 포비와 크롱 대결 결과
        // 1. 포비가 이기면
        if (pAns > cAns)
            answer = 1;
        // 2. 크롱이 이기면
        else if (pAns < cAns)
            answer = 2;
        // 3. 무승부일 경우
        else if (pAns == cAns)
            answer = 0;

        return answer;
    }

}

