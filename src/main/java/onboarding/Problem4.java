package onboarding;

public class Problem4 {

    public static Integer SumofAZ = 'A'+'Z';
    public static Integer Sumofaz = 'a'+'z';
    public static String solution(String word) {
        String answer = "";
        return answer;
    }

    public static boolean isUpper(char alphabet){
        if(alphabet >= 65 && alphabet <= 90)
            return true;

        return false;
    }

    public static boolean isLower(char alphabet){
        if(alphabet >= 97 && alphabet <= 122)
            return true;

        return false;
    }

    public static char translateUpper(char alphabet){
        return (char) (SumofAZ - alphabet);
    }

    public static char translateLower(char alphabet){
        return (char) (Sumofaz - alphabet);
    }
}
