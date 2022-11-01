package onboarding;

import java.util.Stack;
import java.util.regex.Pattern;

public class Problem2 {

    private static final String INPUT_STRING_EMPTY = "입력된 문자열이 공백입니다. ";
    private static final String INPUT_STRING_TOO_LONG = "입력 문자열이 1000자를 넘었습니다. ";
    private static final String INPUT_STRING_IS_NOT_LOWERCASE = "입력 문자열이 소문자로만 이루어져 있지 않습니다. ";
    private static final int INPUT_MINIMUM_LENGTH = 1;
    private static final int INPUT_MAXIMUM_LENGTH = 1000;
    private static Stack<String> deletedCryptogram = new Stack<>();
    private static String sameAlphabet = "";

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
        String[] alphabetSeperated = cryptogram.split("");
        for(String alphabet : alphabetSeperated){
            encryptCryptogram(alphabet);
        }
        return changeStackToString();
    }

    private static void encryptCryptogram(String alphabet){
        if(!deletedCryptogram.isEmpty() && deletedCryptogram.peek().equals(alphabet)) {
            deletedCryptogram.pop();
            sameAlphabet = alphabet;
        }
        if(sameAlphabet.equals(alphabet)){
            return;
        }
        deletedCryptogram.push(alphabet);
    }

    private static String changeStackToString(){
        StringBuilder result = new StringBuilder();
        while(!deletedCryptogram.isEmpty()){
            result.insert(0, deletedCryptogram.pop());
        }
        return result.toString();
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
