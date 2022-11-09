package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        for(int gameNumber = 1; gameNumber <= number; gameNumber++) {
            int tmpGameNumber = gameNumber;
            while(tmpGameNumber != 0){
                if(tmpGameNumber % 10 == 3 || tmpGameNumber % 10 == 6 || tmpGameNumber % 10 == 9) answer++;
                tmpGameNumber /= 10;
            }
        }
        return answer;
    }
}
