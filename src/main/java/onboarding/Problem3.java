package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int answer10 = 0;

        int restTen = number % 10; // number를 10으로 나눈 나머지

        int restHun = number % 100;


        //1~10까지 각각 박수치는 횟수를 repeatNum에 담음

        final int[] repeatNum = {0, 0, 1, 0 , 0, 1, 0, 0, 1, 0};

        answer10 = (restHun / 10) * 3;

        if (restTen != 0) {
            for (int i = 0; i < restTen; i++) {
                answer10 += repeatNum[i];
            }
        }
        //두자리 숫자까지 369 손뼉횟수를 측정하는 기능
        if(restHun / 10 == 3){
            answer10 += restTen+1;
        }
        else if(restHun / 10 == 6){
            answer10 += restTen+11;
        }
        else if(restHun / 10 == 9){
            answer10 += restTen+21;
        }

        return answer10;
//        0010010010 -> 1~10까지

    }

    public static void main(String[] args) {
        int number = 33;
        System.out.println(solution(number));
    }
}
