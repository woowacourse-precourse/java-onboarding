package onboarding;

public class Problem4 {
    static char[] alphabet1 = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
    static char[] alphabet2 = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};

    public static String solution(String word) {
        String answer = "";
        try{ check(word); }
        catch (IllegalArgumentException e){
            return e.toString();
        }
        return answer;
    }

    /**
     * 인자의 길이 범위 검사*/
    private static void check(String word){
        if(word.length() <1 || word.length() >1000)
            throw new IllegalArgumentException("인자의 길이가 맞지 않습니다.");
    }

}
