package onboarding;

public class Problem3 {
    public static int solution(int number) {

        int result = 0;

        for(int t = 1; t <= number; t++){

            String str = String.valueOf(t);

            for (int i = 0; i < str.length(); i++){

                char check = str.charAt(i);

                if(check == '3' || check == '6' || check == '9'){

                    result = result + 1;

                }
            }
        }
        return result;
    }
}
