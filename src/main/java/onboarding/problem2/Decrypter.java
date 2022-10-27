package onboarding.problem2;

public class Decrypter {

    public static String decrypt(String cryptogram){
        String result = "";
        return result;
    }

    private static int findIndexOfRepeatedChar(String cryptogram){
        int startingIndex = -1;
        for(int i=0; i<cryptogram.length(); i++ ){
            char temp = cryptogram.charAt(i);
            if(temp == cryptogram.charAt(i+1)){
                startingIndex = i;
                return startingIndex;
            }
        }
        return startingIndex;
    }
}
