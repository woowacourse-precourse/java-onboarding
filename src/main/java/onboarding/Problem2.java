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
        while(!completeDecoding){
            completeDecoding=decodingCurrentString(decodedCrypto);
        }
        return decodedCrypto.toString();
    }

    private static boolean decodingCurrentString(StringBuffer cryptogram){
        StringBuffer afterDecode = cryptogram;
        boolean result = true;
        int checkPoint = 0;
        while(checkPoint<afterDecode.length()-1){
            if(afterDecode.charAt(checkPoint)==afterDecode.charAt(checkPoint+1)){
                removeDuplication(afterDecode, checkPoint);
                result=false;
            }
            checkPoint++;
        }
        return result;
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
