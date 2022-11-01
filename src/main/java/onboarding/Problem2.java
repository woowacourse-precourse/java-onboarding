package onboarding;

/** 만들어야 할 기능
 * 문자 중복시 제거 메서드
 * 중복문자 검증 메서드
 */
public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuffer crypto = new StringBuffer(cryptogram);
        while(!validation(crypto.toString())) {
            
            for (int i = 0; i < crypto.length(); i++) {
                char c = crypto.charAt(i);
                int strIdx = i;

                for (int j = i + 1; j < crypto.length(); j++) {
                    if (crypto.charAt(j) != c)
                        break;
                    else
                        strIdx = j;
                }
                if (strIdx != i)
                    crypto.delete(i, strIdx+1);
            }
        }

        return crypto.toString();
    }

    public static boolean validation(String cryptogram) {
        for(int i = 0; i < cryptogram.length(); i++ ) {
            for(int j = i + 1; j < cryptogram.length(); j++) {
                if(cryptogram.charAt(j) == cryptogram.charAt(i))
                    return false;
                else
                    break;
            }
        }

        return true;
    }
}
