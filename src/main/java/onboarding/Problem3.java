/**
 * 369게임은 1부터 시작해 매개변수 number까지 박수치는 횟수를 구한다.
 * 반복문을 통해 1~number까지 박수치는 횟수를 각각 카운트 후 총 횟수에 더해준다.
 */

package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 1; i <= number; i++) {
            answer += clap_count(i);
        }

        return answer;
    }

    // 해당 숫자는 몇 번 박수를 치는지 카운트하는 함수
    static int clap_count(int num){
        // num의 각 자리를 알아보기 위해 String tmp 선언
        String tmp = Integer.toString(num);
        // 총 카운트 횟수
        int cnt = 0;

        // 각 자리의 숫자들을 보며 3, 6, 9이면 cnt를 1씩 증가시킨다.
        for (int i = 0; i < tmp.length(); i++) {
            if(tmp.charAt(i) == '3'
                || tmp.charAt(i) == '6'
                || tmp.charAt(i) == '9'){
                cnt++;
            }
        }

        return cnt;
    }
}
