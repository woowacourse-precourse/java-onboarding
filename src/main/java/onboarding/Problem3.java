package onboarding;

/**
 * 기능 목록
 * 1. 주어진 숫자는 몇 번의 손뼉을 쳐야하는지 계산하는 함수
 * 2. 1~number까지 1번 함수를 호출하고 리턴값을 모두 더해 반환
 */
public class Problem3 {
    static int calClapCnt(int num) {
        int cnt = 0;
        for (char ch: Integer.toString(num).toCharArray()) {
            if (ch == '3' || ch == '6' || ch == '9') {
                cnt++;
            }
        }
        return cnt;
    }

    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i <= number; i++) {
            answer += calClapCnt(i);
        }
        return answer;
    }
}
