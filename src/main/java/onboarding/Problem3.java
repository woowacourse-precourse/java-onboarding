package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int count = 0;
        int num = number;

        while (number != 0) {

            if (count != 0 && number / 10 == 0 && number % 3 == 0) {
                //number가 한자리 수가 이니고 가장 높은 자리수가 3의 배수일 때
                answer += (((number % 10) / 3) - 1) * Math.pow(10, count);
                answer += num - (number * Math.pow(10, count)) + 1;
            }else{
                answer += ((number % 10 / 3)) * Math.pow(10, count);
            }

            answer += (number % 10) * 3 * Math.pow(10, count - 1) * count;
            number/=10;
            count++;
        }

        return answer;
    }
}
