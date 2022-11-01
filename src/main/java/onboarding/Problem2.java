package onboarding;

public class Problem2 {

    private StringBuffer cryptograph = new StringBuffer();
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }

    private void deleteFoundSection(){
        String decryptedCryptograph = cryptograph.toString().replace("X","");
        cryptograph = new StringBuffer(decryptedCryptograph);
    }
}
