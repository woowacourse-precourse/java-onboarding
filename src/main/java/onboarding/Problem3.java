package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        // 첫 숫자부터 확인하며 3, 6, 9가 포함되어 있는지 확인
        for (int i=3; i<=number; i++)
            if (Integer.toString(i).contains("3") || Integer.toString(i).contains("6") || Integer.toString(i).contains("9")) {
                answer += count_three(i);
        }

        return answer;
    }

    /**
     *
     * @param num 3,6,9가 포함된 숫자
     * @return 각 자리에 있는 총 3,6,9의 개수
     */
    public static int count_three(int num){
        int result = 0;

        while (num > 0){
            if (num % 10 == 3 || num % 10 == 6 || num % 10 == 9)
                result+=1;
            num /= 10;
        }
        return result;
    }
}
