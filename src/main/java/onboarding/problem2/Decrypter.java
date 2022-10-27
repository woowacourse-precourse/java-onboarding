package onboarding.problem2;

public class Decrypter {

    public static String decrypt(String cryptogram){
        StringBuilder resultBuilder = new StringBuilder(cryptogram);
        while (isDecryptable(resultBuilder)){
            resultBuilder = removeRepeatedChar(resultBuilder);
        }
        return resultBuilder.toString();
    }

    private static boolean isDecryptable(StringBuilder cryptogram){
        if(findIndexOfRepeatedChar(cryptogram) == -1){
            return false;
        }
        return true;
    }

    private static StringBuilder removeRepeatedChar(StringBuilder cryptogram){
        int startingIndex = findIndexOfRepeatedChar(cryptogram);
        int repeatedNum = findNumberOfRepeatedChar(cryptogram, startingIndex);
        return removeCharacters(cryptogram, startingIndex, repeatedNum);
    }

    private static int findIndexOfRepeatedChar(StringBuilder cryptogram){
        int startingIndex = -1;
        int index = 0;
        for(int i=0; i<cryptogram.length()-1; i++ ){
            char temp = cryptogram.charAt(i);
            if(temp == cryptogram.charAt(i+1)){
                startingIndex = i;
                return startingIndex;
            }
        }
        return startingIndex;
    }

    private static int findNumberOfRepeatedChar(StringBuilder cryptogram, int startingIndex){
        int num = 1;
        final char repeatedChar = cryptogram.charAt(startingIndex);
        int index = startingIndex + 1;
        while(repeatedChar == cryptogram.charAt(index) ){
            num += 1;
            index += 1;
            if(index == cryptogram.length()) {
                break;
            }
        }
        return num;
    }

    private static StringBuilder removeCharacters(StringBuilder cryptogram, int startingIndex, int charNum){
        cryptogram.delete(startingIndex, startingIndex+charNum);
        return cryptogram;
    }
}
