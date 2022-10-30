package onboarding.problem3;

public class Count {
    public static int count369(int number) {
        String stringNumber = Integer.toString(number);
        int result = 0;
        for (int i = 0; i < stringNumber.length(); i++) {
            char charNum = stringNumber.charAt(i);
            if ((charNum - '0') % 3 == 0 && charNum != '0') {
                result += 1;
            }
        }
        return result;
    }
    public static int count369All(int number) {
        int result = 0;
        for (int i = 1; i < number + 1; i++) {
            result += count369(i);
        }
        return result;
    }
}
