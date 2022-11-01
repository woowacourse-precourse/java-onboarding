package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        StringBuilder removeDuplicates = new StringBuilder(cryptogram);
        int i = 0;

        while (true) {
            try {
                if (removeDuplicates.charAt(i) == removeDuplicates.charAt(i + 1)) {
                    removeDuplicates = removeDuplicates.delete(i, i + 2);
                    i = 0;
                }
                else {
                    i++;
                }
            } catch (Exception e) {
                break;
            }
        }
        return removeDuplicates.toString();
    }

    }




