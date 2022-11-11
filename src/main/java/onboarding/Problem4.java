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

        for (char ch : word.toCharArray()) {
            int flag = 0;
            if(isAlphabet(ch)){ // 알파벳인 경우
                if(isUpperCase(ch)) flag = 1; // 대문자 알파벳
                else flag = 0; // 소문자 알파벳
                ch = reverseWord(ch, flag);
            }
            answer += ch;
        }
        return answer;
    }

    /**
     * 인자의 길이 범위 검사*/
    private static void check(String word){
        if(word.length() <1 || word.length() >1000)
            throw new IllegalArgumentException("인자의 길이가 맞지 않습니다.");
    }

    /**
     * 알파벳인지 판별하는 함수 */
    private static boolean isAlphabet(char ch){
        if(ch >= 'a' && ch <= 'z') return true;
        if(ch >= 'A' && ch <= 'Z') return true;
        return false;
    }

    /**
     * 대문자인지 판별하는 함수 */
    private static boolean isUpperCase(char ch){
        if(ch >= 'A' && ch <='Z'){
            return true;
        }return false;
    }

    /**
     * 알파벳 변환 */
    private static char reverseWord(char ch, int flag){
        if(flag==1)
            return alphabet1['Z'-ch];
        else if(flag==0)
            return alphabet2['z'-ch];
        return '1';
    }

}
