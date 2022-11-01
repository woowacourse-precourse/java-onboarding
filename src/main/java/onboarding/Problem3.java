package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int answer = 0;

        for (int count = 1; count <= number; count++) {

            String str = String.valueOf(count);

            for (int i = 0; i < str.length(); i++) {

                char numch = str.charAt(i);

                if (numch == '3' || numch == '6' || numch == '9') {

                    answer = answer + 1;
                }
            }

        }
        return answer;
    }
}




