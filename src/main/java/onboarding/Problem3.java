package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // number가 1보다 작거나 10000보다 클 때 예외 처리
        if (number < 1 || number > 10000)
            return answer;

        // number 값까지 모든 숫자들을 k로 지정하고 k값을 10000부터 10까지 계속 나누면
        // 이떄의 몫이 만의 자리, 천의 자리, 백의 자리, 십의 자리가 되므로
        // 몫에 3, 6, 9 가 있으면 카운트한다.
        // 그리고 마지막의로 일의 자리에 3, 6, 9가 있으면 카운트한다.
        for (int i = 0; i < number; i++) {
            int temp = 0;
            int j = 4;
            int k = i + 1;
            while (k > 10) {
                temp = (int) (k / Math.pow(10,j));
                k %= Math.pow(10,j--);
                if (temp == 3 || temp == 6 || temp == 9)
                    answer++;
            }
            if (k == 3 || k == 6 || k == 9)
                answer++;
        }

        return answer;
    }
}
