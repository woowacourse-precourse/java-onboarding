package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int [] clap = new int[5];
        int [] tsn = new int[5];

        clap[0] = 0;
        clap[1] = clap[0] * 3 + 1 * 3;
        clap[2] = clap[1] * 3 + 10 * 3;
        clap[3] = clap[2] * 3 + 100 * 3;

        tsn[0] = 1;
        tsn[1] = 10;
        tsn[2] = 100;
        tsn[3] = 1000;

        int total = 0;
        int idx = 0;
        while(number > 0)
        {
            int digit = number % 10;
//            System.out.println(digit);

            for(int i = 1; i <= digit; i++)
            {
                total += clap[idx];
                if(i == 3 || i == 6 || i == 9) total += tsn[idx];
            }


            idx++;
            number /= 10;
        }
        //33 1 3 3 // 3버ㅏㄴ
        System.out.println(total);
       return 0;

    }
}
