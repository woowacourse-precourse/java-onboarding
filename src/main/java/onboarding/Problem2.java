package onboarding;

public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";

        // 더 이상 중복된 문자가 없을 때 까지 반복해서 중복된 문자 삭제하기
        while (true){
            if(!beAbleToDelete(cryptogram)) break;

            cryptogram = deleteDuplicatedChar(cryptogram);
        }

        // 결과 반환
        answer = cryptogram;

        return answer;
    }

    /**
     * 문자열에 삭제할 중복된 문자들이 있는지 확인하는 메소드
     * @param str 처리할 문자열
     * @return 삭제할 문자가 있으면 true 반환, 없으면 false 반환
     */
    static boolean beAbleToDelete(String str){
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                return true;
            }
        }

        return false;
    }

    /**
     * 중복된 문자를 삭제하는 메소드
     * @param str 처리할 문자열
     * @return 중복된 문자를 삭제한 후의 문자열을 반환
     */
    static String deleteDuplicatedChar(String str){
        String result = "";
        boolean[] isDuplicated = new boolean[str.length()];

        // 중복인 위치는 true로 표시
        for(int i=0; i<str.length()-1; i++){
            if(str.charAt(i) == str.charAt(i+1)){
                isDuplicated[i] = true;
                isDuplicated[i+1] = true;
            }
        }

        // false 표시가 되어 있는 문자만 result에 넣음
        for(int i=0; i<isDuplicated.length; i++){
            if(!isDuplicated[i]){
                result += str.charAt(i);
            }
        }

        return result;
    }

}
