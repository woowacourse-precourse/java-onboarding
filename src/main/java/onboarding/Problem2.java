package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "";
        String deciphered = decipher(cryptogram);

        while(true){
             String curDeciphered = decipher(deciphered);

             if(deciphered.equals( curDeciphered )){
                 answer = deciphered;
                 break;
             }else{
                 deciphered = curDeciphered;
             }
        }

        return answer;
    }

    private static String decipher(String cryptogram){
        StringBuilder sb = new StringBuilder();

        char[] cryptoChars = cryptogram.toCharArray();

        for(int i=1; i<cryptogram.length(); i++){
            if(cryptoChars[i] == cryptoChars[i-1]){
                cryptoChars[i-1] = '0';
                cryptoChars[i] = '0';
            }
        }

        for(char c :cryptoChars){
            if(c != '0'){
                sb.append(c);
            }
        }

        return sb.toString();
    }
}
