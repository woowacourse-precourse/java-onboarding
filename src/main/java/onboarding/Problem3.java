package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0; // count

        // 3, 6, 9 게임은 나머지가 3,6,9 여야 함
        // ex) 369라는 숫자를 10으로 계속 나누면 나머지가 9 6 3 이 나오므로 박수 세번임
        for (int i = 1; i <= number; i++) {
            int sumClap = checkClap(i);
            answer += sumClap;
        }

        return answer;
    }

    // 한 숫자에 몇번 박수를 쳐야하는 지 검증
    public static int checkClap(int num) {
        int count = 0;
        while (num != 0) {
            if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9)
                count++;
            num /= 10;
        }

        return count;
    }



}
