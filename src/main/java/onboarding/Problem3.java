package onboarding;

public class Problem3 {
    public static void catchException(int num) {
        assert (num >= 1);
        assert (num <= 10000);
    }

    public static int calculate(int num) {
        int clap=0;
        for (int i = 1; i <= num; i++) {
            if ((i % 10) == 3 || (i % 10) == 6 || (i % 10) == 9) //1의자리
                clap++;
            if ((i / 10) == 3 || (i / 10) == 6 || (i / 10) == 9) //10의자리
                clap++;
            if ((i / 100) == 3 || (i / 100) == 6 || (i / 100) == 9) //100의자리
                clap++;
            if ((i / 1000) == 3 || (i / 1000) == 6 || (i / 1000) == 9) //1000의자리
                clap++;
        }
        return clap;
    }

    public static int solution(int number) {
        catchException(number);
        return calculate(number);
    }
}
