package onboarding;

public class Problem2 {

    public static String decoding(String encodingTxt) {

        int pos1, pos2;
        int repeat = encodingTxt.length();
        StringBuilder decodingTxt = new StringBuilder(encodingTxt);


        for (pos1=0; pos1 < repeat-1; pos1++) {

            pos2 = pos1 + 1;

            while (pos1 >= 0 && pos2 < repeat && decodingTxt.charAt(pos1) == decodingTxt.charAt(pos2)) {
                pos1 -= 1;
                pos2 += 1;
            }


            if (pos1+1 != pos2) {
                decodingTxt.delete(pos1+1, pos2);
                repeat -= pos2-pos1-1;
                pos1   -=1;
            }

        }

        return decodingTxt.toString();
    }


    public static String solution(String cryptogram) {
        return decoding(cryptogram);
    }
}
