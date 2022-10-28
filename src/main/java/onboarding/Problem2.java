package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String tmp = cryptogram;
        while(!tmp.equals(crypto(tmp))){
            tmp = crypto(tmp);
        }
        return tmp;
    }
    public static String crypto(String cryptogram){
        if(cryptogram.length() == 0) return "";
        if(cryptogram.length() == 1){
            return cryptogram;
        }else if(cryptogram.length() == 2){
            if(cryptogram.charAt(0) == cryptogram.charAt(1)){
                return "";
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < cryptogram.length(); i++){
            if(cryptogram.charAt(i) == cryptogram.charAt(i-1)){
                i++;
            }else{
                sb.append(cryptogram.charAt(i-1));
            }
        }
        if(cryptogram.charAt(cryptogram.length()-1) != cryptogram.charAt(cryptogram.length()-2)){
            sb.append(cryptogram.charAt(cryptogram.length()-1));
        }

        return sb.toString();
    }
}
