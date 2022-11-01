package onboarding;

class Decryption{
    private StringBuilder cypherText;

    Decryption(String cryptogram){
        this.cypherText = new StringBuilder(cryptogram);
    }

    /**
     * cypherText에서 index번째 문자가 연속되는 중복 범위를 반환
     * @param index 중복을 검사할 기준이 되는 문자의 index
     * @return 중복되는 길이
     */
    Integer getOverlapLength(int index){
        Integer length = 0;
        Character prev = cypherText.charAt(index);
        while(index < cypherText.length() - 1){
            Character next = cypherText.charAt(++index);
            if(prev.equals(next) == false){
                break;
            }
            length++;
        }
        if(length > 0){
            length++;
        }
        return length;
    }

    /**
     * 문자열에 연속되는 중복 문자들이 있다면 삭제를 수행
     * @return 삭제가 수행되면 true, 삭제가 수행되지 않았으면 false
     */
    Boolean deleteOverlap(){
        int index = 0;
        Boolean isDelete = false;
        while(index < cypherText.length()){
            Integer length = getOverlapLength(index);
            cypherText.delete(index, index + length);
            if(length.equals(0)){
                index++;
                continue;
            }
            isDelete = true;
        }
        return isDelete;
    }
}
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
