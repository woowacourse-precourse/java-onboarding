package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int answer10 = 0;
        int answer100 = 0;
        int answer = 0;
        int restTen = number % 10;

        int restHun = number % 100;

        int restTho = number % 1000;

        //1~10까지 각각 박수치는 횟수를 repeatNum에 담음

        final int[] repeatNum = {0, 0, 1, 0 , 0, 1, 0, 0, 1, 0};

        answer10 = (restHun / 10) * 3;

        if (restTen != 0) {
            for (int i = 0; i < restTen; i++) {
                answer10 += repeatNum[i];
            }
        }
        //10의 자리 해결
        if(restHun / 10 == 3){
            answer10 += restTen+1;
        }
        else if(restHun / 10 == 6){
            answer10 += restTen+11;
        }
        else if(restHun / 10 == 9){
            answer10 += restTen+21;
        }

//      100의 자리

        answer100 += answer10 + ((restTho-restHun) / 100) * 60;

        if((restTho-restHun) / 100 == 3){
            answer100 += answer10;
        }
        else if((restTho-restHun) / 100 == 6){
            answer100 += 60 + answer10;
        }
        else if((restTho-restHun) / 100 == 9){
            answer100 += 120 + answer10;
        }

        return answer;

    }

    public static void main(String[] args) {
        int number = 33;
        System.out.println(solution(number));
    }
}