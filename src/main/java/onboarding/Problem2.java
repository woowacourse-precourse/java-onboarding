package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "answer";


        for (int i = 1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i-1)) {


                int lastIdx = findLastIdx(cryptogram, i-1);
                String result = deleteStr(i-1,lastIdx,cryptogram);
                System.out.println("result = " + result);
            }
        }

        

        return answer;
    }


    //찾은 인덱스로 삭제하는 함수
    public static String deleteStr(int startIdx, int lastIdx, String cryptogram){

        StringBuffer str = new StringBuffer(cryptogram);


        cryptogram = str.delete(startIdx,lastIdx + 1).toString();


        return cryptogram;
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
