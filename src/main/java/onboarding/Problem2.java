package onboarding;


public class Problem2 {
    public static String solution(String cryptogram) {
        if (cryptogram.length()>1000 || cryptogram.length()<1){
            System.out.println("Please, enter string length between 1 ~ 1000 !");
            return cryptogram + "A"; //return error
        }

        int lengthCrypto = cryptogram.length();

        while (lengthCrypto > 0 ){

            int numASCII = cryptogram.charAt( lengthCrypto - 1 );

            if ( numASCII < 97 || numASCII > 122 ) {
                System.out.println("Please, enter small letter !");
                return cryptogram + "A"; //return error
            }

            lengthCrypto -= 1;

        }




        String answer = "answer";
        return answer;
    }
}
