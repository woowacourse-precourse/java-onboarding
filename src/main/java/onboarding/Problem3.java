package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int answer = 0;
        String str = "";

        for (int i = 1; i <= number; i++) {
            str = Integer.toString(i);
            for (int j = 0; j < str.length(); j++) {
                // 해당 자리가 369 인 경우
                if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                    answer += 1;
                }
//                if (is369(str.charAt(j)))
//                    answer += 1;

            }
        }

        return answer;
    }

    static boolean is369 (char c) {
        if(c == '3' || c == '6' || c== '9') {
            return true;
        }
        return false;
    }

}
