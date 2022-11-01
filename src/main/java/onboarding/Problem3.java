package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        int clap;
        int ths, hnd, ten, one;

        for (int count = 1; count <= number; count++) {
            clap = 0;
            ths = count / 1000;
            hnd = (count % 1000) / 100;
            ten = (count % 100) / 10;
            one = count % 10;
            if (ths == 3 || ths == 6 || ths == 9)
                clap++;
            if (hnd == 3 || hnd == 6 || hnd == 9)
                clap++;
            if (ten == 3 || ten == 6 || ten == 9)
                clap++;
            if (one == 3 || one == 6 || one == 9)
                clap++;
            answer += clap;
        }
        return answer;
    }
}
