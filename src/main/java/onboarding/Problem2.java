package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int i=0;

        while (true){
            if (i == cryptogram.length()-1) break;
            if (cryptogram.length()==0) break;
            if (cryptogram.charAt(i) == cryptogram.charAt(i+1)){
                int len = cryptogram.length();
                String str1 = cryptogram.substring(0,i);
                String str2 = cryptogram.substring(i+2,len);
                cryptogram = str1 + str2;
                i=0;
            }
            else{
                i+=1;
            }
        }
        return cryptogram;
    }
}
