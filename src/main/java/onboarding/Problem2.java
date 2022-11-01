package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        if(checkException(cryptogram)) {
            throw new IllegalArgumentException();
        }
        return getDecoding(cryptogram);
    }
    /**
     *
     * regex(정규 표현식, Regular expressions): 문자열에 어떤 패턴의 문자들이 있는지 찾는데 도움을 줌.
     * replaceAll(String regex, String replacement): 문자열내에 있는 정규식 regex 와 매치되는 모든 문자열을 replacement 문자열로 바꾼 문자열을 반환합니다.
     *
     */
    public static String getDecoding(String cryptogram) {

        String regex= "{2,}";
        for(char c: cryptogram.toCharArray()) {
            cryptogram = cryptogram.replaceAll(c+regex,"");
        }
        return cryptogram;
    }
    public static boolean checkException(String cryptogram) {
        if(checkLength(cryptogram.length())) {
            return true;
        }
        return false;
    }
    // cryptogram -  길이가 1이상 1000이하인 문자열
    public static boolean checkLength(int length) {
        return length < 1 || length > 1000;
    }
}
