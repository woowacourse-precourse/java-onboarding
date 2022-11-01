package onboarding;

public class Problem2 {
    private static StringBuilder sb=new StringBuilder();
    private static String decryption=new String();
    public static String solution(String cryptogram) {
        String answer = "answer";
        return completeDecrypt(cryptogram);
    }

    public static String completeDecrypt(String cryptogram){
        if(cryptogram.length()==1){
            return cryptogram;
        }
        decryption=(error(cryptogram)) ? "" : (Deduplicate(cryptogram).length() == 0) ? Deduplicate(cryptogram) : decrypt(cryptogram);

        return decryption;
    }

    public static String decrypt(String cryptogram){
        for(int i=0; i<cryptogram.length(); i++){
            cryptogram= Deduplicate(cryptogram);
            if(cryptogram== Deduplicate(cryptogram) || cryptogram.length()==0)
                break;
        }
        return Deduplicate(cryptogram);
    }

    public static String Deduplicate(String cryptogram){
        decryption="";
        sb=(cryptogram.charAt(0)!=cryptogram.charAt(1)) ? sb.append(cryptogram.charAt(0)) : sb.append("");

        for(int i=1; i<cryptogram.length()-1; i++){
            if(cryptogram.charAt(i)==cryptogram.charAt(i+1)||cryptogram.charAt(i-1)==cryptogram.charAt(i)) {
                continue;
            }
            sb.append(cryptogram.charAt(i));
        }

        sb=(cryptogram.charAt(cryptogram.length()-2)!=cryptogram.charAt(cryptogram.length()-1))? sb.append(cryptogram.charAt(cryptogram.length()-1)) : sb.append("");

        decryption=sb.toString();
        sb.setLength(0);
        return decryption;
    }
}
