package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        int cursor=0;
        while(cursor<cryptogram.length()-1){


            if(cryptogram.charAt(cursor)==cryptogram.charAt(cursor+1)){
                String st=Character.toString(cryptogram.charAt(cursor));
                st+=st;

                cryptogram=cryptogram.replaceFirst(st,"");
                cursor-=1;

            }else{
                cursor+=1;
            }


        }


        return cryptogram;
    }
}
