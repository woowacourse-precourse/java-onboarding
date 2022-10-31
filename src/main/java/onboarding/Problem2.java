package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        boolean flag = false;
        while(!flag && cryptogram.length() > 0){
            String tmp = cryptogram;
            char[] cryptochar = cryptogram.toCharArray();
            for(char c : cryptochar){
                String pattern = c + "{2,}";
                cryptogram = cryptogram.replaceAll(pattern, "");
            }
            flag = tmp.equals(cryptogram);
        }
        return cryptogram;
    }
}
