package onboarding;

public class Problem3 {
    public static int solution(int number) {
        // 총 손뼉을 몇 번 쳐야 하는지 횟수를 세는 메서드
        int answer = 0;
        // 13 -> 4
        // 23 -> 7
        // 30 -> 10
        // 33 -> 14
        int total = 0;

        // 모든 숫자의 경우의 박수를 더하기 위해 반복문을 사용한다.
        for (int i = 1; i <= number; i++){
            int tmpCurrent = i;
            // 각 자리별로 3,6,9가 들어있는지 확인하는 while문
            while (tmpCurrent != 0) {
                // 만약 끝의 자리 숫자가 3, 6, 9이면 박수횟수 1번 더하기.
                if (tmpCurrent % 10 == 3 ||
                        tmpCurrent % 10 == 6 || tmpCurrent % 10 == 9)
                    total++;
            // 위의 자릿수또한 마찬가지로 확인한다.
            tmpCurrent /= 10;
            }

        }

        answer = total;
        return answer;
    }
}
