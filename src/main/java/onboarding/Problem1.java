package onboarding;

import java.util.List;
class Problem1 {
    public static int solution(List<Integer> pobi, List<Integer> crong) {
        if (error_check(pobi, crong) == -1) return -1; // 예외상황 체크, 예외상황시 -1 return 하며 종료

        int answer;
        int[] pobi_result = new int[2];     // pobi의 결과값을 담을 int[]
        int[] crong_result = new int[2];    // crong의 결과값을 담을 int[]
        for(int i =0; i<2;i++) {
            pobi_result[i] = calculation(pobi.get(i));      // 계산한 결과를 list에 넣기
            crong_result[i] = calculation(crong.get(i));
        }
        if (Math.max(pobi_result[0], pobi_result[1]) > Math.max(crong_result[0], crong_result[1])) answer = 1;      // pobi 승리
        else if (Math.max(pobi_result[0], pobi_result[1]) < Math.max(crong_result[0], crong_result[1])) answer = 2; // crong 승리
        else answer = 0;    // 무승부

        return answer;
    }
    public static int error_check(List<Integer> pobi, List<Integer> crong){ // 에러 체크를 위한 메서드
        int error = 0;
        if (pobi.get(0) +1 != pobi.get(1) | crong.get(0)+1 != crong.get(1)) error = -1;             // 페이지 차이가 1 이상인 경우
        else if (pobi.get(0)%2 ==0 | crong.get(0)%2 ==0) error = -1;                                // 왼쪽 페이지가 짝우인 경우
        else if(pobi.get(0)<=1 | pobi.get(1)>=400 | crong.get(0)<=1 | crong.get(1)>=400) error = -1;// 페이지 수가 범위 벗어난 경
        return error;
    }
    public static int calculation(int num) {    // 더하기 및 곱하기 계산을 하고 더 큰 값을 반환하는 메서드
        int add_result = 0;     // 더하기 결과 초기화
        int multiple_result = 1;// 곱하기 결과 초기화
        int tmp;                // 한 자리씩 꺼내기 위해 값을 임시 저장할 변수 선언
        while (num != 0) {
            tmp = num%10;
            add_result += tmp;
            multiple_result *= tmp;
            num = (int) (num*0.1);
        }
        return Math.max(add_result, multiple_result);
    }
}