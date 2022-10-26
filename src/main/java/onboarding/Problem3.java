package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        return answer;
    }


    // 입력받은 문자열에 "3" "6" '9"가 포함되어 있는지 확인하는 메소드
    private static boolean notContain_3_6_9(String num) {

        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            String str = Character.toString(c);

            if (str.equals("3") || str.equals("6") || str.equals("9")) {
                return true;
            }
        }
        return false;
    }

}
