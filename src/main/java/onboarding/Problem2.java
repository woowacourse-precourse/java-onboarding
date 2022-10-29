package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        int startIdx = -1;

        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i-1)) {
                startIdx = i-1;
                break;
            }
        }


        answer = findIdx(cryptogram, startIdx);


        return answer;
    }


    public static String findIdx(String cryptogram, int startIdx) {

        int lastIdx = startIdx;

        for (int i = startIdx; i < cryptogram.length(); i++) {

            if (cryptogram.charAt(i) == cryptogram.charAt(i-1)) {
                System.out.println(cryptogram.charAt(i));
                System.out.println(cryptogram.charAt(i-1));
                lastIdx += 1;

            }

            if ((cryptogram.charAt(i) != cryptogram.charAt(i-1)) && lastIdx != startIdx) {


                StringBuffer str = new StringBuffer(cryptogram);
                cryptogram = str.delete(startIdx,lastIdx+1).toString();

                System.out.println("cryptogram = " + cryptogram);

                break;

            }




        }

        return cryptogram;
    }


    public static void main (String[] args) {

        String cryptogram = "browoanoommnaon";

        solution(cryptogram);
    }
}
