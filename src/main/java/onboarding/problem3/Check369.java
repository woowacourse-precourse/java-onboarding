package onboarding.problem3;

public class Check369 {

    public int check369(String number) {
        int result = 0;
        for (int i = 1; i < number.length(); i++) {

            if (contains369(number)) {
                result += count369(number);
            }
        }

        return result;
    }

    private boolean contains369(String number) {
        return number.contains("3") || number.contains("6") || number.contains("9");
    }

    private int count369(String number) {
        int count = 0;
        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';

            if (num == 3 || num == 6 || num == 9) {
                count++;
            }
        }

        return count;
    }

}
