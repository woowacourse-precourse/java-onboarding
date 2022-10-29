package onboarding.problem4;

public class Answer {
    private static final int LOWER_A = 97;
    private static final int LOWER_Z = 122;
    private static final int UPPER_A = 65;
    private static final int UPPER_Z = 90;

    private static boolean isLowerCase(char message) {
        return ((int)message >= LOWER_A) && ((int)message <= LOWER_Z);
    }

    private static boolean isUpperCase(char message) {
        return ((int)message >= UPPER_A) && ((int)message <= UPPER_Z);
    }
}
