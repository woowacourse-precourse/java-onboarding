package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        // 더 이상 중복된 문자가 없을 때 까지 반복해서 중복된 문자 삭제하기
        while (true){
            if(!beAbleToDelete(cryptogram)) break;


        }

        // 결과 반환


        return answer;
    }

    /**
     * 문자열에 삭제할 중복된 문자들이 있는지 확인하는 메소드
     * @param str
     * @return
     */
    static boolean beAbleToDelete(String str){
        boolean[] isDuplicated = new boolean[str.length()];

        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                return true;
            }
        }

        return false;
    }

}
