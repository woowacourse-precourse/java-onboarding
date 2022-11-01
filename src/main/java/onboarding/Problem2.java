package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        int i=0;
        while (i != cryptogram.length()-1) {
            if (cryptogram.length() == 0) break;

            for (i = 0; i < cryptogram.length()-1; i++) {
                char start = cryptogram.charAt(i);
                int last = i;
                while(start == cryptogram.charAt(last)){
                    last += 1;
                    if (last>=cryptogram.length()) break;
                }
                if (i+1==last) cryptogram = cryptogram.substring(0, i+1) + cryptogram.substring(last);
                else {
                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(last);
                    i = 0;
                }

                /**
                 *  abcsss 0,0 0
                 * a bcsss 0,1 1
                 * ab csss 0,2 2
                 * abc sss 0,3
                 */


//                if (target == cryptogram.charAt(i+1)){
//                    cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i+2);
//                    i = 0;
//                    break;
//                }
            }
        }

        if (cryptogram.length()==2 && cryptogram.charAt(0)==cryptogram.charAt(1)) {
            cryptogram = "";
        }

        return cryptogram;
    }

}


//    int i=0;
//        while (i != cryptogram.length()-1) {
//                if (cryptogram.length() == 0) break;
//                for (i = 0; i < cryptogram.length()-1; i++) {
//        char target = cryptogram.charAt(i);
//        if (target == cryptogram.charAt(i+1)){
//        cryptogram = cryptogram.substring(0, i) + cryptogram.substring(i+2);
//        i = 0;
//        break;
//        }
//        }
//        }