package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int temp;
        // number가 10^4 이하의 자연수이므로 1부터 number까지 반복하여 각 수에 들어있는 3, 6, 9의 개수를 구함
        for (int i = 1; i <= number; i++){
            temp = i;
            // 현재 탐색하는 숫자의 각 자릿수가 3 또는 6 또는 9인지 확인
            while (temp > 0){
                // temp % 10 % 3 == 0일 때 해당 자릿수가 0,3,6,9일 수 있으며 그 중 0인 경우는 count하지 않으므로 제외
                if (temp % 10 % 3 == 0 && temp % 10 != 0)
                    answer++;
                temp /= 10;
            }
        }
        return answer;
    }
}
