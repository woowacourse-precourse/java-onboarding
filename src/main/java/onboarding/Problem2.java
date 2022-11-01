package onboarding;

public class Problem2 {
    static String Cryptograms(String cryptogram)
    {
        if (cryptogram.length() <=1)
        {
            return cryptogram;
        }
        int i=0;
        while(i < cryptogram.length()-1){
            if (cryptogram.charAt(i)==cryptogram.charAt(i+1))
            {
                cryptogram=cryptogram.substring(0,i)+
                        cryptogram.substring(i+2);
                i=0;
            }
            if(cryptogram.length()==2){
                if(cryptogram.charAt(i)==cryptogram.charAt(i+1)){
                    cryptogram="";
                }
            }
            i++;
        }
        return cryptogram;
    }

    public static String solution(String cryptogram) {
        String answer = Cryptograms(cryptogram);
        return answer;
    }
}
