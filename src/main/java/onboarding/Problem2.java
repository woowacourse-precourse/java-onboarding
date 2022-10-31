package onboarding;

import java.util.Stack;

public class Problem2 {

    private static Stack<String> deletedCryptogram = new Stack<>();


    public static String solution(String cryptogram) {
        return makeNewCryptogram(cryptogram);
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
        if(deletedCryptogram.isEmpty()) {
            deletedCryptogram.push(alphabet);
            return;
        }
        if(deletedCryptogram.peek().equals(alphabet)) {
            deletedCryptogram.pop();
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
