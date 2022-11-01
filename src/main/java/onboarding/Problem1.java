package onboarding;

import java.util.List;

/**
 * pobi와 crong의 페이지의 정해진 규칙으로 수를 구해서 더 큰 사람을 찾는 게임
 * 기능 목록
 * 1. 변수 초기화
 *      - pobi의 왼쪽페이지와 오른쪽 페이지 leftPo, rightPo
 *      - crong의 왼쪽페이지와 오른쪽 페이지 leftCr, rightCr
 * 2. 예외처리 : checkException(int left, int right)
 *      - 오른쪽페이지 - 왼쪽페이지 = 1인지 (연속된 페이지가 들어왔는지)
 *      - 왼쪽페이지는 홀수 오른쪽페이지는 짝수인지
 * 3. 두 사람 각각의 왼쪽페이지와 오른쪽페이지 비교 : int max(left, rihgt)
 *      - 페이지의 각자리수의 합과 곱을 비교 후 왼쪽 페이지와 오른쪽 페이지 비교해서 더 큰 값 return
 *      - 각자리수의 합 반환 함수 : positionSum, 각자리수의 곱 반환 함수 : positionMultiple
 * 4. 두 사람의 최종 값 비교
 *      - crong이 크면 2 return , pobi의 값이 크면 1 return , 같으면 0 return 나머지 0 return
 */
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        int answer = Integer.MAX_VALUE;

        // 1. 변수 초기화 부분
        int leftPo, rightPo, leftCr, rightCr, maxPo, maxCr;
        leftPo = pobi.get(0);
        rightPo = pobi.get(1);
        leftCr = crong.get(0);
        rightCr = crong.get(1);

        // 2. 예외 처리 부분
        if(!checkException(leftPo, rightPo)){
            return -1;
        }
        if(!checkException(leftCr, rightCr)){
            return -1;
        }

        // 3. 두 사람 각각의 왼쪽페이지와 오른쪽페이지 비교 : int max(left, rihgt)
        maxPo = max(leftPo, rightPo);
        maxCr = max(leftCr, rightCr);

        // 4. 두 사람의 최종 값 비교
        if(maxPo < maxCr){
            answer = 2;
        }else if(maxCr < maxPo){
            answer = 1;
        }else if(maxCr == maxPo) {
            answer = 0;
        }else{
            answer = -1;
        }

        return answer;
    }

    private static boolean checkException(int left, int right) {
        if(left+1 == right && left%2 == 1 && right%2 == 0) return true;
        else return false;
    }

    public static int max(int left, int right){
        int ret = 0;
        left = Math.max(positionSum(left), positionMultiple(left));

        right = Math.max(positionSum(right), positionMultiple(right));

        ret = Math.max(left, right);

        return ret;
    }

    public static int positionSum(int input){
        String x = "" + input;
        int ret=0;

        for(int i=0; i< x.length();i++){
            ret += Character.getNumericValue(x.charAt(i));
        }
        return ret;
    }

    public static int positionMultiple(int input){
        String x = "" + input;
        int ret=1;

        for(int i=0; i< x.length();i++){
            ret *= Character.getNumericValue(x.charAt(i));
        }
        return ret;
    }
}