package onboarding;

public class Problem3 {

    /**
     *
     * @param num - int -> String
     * @return 손뼉을 쳐야 하는 횟수
     */
    public static int calculate369(String num) {
        int ans = 0;

        for (int i = 0; i < num.length(); i++) {
            int current = num.charAt(i) - '0';
            // 3, 6, 9 중 하나일 경우 ans++
            if (current != 0 && current % 3 == 0) ans++;
        }

        return ans;
    }
    public static int solution(int number) {
        int answer = 0;
        // 1부터 number까지 계산
        for (int i = 1; i <= number; i++) answer += calculate369(String.valueOf(i));

        return answer;
    }
}
