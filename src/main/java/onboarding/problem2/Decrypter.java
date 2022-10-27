package onboarding.problem2;

public class Decrypter {

    public static String decrypt(String cryptogram){
        String result = cryptogram;
        while (isDecryptable(cryptogram)){
            result = removeRepeatedChar(cryptogram);
        }
        return result;
    }

    private static boolean isDecryptable(String cryptogram){
        if(findIndexOfRepeatedChar(cryptogram) == -1){
            return false;
        }
        return true;
    }

    private static String removeRepeatedChar(String cryptogram){
        int startingIndex = findIndexOfRepeatedChar(cryptogram);
        int repeatedNum = findNumberOfRepeatedChar(cryptogram, startingIndex);
        return removeCharacters(cryptogram, startingIndex, repeatedNum);
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

    private static String removeCharacters(String cryptogram, int startingIndex, int charNum){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(
                cryptogram.substring(0, startingIndex)
        );
        stringBuilder.append(
                cryptogram.substring(startingIndex+charNum)
        );
        return stringBuilder.toString();
    }
}
