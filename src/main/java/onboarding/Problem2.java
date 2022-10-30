package onboarding;

public class Problem2 {

    public static String decoding(String encoding_txt) {

        int pos1, pos2;
        int repeat = encoding_txt.length();
        StringBuilder decoding_txt = new StringBuilder(encoding_txt);


        for (pos1=0; pos1 < repeat-1; pos1++) {

            pos2 = pos1 + 1;

            while (pos1 >= 0 && pos2 < repeat && decoding_txt.charAt(pos1) == decoding_txt.charAt(pos2)) {
                pos1 -= 1;
                pos2 += 1;
            }


            if (pos1+1 != pos2) {
                decoding_txt.delete(pos1+1, pos2);
                repeat -= pos2-pos1-1;
                pos1   -=1;
            }

        }

        return decoding_txt.toString();
    }


    public static String solution(String cryptogram) {
        return decoding(cryptogram);
    }
}
