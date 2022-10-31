package onboarding.problem2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Decrypter {

    public static String decrypt(String cryptogram){
        StringBuilder resultBuilder = new StringBuilder(cryptogram);
        while (isDecryptable(resultBuilder)){
            removeRepeatedChar(resultBuilder);
        }
        return resultBuilder.toString();
    }

    private static boolean isDecryptable(StringBuilder cryptogram){
        if(findIndexOfRepeatedChar(cryptogram, 0) == -1){
            return false;
        }
        return true;
    }

    private static void removeRepeatedChar(StringBuilder cryptogram){
        List<List<Integer>> repeatedCharInfos = findIndexesOfRepeatedChar(cryptogram);
        Collections.reverse(repeatedCharInfos);
        for(List<Integer> repeatedCharInfo : repeatedCharInfos){
            removeCharacters(cryptogram, repeatedCharInfo.get(0), repeatedCharInfo.get(1));
        }
    }

    private static int findIndexOfRepeatedChar(StringBuilder cryptogram, int startIndex){
        int repeatedIndex = -1;
        for(int i=startIndex; i<cryptogram.length()-1; i++ ){
            char temp = cryptogram.charAt(i);
            if(temp == cryptogram.charAt(i+1)){
                repeatedIndex = i;
                return repeatedIndex;
            }
        }
        return repeatedIndex;
    }

    private static List<List<Integer>> findIndexesOfRepeatedChar(StringBuilder cryptogram){
        List<List<Integer>> repeatCharInfos = new ArrayList<>();
        int index = 0;
        while( index < cryptogram.length()-1){
            int startIndex = findIndexOfRepeatedChar(cryptogram, index);
            if(startIndex == -1){
                return repeatCharInfos;
            }
            int repeatNum = findNumberOfRepeatedChar(cryptogram, startIndex);
            List<Integer> repeatCharInfo = List.of(startIndex, repeatNum);
            repeatCharInfos.add(repeatCharInfo);
            index = startIndex+repeatNum;
        }
        return repeatCharInfos;
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

    private static void removeCharacters(StringBuilder cryptogram, int startingIndex, int charNum){
        cryptogram.delete(startingIndex, startingIndex+charNum);
    }
}
