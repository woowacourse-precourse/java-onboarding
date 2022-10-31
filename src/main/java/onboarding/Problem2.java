package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        while(true){
            //중복 제거 함수 결과
            String ret = deduplication(cryptogram);

            //중복 제거 함수 결과가 FALSE라면 break
            if(ret.equals("FALSE")){
                break;
            }
            
            //중복 제거가 됐다면 문자열 덮어쓰기
            cryptogram = ret;
        }
        return cryptogram;
    }

    //중복 제거 함수
    private static String deduplication(String cryptogram){
        //정규식으로 연속된 문자열 모두 지우기
        String changeString = cryptogram.replaceAll("(([a-z])\\2+)","");

        //원래 문자와 같다면 FALSE 문자 반환
        if(cryptogram.equals(changeString)){
            return "FALSE";
        }
        //다르다면 바뀐 문자 반환
        return changeString;
    }
}
