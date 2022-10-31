package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        char[] cryptogramArr = cryptogram.toCharArray();

        try{
            validation(cryptogramArr);
        }
        catch (IllegalArgumentException e) {
            e.getMessage();
        }

        String answer = deleteDuplicate(cryptogramArr);
        return answer;
    }

    public static void validation(char[] charArr) {

    }

    public static String deleteDuplicate(char[] charArr) {

        return charArr.toString();g
    }
}
