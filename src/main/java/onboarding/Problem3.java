package onboarding;

public class Problem3 {

    public static int solution(int number) {
        int answer;
        int numDvTen;
        int countClap = 0;

        for(int i = 1; i <= number; i++) {
            numDvTen = i;
            while(numDvTen != 0) {
                if(numDvTen % 10 == 3 || numDvTen % 10 == 6 || numDvTen % 10 == 9) {
                    countClap++;
                }
                numDvTen /= 10;
            }
        }
        answer = countClap;
        return answer;
    }
}
