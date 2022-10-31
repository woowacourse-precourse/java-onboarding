package onboarding;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 주어진 String을 character list로 옮긴다.
 * 반복문을 만들어 두개이상 연속하는 중복 문자가 있는지 확인
 * 중복 문자가 발견되었을때 character list에서 해당 중복 문자 제거
 * 처음부터 다시 반복문을 통해 중복 문자 확인
 *
 * @author heeyoung lee
 * @date 2022.10.30
 */

public class Problem2 {
    public static String solution(String cryptogram) {
        List<Character> chars = new ArrayList<>();

        for(char c: cryptogram.toCharArray()){
            chars.add(c);
        }
        remove(chars);

        StringBuilder sb = new StringBuilder();
        for(Character c: chars){
            sb.append(c);
        }
        String answer = sb.toString();
        return answer;
    }

    /**
     *
     * 반복문중 중복 문자가 발견되었다면 중복 문자를 제거하고 처음부터 다시 반복문을 사용해야 하기때문에 hasDuplicate라는 변수를 통해 만약 중복 문자가 발견되었다면
     * 리스트안에서 위치를 나타내는 index 변수를 0으로 리셋하여 다시 처음부터 반복문을 돌린다.
     *
     * 처음 요소부터 시작하여 연속으로 오는 다음 요소와 같은지 확인
     *  1. 만약 같다면 -> 현제 인덱스 다음 요소를 먼저제거후 hasDuplicate을 true로 바꾼다.
     *              -> 그후 해당 인덱스에 있는 요소 제거후 인덱스를 0으로 리셋시킨다.
     *  2. 같지 않다면 -> 인덱스만 증가시킨다.
     *
     *  반복문 마지막에는 디폴트로 hasDuplicate를 다시 false로 지정한다.
     *
     * 더이상에 중복문자가 없다면 리스트 index 밖을 access하려고 할것이고 그럼 IndexOutOfBoundsException이 thrown 된댜.
     * 그럼 try/catch를 이용해여 메소드를 끝낸다.
     *
     * @param charArr solution 메소드에서 매개변수로 받은 String으로 변환한 character list
     */

    public static void remove(List<Character> charArr){
        boolean hasDuplicate = false;
        int index = 0;

        try{
            while(true){
                if(index+1==charArr.size()) break;
                while((charArr.get(index).equals(charArr.get(index+1)))) {
                    charArr.remove(index+1);
                    hasDuplicate = true;
                    if(charArr.size()==index+1) break;
                }
                if(hasDuplicate){
                    charArr.remove(index);
                    index = 0;
                } else{
                    index++;
                }
                hasDuplicate = false;
            }
        } catch(IndexOutOfBoundsException e){
            return;
        }
    }
}
