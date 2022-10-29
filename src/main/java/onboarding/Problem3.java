package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;      // 369횟수

        for(int i=1; i<=number; i++) {
            answer += get369(i);
        }
        System.out.println("369횟수: "+answer);

        return answer;
    }
    static int get369(int number){
        int digit;           // 각 자리의 값
        int count = 0;       // 자릿수
        while (number > 0) {
            digit = (number%10);

            // digit이 0인 경우도 3, 6, 9로 나눴을 때 나머지가 0이므로 0이 포함되지 않도록 제외!
            if(digit != 0 && (digit%3 == 0 || digit%6 == 0 || digit%9 == 0))
                count++;

            number = number / 10;

        }
        return count;
    }
}
