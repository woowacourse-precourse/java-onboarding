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

        int checkOverLapStatic = 0;
        int checkOverLapActive = 0;

        while (checkOverLapStatic == checkOverLapActive) {
            int num = 0;
            String resultRemoveOverlap = "";
            lengthCrypto = cryptogram.length();



            while (num < lengthCrypto - 1) {

                if (cryptogram.charAt(num) == cryptogram.charAt(num + 1)) {

                    resultRemoveOverlap = cryptogram.substring(0, num) + cryptogram.substring(num + 2, lengthCrypto);
                    cryptogram = resultRemoveOverlap;
                    checkOverLapActive +=1;

                    break;

                }
                num += 1;
            }

            if (checkOverLapStatic == checkOverLapActive) {
                break;
            }
            checkOverLapStatic += 1;

        }


        String answer = cryptogram;
        return answer;
    }
}
