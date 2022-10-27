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

    private static int findNumberOfRepeatedChar(String cryptogram, int startingIndex){
        int num = 1;
        final char repeatedChar = cryptogram.charAt(startingIndex);
        int index = startingIndex + 1;
        while(repeatedChar == cryptogram.charAt(index) ){
            num += 1;
            index += 1;
        }
        return num;
    }
}
