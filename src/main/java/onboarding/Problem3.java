package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int total = 0;
        /*
        1. 1부터 number까지 반복
        2. 각 차례의 박수 횟수를 구함
        3. 누적
        */
        for ( int i = 1 ; i <= number; i ++ ){
            int clap = 0;
            int current = i;
            while ( current != 0 ){
                int num = current % 10;
                if ( num == 3 || num == 6 || num == 9 ) clap ++;
                current /= 10;
            }
            total += clap;
        }
        return total;
    }
}
