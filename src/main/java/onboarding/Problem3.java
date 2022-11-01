package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;

        //1. 1부터 입력된 숫자까지 모든 박수수를 구해주는 함수
        answer = countClaps(number);

        return answer;
    }

    public static int countClaps(int number) {
        // 박수수를 저장할 변수
        int claps =0;
        //1부터 입력된 수까지 진행한다.
        for (int i = 1; i <= number; i++) {
            //현재 숫자를 문자열로 변환 후
            String currentNumber = Integer.toString(i);
            //문자열의 각 문자중 3,6,9가 들어가있다면 박수수를 증가시켜준다.
            for (int j = 0; j < currentNumber.length(); j++) {
                if(currentNumber.charAt(j)== '3'
                    || currentNumber.charAt(j)== '6'
                    || currentNumber.charAt(j)== '9' )  claps++;
            }
        }

        return claps;
    }
}
