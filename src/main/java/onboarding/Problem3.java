/*
기능 목록
i) checkClapNum -> 입력받은 number에 대하여 박수를 몇번 쳐야 되는지 그 값을 return 함
ii) getClaps -> 입력받은 number에 대하여 총 몇번의 박수를 쳐야 되는지 return 함.
iii) solution -> i), ii) 두가지 기능을 적절히 이용하여 정답을 구한다.
 */


package onboarding;

public class Problem3 {


    int checkClapNum(int number){

        String temp_string = Integer.toString(number);
        int clap = 0;

        for (int i=0; i<temp_string.length(); i++){
            if (temp_string.substring(i,i+1).contains("3")) clap += 1;
            if (temp_string.substring(i,i+1).contains("6")) clap += 1;
            if (temp_string.substring(i,i+1).contains("9")) clap += 1;
        }
        return clap;
    }


    int getClaps(int number){

        int claps = 0;

        for (int i=1; i <= number; i++){
            claps += checkClapNum(i);
        }

        return claps;
    }


    public static int solution(int number) {

        Problem3 agent = new Problem3();

        int answer = agent.getClaps(number);
        return answer;
    }
}
