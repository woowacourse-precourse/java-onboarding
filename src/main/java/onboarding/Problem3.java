package onboarding;

public class Problem3 {

    public static void main(String[] args) {
        System.out.println(solution(13));
    }
    public static int solution(int number) {
        int answer = 0;

        for (int i = 3; i <= number; i++) {
            String next = String.valueOf(i);
            String[] num = next.split("");

            for (String str : num) {
                int tmp = Integer.parseInt(str);
                if(tmp == 0)
                    continue;
                if (tmp % 3 == 0) {
                    answer++;
                }
            }
        }

        return answer;
    }
}
