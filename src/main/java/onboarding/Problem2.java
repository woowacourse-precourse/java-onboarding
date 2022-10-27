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
    }

}
