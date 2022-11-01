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
}
public class Problem2 {
    public static String solution(String cryptogram) {
        String answer = "answer";
        return answer;
    }
}
