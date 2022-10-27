package onboarding;

/*
문제 설명
- 369 게임 진행 중, 1부터 number까지 손뼉을 몇 번 쳐야 하는지의 횟수를 반환해야 한다.
*/

/*
기능 목록
- 369 게임 중, 박수의 횟수 계산하기
*/

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 1부터 number까지 순회하며 3,6,9의 개수를 세어준다.
        for (int i = 1; i < number + 1; i++) {

            int num = i;

            // 순회하는 숫자의 각 자리 수에 3,6,9가 있다면 각각 세어준다.
            while (num > 0) {
                int digit = num % 10;

                if (digit != 0 && digit % 3 == 0) {
                    answer += 1;
                }

                num /= 10;
            }
        }

        return answer;
    }
}
