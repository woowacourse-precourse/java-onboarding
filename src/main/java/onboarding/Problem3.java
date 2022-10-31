package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        int clap [] = new int[number+1];

        int quotient;
        int remainder;

        for (int i=1; i<number+1; i++){
            if (i<10){
                if (i%3 == 0){
                    clap[i]++;
                }

            } else if (i<100) {
                quotient = i/10;
                remainder = i%10;

                if (quotient%3==0) {
                    clap[i]++;
                }
                clap[i]+=clap[remainder];

            } else if (i<1000) {
                quotient = i/100;
                remainder = i%100;

                if (quotient%3==0) {
                    clap[i]++;
                }
                clap[i]+=clap[remainder];

            } else if (i<10000) {
                quotient = i/1000;
                remainder = i%1000;

                if (quotient%3==0) {
                    clap[i]++;
                }
                clap[i]+=clap[remainder];
            }

            answer+=clap[i];
        }

        return answer;
    }
}
