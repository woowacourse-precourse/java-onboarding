package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = process(number);
        return answer;
    }

    //각 자릿수마다 3,6,9 의 존재를 체크해주는 함수

    static int number_count(int num) {
        int sum = 0;

        while (num>0) {
            if(num%10 == 3 || num%10 == 6 || num%10 ==9){
                sum++;
            }

            num = num/10;
        }
        return sum;
    }
    //실행을 위한 process 함수

    static int process(int num) {

        int clap = 0;

        for (int i=1;i<=num;i++){

            clap += number_count(i);

        }

        return clap;
    }
}
