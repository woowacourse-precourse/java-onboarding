package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        final char[] chars = cryptogram.toCharArray();
        final StringBuilder newCryptogram = new StringBuilder();

        char duplicateChar = ' ';
        boolean hasNotDuplicate = false;




        System.out.println(newCryptogram);
        return newCryptogram.toString();
    }

    public static void main(String[] args) {
        Problem2.solution("browoanoommnaon");
    }
}
