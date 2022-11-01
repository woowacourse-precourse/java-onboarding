package onboarding;

public class Problem3 {
    public static int solution(int number) {
        // 박수칠 숫자를 저장하는 변수
        int clap = 0;

        // 1부터 number까지 반복문
        for (int num = 1; num <= number; num++) {
            clap += countClap(Integer.toString(num));
        }

        return clap;
    }

    // String을 주면 몇 번의 박수를 쳐야 하는지 알려주는 함수
    public static int countClap(String clapString) {
        int clap = 0;

        // forEach문을 사용해 각 숫자별로 판단
        for (String check : clapString.split("")) {

            // 3,6,9가 있으면 clap의 수를 1 증가시킨다.
            if (checkClap(check) == true) {
                clap++;
            }
        }

        return clap;
    }

    // 3,6,9 이면 true를 반환하는 함수
    public static boolean checkClap(String check) {
        if (check.equals("3") || check.equals("6") || check.equals("9")) {
            return true;
        } else {
            return false;
        }
    }
}
