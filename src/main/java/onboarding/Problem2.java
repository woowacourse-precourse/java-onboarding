package onboarding;

import java.util.Stack;
import java.util.regex.Pattern;

public class Problem2 {

    private static final String INPUT_STRING_EMPTY = "입력된 문자열이 공백입니다. ";
    private static final String INPUT_STRING_TOO_LONG = "입력 문자열이 1000자를 넘었습니다. ";
    private static final String INPUT_STRING_IS_NOT_LOWERCASE = "입력 문자열이 소문자로만 이루어져 있지 않습니다. ";
    private static final int INPUT_MINIMUM_LENGTH = 1;
    private static final int INPUT_MAXIMUM_LENGTH = 1000;

    public static String solution(String cryptogram) {
        checkExceptionOfCryptogram(cryptogram);
        return makeNewCryptogram(cryptogram);
    }

    private static void checkExceptionOfCryptogram(String cryptogram){
        if(cryptogram.length() < INPUT_MINIMUM_LENGTH) cryptogramEmptyException();
        if(cryptogram.length() > INPUT_MAXIMUM_LENGTH) cryptogramTooLongException();
        if(!Pattern.matches("^[a-z]*$", cryptogram)) cryptogramNotLowerCaseException();
    }

    private static void cryptogramEmptyException(){
        throw new IllegalArgumentException(INPUT_STRING_EMPTY);
    }

    private static void cryptogramTooLongException(){
        throw new IllegalArgumentException(INPUT_STRING_TOO_LONG);
    }

    private static void cryptogramNotLowerCaseException(){
        throw new IllegalArgumentException(INPUT_STRING_IS_NOT_LOWERCASE);
    }

    private static String makeNewCryptogram(String cryptogram){
        if(isEmpty(cryptogram) || cannotDeleteMore(cryptogram)) return cryptogram;
        return makeNewCryptogram(encodeCryptogram(cryptogram));
    }

    private static String encodeCryptogram(String cryptogram){
        StringBuilder deletedCryptogram = new StringBuilder();
        for(int index = 0; index<cryptogram.length(); index++){
            deletedCryptogram.append(encryptCryptogram(cryptogram, index));
        }
        return deletedCryptogram.toString();
    }

    private static String encryptCryptogram(String cryptogram, int index){
        if(index == 0) return putFirstAlphabets(cryptogram);
        if(index == cryptogram.length() - 1) return putLastAlphabets(cryptogram);
        if(cryptogram.charAt(index) != cryptogram.charAt(index-1) && cryptogram.charAt(index) != cryptogram.charAt(index+1))
            return Character.toString(cryptogram.charAt(index));
        return "";
    }

    private static String putFirstAlphabets(String cryptogram){
        if(cryptogram.charAt(0) != cryptogram.charAt(1)) return Character.toString(cryptogram.charAt(0));
        return "";
    }

    private static String putLastAlphabets(String cryptogram){
        int cryptoLength = cryptogram.length();
        if(cryptogram.charAt(cryptoLength - 2) != cryptogram.charAt(cryptoLength-1))
            return Character.toString(cryptogram.charAt(cryptoLength-1));
        return "";
    }

    private static boolean isEmpty(String cryptogram){
        if(cryptogram.length() == 0) return true;
        return false;
    }

    private static boolean cannotDeleteMore(String cryptogram){
        for(int i=0; i<cryptogram.length()-1; i++){
            if(cryptogram.charAt(i) == cryptogram.charAt(i+1)) return false;
        }
        return true;
    }
}
