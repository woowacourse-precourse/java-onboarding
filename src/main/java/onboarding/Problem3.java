package onboarding;

public class Problem3 {
    public static int solution(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            String numberString = Integer.toString(i);
            for (int j = 0; j < numberString.length(); j++) {
                char check = numberString.charAt(j);
                if(isNumber_369(check)){
                    sum++;
                }
            }
        }
        int answer = sum;
        return answer;
    }

    public static boolean isNumber_369(char check) {
        boolean isExist;
        switch (check) {
            case '3':
            case '6':
            case '9':
                isExist = true;
                break;
            default:
                isExist = false;
        }
        return isExist;
    }
}