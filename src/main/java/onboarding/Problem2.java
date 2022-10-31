package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        try{
            validation(cryptogram);
        }
        catch (IllegalArgumentException e) {
            e.getMessage();
        }

        char[] cryptogramArr = cryptogram.toCharArray();
        String answer = deleteDuplicate(cryptogramArr);
        return answer;
    }

    public static void validation(String str) {

    }

    public static String deleteDuplicate(char[] charArr) {

    }
}
