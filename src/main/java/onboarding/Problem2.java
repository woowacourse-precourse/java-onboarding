package onboarding;

import java.util.regex.Pattern;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String crypt = cryptogram;
        int i =0;
        char dupCrypt = 0;
        dupCrypt = crypt.charAt(i);
        /*while(true){

            if(Pattern.matches(dupCrypt+"{2,}",crypt)){
                crypt=crypt.replaceAll(dupCrypt+"{2,}","");
            }else{
                break;
            }
        }*/
        String pattern = "m{2,}";
        System.out.println(Pattern.matches(pattern,crypt));
        crypt=crypt.replaceAll("m"+"{2,}","");
        System.out.println(crypt);
        return answer;
    }
}
