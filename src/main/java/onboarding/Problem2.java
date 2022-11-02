package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringBuilder decode = new StringBuilder(cryptogram);
        boolean chk = false;
        int start = 0;
        int i;
        for ( i = 1; i < decode.length(); i++) {
            if (decode.charAt(start) == decode.charAt(i)) {
                chk = true;
            } else{
                if(chk){
                    decode.replace(start, i , "");
                    start--;
                    i = start;
                    chk = false;
                } else{
                    start = i;
                }
            }
        }

        if (chk) {
            decode.replace(start, i , "");
        }
        System.out.println(decode.toString());
        return decode.toString();
    }
}
