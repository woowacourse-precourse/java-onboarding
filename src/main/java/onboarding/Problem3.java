package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;

        for(int i = 1; i <=number; i++){

            answer += clap(i);

        }

        return answer;

    }
    public static int clap(int number){

        int answer = 0;

        String [] num = (number+"").split("");


        for (String s : num) {

            if ((s.equals("3")) || (s.equals("6")) || (s.equals("9"))) {

                answer++;

            }
        }

        return answer;
    }

}
