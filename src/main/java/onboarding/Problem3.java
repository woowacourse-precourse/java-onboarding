package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }




    // 입력받은 문자열에 "3" "6" '9"가 포함되어 있는지 확인하는 메소드
    private static boolean notContain_3_6_9(char c) {

        String num = Character.toString(c);
        return num.equals("3") || num.equals("6") || num.equals("9");
    }
}
