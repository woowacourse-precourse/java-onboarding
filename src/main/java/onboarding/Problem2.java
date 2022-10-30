package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = PWDecoder(cryptogram);
        return answer;
    }
    public static String PWDecoder(String cryptogram){
        StringBuffer decoded = new StringBuffer(cryptogram);

        for(int j = 0 ; j < decoded.length() ;j++){
            for(int i = 0 ; i < decoded.length()-1 ; i++){
                if(decoded.charAt(i) == decoded.charAt(i+1)) {
                    decoded.replace(i, i + 2, "");
                    i = 0;
                }
            }
        }
        return decoded.toString();
    }
}
