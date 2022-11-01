package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        cryptogram = delDup(cryptogram);
        return cryptogram;
    }

    public static String delDup(String cryptogram){
        char seq = cryptogram.charAt(0);
        int i=1;
        boolean flag = false;
        while(i<cryptogram.length()){
            char target = cryptogram.charAt(i);
            if (seq==target){
                cryptogram =  cryptogram.replace(seq+""+seq, "");
                flag = true;
                if (cryptogram.isBlank()){
                    break;
                }
                seq = cryptogram.charAt(i-1);
            }
            else {
                seq = cryptogram.charAt(i);
                i++;
            }
            if (i==cryptogram.length()-1){
                i = 1;
                if (!flag){
                    break;
                }
            }
        }
        return cryptogram;
    }
}
