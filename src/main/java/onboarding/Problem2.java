package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer=getDecodingCryptogram(cryptogram);
        return answer;
    }

    private static String getDecodingCryptogram(String cryptogram){
        StringBuilder decodedCrypto = new StringBuilder(cryptogram);
        if(!checkValidation(cryptogram)){
            return null;
        }
        boolean completeDecoding = false;
        while(!completeDecoding){
            completeDecoding=checkDecodingEnded(decodedCrypto);
            decodingCurrentString(decodedCrypto);
        }
        return decodedCrypto.toString();
    }

    private static boolean checkValidation(String crypto){
        String regex = "^[a-z]*$";
        if(crypto.length()>1000 || crypto.length()<1){
            return false;
        }
        if(!crypto.matches(regex)){
            return false;
        }
        return true;
    }

    private static boolean checkDecodingEnded(StringBuilder crypto){
        for(int i = 0; i<crypto.length()-1; i++){
            if(crypto.charAt(i)==crypto.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

    private static void decodingCurrentString(StringBuilder cryptogram){
        int checkPoint = 0;
        while(checkPoint<cryptogram.length()-1){
            if(cryptogram.charAt(checkPoint)==cryptogram.charAt(checkPoint+1)){
                removeDuplication(cryptogram, checkPoint);
            }
            checkPoint++;
        }
    }

    private static void removeDuplication(StringBuilder string, int startPoint){
        int lastPoint=0;
        char target = string.charAt(startPoint);
        for(int i = startPoint; i<string.length(); i++){
            if(string.charAt(i)!=target){
                lastPoint = i;
                break;
            }
            if(i==string.length()-1){
                lastPoint=i+1;
            }
        }
        string.delete(startPoint,lastPoint);
    }


}
