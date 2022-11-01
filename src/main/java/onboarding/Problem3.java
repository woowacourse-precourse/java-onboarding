package onboarding;

//1. 3 6 9 가 있는지 파악 후 개수 만큼 결과 값 더해준다
public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        for (int i = 0; i <= number; i++) {
            int count = i;
            while (count > 0) {
                // 자리 값 마다 3 6 9 체크 후 count 더해줌
                if (count % 10 == 3 || count % 10 == 6 || count % 10 == 9) {
                    answer++;
                }
                count /= 10;

            }

        }
        return answer;
    }

}
