package onboarding;

public class Problem3 {

    /**
     * 1부터 number 까지 손뼉을 몇 번 쳐야 하는지 횟수를 return 하는 메서드
     * @param number
     * @return 손뼉 친 횟수
     */
    public static int solution(int number) {
        int answer = 0;
        for (int i = 1; i < number+1; i++) {
            answer += countClap(i);
        }
        return answer;
    }

    /**
     * 주어진 숫자 하나에 대해 손뼉을 치는 횟수
     * @param number
     * @return 숫자 하나에 대하여 손뼉을 친 횟수
     */
    public static int countClap(int number) {
        int count = 0;
        while(number > 0) {
            if (number % 10 == 3 || number % 10 == 6 || number % 10 == 9) {
                count++;
            }
            number /= 10;
        }
        return count;
    }
}
