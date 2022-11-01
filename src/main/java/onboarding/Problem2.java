package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {

        String answer = "answer";



        answer = recursivefunc(cryptogram,0);

        return answer;
    }


    //인덱스를 찾고 삭제하는 과정을 재귀적으로 수행하는 함수
    public static String recursivefunc(String cryptogram, int startIdx){

        if (startIdx < 0) {startIdx = 0;}



        for (int i = startIdx+1; i < cryptogram.length(); i++) {
            if (cryptogram.charAt(i) == cryptogram.charAt(i-1)) {

                int newstartIdx = i-1;

                int lastIdx = findLastIdx(cryptogram,newstartIdx);

                String result = deleteStr(newstartIdx,lastIdx,cryptogram);

                cryptogram = recursivefunc(result,newstartIdx-1);

            }
        }

        return cryptogram;
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


}
