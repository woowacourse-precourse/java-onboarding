package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        answer=getDecodingCryptogram(cryptogram);
        return answer;
    }

    private static String getDecodingCryptogram(String cryptogram){
        boolean completeDecoding = false;
        StringBuffer decodedCrypto = new StringBuffer(cryptogram);
        if(!checkValidation(cryptogram)){
            return null;
        }
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
            System.out.println("there is not small");
            return false;
        }
        return true;
    }

    private static boolean checkDecodingEnded(StringBuffer crypto){
        for(int i = 0; i<crypto.length()-1; i++){
            if(crypto.charAt(i)==crypto.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

    private static void decodingCurrentString(StringBuffer cryptogram){
        StringBuffer afterDecode = cryptogram;
        int checkPoint = 0;
        while(checkPoint<afterDecode.length()-1){
            if(afterDecode.charAt(checkPoint)==afterDecode.charAt(checkPoint+1)){
                removeDuplication(afterDecode, checkPoint);
            }
            checkPoint++;
        }
    }

    private static void removeDuplication(StringBuffer string, int startPoint){
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
