package onboarding;

public class Problem3 {
    public static int solution(int number) {
        
        int clap = 0;

        for (int i = 1; i <= number; i++) {

            int temp = i;

            while (temp > 0) {

                // 체크할 자릿수
                int check = temp % 10;
                // 만약 각 자릿수가 3,6,9 중 하나라면 박수 개수 하나 추가
                if (check == 3 || check == 6 || check == 9) {
                    clap += 1;
                }
                // 다음 자릿수 체크
                temp = temp /= 10;
            }
        }

        int answer = clap;
        return answer;
    }
}
