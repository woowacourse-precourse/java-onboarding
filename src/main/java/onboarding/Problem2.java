package onboarding;

public class Problem2 {

    public static void main(String[] args) {
        String testStr = "browoanoommnaon";

        solution(testStr);
    }
    public static String solution(String cryptogram) {
        String answer = "answer";
        String cryptoCleared = "";
        boolean flagDupli = true;
        int idxCrypto = 0;
        System.out.println("HEllo1");

        for(int i = idxCrypto; i < cryptogram.length()-1; i++) {

            if (cryptogram.charAt(i) == cryptogram.charAt(i + 1)) {
                flagDupli = true;
                System.out.println("HEllo2");

            }
        }




        return answer;
    }
}
