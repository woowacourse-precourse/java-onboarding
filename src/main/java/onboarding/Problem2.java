package onboarding;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Character.isUpperCase;

public class Problem2 {
    // 소문자 예외 처리
    public static boolean isLowerCheck(String string){
        for(int i = 0; i< string.length(); i++){
            // 만약 대문자가 있다면 false 반환
            if(isUpperCase(string.charAt(i))){
                return false;
            }
        }// 모두 통과되면 true 반환
        return true;
    }

    // 중복 문자열 제거 기능
    public static List<Character> dltRedund(String cryptogram){
        int i = 0;
        List<Character> temp = new ArrayList<>(); // 중복이 제거된 결과가 들어갈 List
        char prev = '0'; // 비교를 위한 이전값

        // cryptogram 길이만큼만 수행
        while(i < cryptogram.length()) {
            char item = cryptogram.charAt(i); // 비교할 현재 값 item
            if(i==0){ // 만약 첫번째 문자라면 
                temp.add(item); // temp에 일단 넣는다.
                prev = item; // 다음 문자와의 비교를 위해 현재값을 prev에 저장
            }
            else { // 첫번째 문자가 아니라면
                if (item == prev){// 만약 현재값이 이전값과 동일할때
                    // 현재값이 temp의 마지막 문자와도 동일하다면 temp의 마지막 문자 삭제
                    if (item == temp.get(temp.size()-1)) { 
                        temp.remove(temp.size()-1);
                        //temp.add(item);
                        prev = item;}
                    //temp의 마지막 문자와 일치하지 않으면 temp의 마지막 문자 삭제하지 않는다.
                }
                else { // 현재값과 이전값이 동일하지 않다면
                    temp.add(item); //temp에 해당문자 삽입한다.
                    prev = temp.get(temp.size()-1); // 다음 비교를 위해 삽입한 문자를 prev에 저장한다.
                }

            }
            i++; //index +1
        }
        return temp;
    }

    // 원래의 값(String)과 비교를 위해 List형태를 String으로 변경하는 기능.
    public static String listToString(List<Character> temp){
        // char list to string
        String str = "";
        for (Character item : temp) {
            str += item + "";
        }
        return str;
    }
    
    //만약
    public static boolean checkEnd(String str, String cryptogram){
        // 만약 원래의 값과 중복삭제기능을 수행한 후의 값이 일치한다면
        if(str.equals(cryptogram)) {
            return true; // true 반환
        } // 원래의 값과 중복삭제기능을 수행한 후의 값이 일치하지 않는다면
        // false 반환
        return false;
    }

    public static String solution(String cryptogram) {

        // 예외처리
        // 예외 1. cryptogram은 길이가 1 이상 1000 이하인 문자열이 아닐 경우 error
        if (cryptogram.length() < 1){
            return "The cryptogram must be more at least 1 character";
        }
        else if (cryptogram.length() > 1000 ){
            return "The cryptogram must be less than 1000 characters";
        }
        // 예외 2. cryptogram은 알파벳 소문자로만 이루어져 있지 않을 경우 error.
        if(!isLowerCheck(cryptogram)){
            return "The cryptogram must be lowercase.";
        }

        String answer = "answer";

        // 중복 삭제 메소드
        List<Character> temp = dltRedund(cryptogram);

        // checkEnd 함수가 true이면
        // 정답 return 및 재귀에서 빠져나온다.
        if (checkEnd(listToString(temp), cryptogram)){
            answer = listToString(temp);

            return answer;

        }
        else { // ckeckEnd 함수가 false이면
            // 다시 수행 (재귀)
            if (temp.size() <= 1) // 길이가 1이하라면 중복을 체크할 것이 없기 때문에 재귀를 중단한다.
                return listToString(temp);
            answer = solution(listToString(temp));
        }

        return answer;
    }

}