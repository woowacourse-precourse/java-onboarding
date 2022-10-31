package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "answer";

        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i-1)) {
                
                int lastIdx = findLastIdx(cryptogram, i-1);
                System.out.println("startIdx = " + (i-1));
                System.out.println("lastIdx = " + lastIdx);
            }
        }

        

        return answer;
    }


    //중복되는 문자열의 마지막 인덱스 찾기
    public static int findLastIdx(String cryptogram, int startIdx) {



        int lastIdx = startIdx;



        for (int i = startIdx+1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i-1)) {
                lastIdx += 1;

            }else {
                break;
            }

        }


        return lastIdx;
    }


    public static void main (String[] args) {

        //String cryptogram = "browoanoommnaon";
        //String cryptogram = "zyelleyz";
        String cryptogram = "ddogga";

        System.out.println("answer=" + solution(cryptogram));
    }
}
