package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        int digit=0;   // 자릿수

        while (number > 0) {
            //answer += (number%10);
            if(number%10 == 3){
                answer *= Math.pow(10, digit);
            }
            answer += (number/3);

            number = number / 10;

            digit++;
        }
        System.out.println("369횟수: "+answer);

        return answer;
    }
}
