package onboarding;

public class Problem3 {
    public static int solution(int number) {
        // 박수칠 숫자를 저장하는 변수
        int clap = 0;

        // 1부터 number까지 반복문
        for (int num = 1 ; num <= number;num++ ){
            // forEach문을 사용하기 위해 num의 타입을 String으로 바꾸어준다.
            String numToString = Integer.toString(num);
            // forEach문을 사용해 각 숫자별로 판단
            for (String clapCheck : numToString.split("")){
                // 3,6,9가 있으면 clap의 수를 1 증가시킨다.
                if (clapCheck.equals("3") || clapCheck.equals("6") || clapCheck.equals("9") ){
                    clap++;
                }
            }
        }

        return clap;
    }
}
