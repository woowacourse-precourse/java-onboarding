package onboarding;

import java.util.Stack;

public class Problem2 {


    public static String solution(String cryptogram) {
        return makeNewCryptogram(cryptogram);
    }

    private static String makeNewCryptogram(String cryptogram){
        if(isEmpty(cryptogram) || cannotDeleteMore(cryptogram)) return cryptogram;
        return makeNewCryptogram(encodeCryptogram(cryptogram));
    }

    private static String encodeCryptogram(String cryptogram){
        Stack<String> deletedCryptogram = new Stack<>();
        String[] alphabetSeperated = cryptogram.split("");
        for(String alphabet : alphabetSeperated){
            encryptCryptogram(deletedCryptogram, alphabet);
        }
        return changeStackToString(deletedCryptogram);
    }

    private static void encryptCryptogram(Stack<String> deletedCryptogram, String alphabet){
        if(deletedCryptogram.isEmpty()){
            deletedCryptogram.push(alphabet);
            return;
        }
        if(deletedCryptogram.peek().equals(alphabet)) {
            deletedCryptogram.pop();
            return;
        }
        deletedCryptogram.push(alphabet);
    }

    private static String changeStackToString(Stack<String> stack){
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()){
            result.insert(0, stack.pop());
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
