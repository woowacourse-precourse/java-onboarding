/*
 * 1,두글자 이상의 문자가 연속이면 중복으로 간주.
 *  - $$$ 방법을 고민 해본다.
 * 2,크루는 1명 이상 10000명 이하 = 가변적, 시간 복잡도 계산
 *  - 숫자 변화에 따른 유동적인 코드 작성
 *  - ??? 시간복잡도를 고려 해본다 ????
 * 
 * 3,전체의 길이가 11자 이상 20자 미만인지 확인 (이메일은 이메일 형식에 부합 해야한다.)
 *  - 3번 보다 4번을 먼저 판단한다.
 *  - 길이의 참과 거짓을 판단하는 메소드 작성
 * 
 * 4,이메일의 양식이 맞는지 확인
 * - 이메일만 모으는 배열을 만든다 X
 * - contains 사용을 통한 유무 확인
 * 
 * 5,닉네임이 한글인지 확인, 길이는 1자 이상 20자 미만인지 확인
 *  - 닉네임만 모으는 배열 생성.
 *  - $$$한글만 확인 하는 방법을 생각 해본다.
 * 6,result = 중복 제거, 문자열을 오름차순
 */
package onboarding;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Arrays;
import java.util.regex.Pattern;

public class Problem6 {
    public static List<String> list;
    public static String[] NikeNameList;
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();
        
        
        return answer;
    }

    // public static boolean email_check(String email){ // email format check list method
    //        if(email.contains("@email.com")){
    //         return true;
    //        }
    //        return false;
    //     }
        
    // public static boolean email_lenght_check(String email){ // email lenght check method
    //     int email_lenght = email.length();
    //     if(11 <= email_lenght && email_lenght < 20){
    //         return true;
    //     }
    //     return false;
    // }
    // public static boolean nikName(){
    //     return false;
    // }
    // public static boolean sameLetter(){

    // }


    public static void main(String[] args){
        List<List<String>> forms = Arrays.asList(Arrays.asList("jm@email.com", "제이엠"),
        Arrays.asList("jason@email.com", "제이슨"),
        Arrays.asList("woniee@email.com", "워니"),
        Arrays.asList("mj@email.com", "엠제이"),
        Arrays.asList("nowm@email.com", "이제엠"));

        
        for(int index = 0; index < forms.size();index++){
            list = forms.get(index); // forms list
            NikeNameList = list.get(1).split(""); // 닉네임 리스트
            // int len = list.get(1).length();
            // System.out.println(len);
            // System.out.println(list);
            // System.out.print(Arrays.toString(NikeNameList)); // 닉네임 리스트 출력값
        }
        

        // name length check (11 ~ 19)

        // for(int i = 0; i < forms.size();i++){
        //     int len = forms.get(i).get(1).length();
        //     if((1 <= len) && (len < 20)){
        //         System.out.println(true);
        //     }
        // }

        //korean language check

        // for(int i = 0; i < forms.size();i++){
        //     String name = forms.get(i).get(1);
        //     if(Pattern.matches("^[가-힣]*$", name) == true){
        //         System.out.println("참");            
        //     }
        // }

        // email format check(email.com) 

        // for(int i = 0; i < forms.size();i++){ 
        //     String email = forms.get(i).get(0);
        //     if(email.contains("@email.com") == true){
        //         System.out.println("참");
        //     }
        // }
        
        // email total length check 11 ~ 19

        //  for(int i = 0; i < forms.size();i++){
        //     int email_len = forms.get(i).get(0).length();
        //     if(11 <= (email_len) && (email_len < 20)){
        //         System.out.println("참");
        //     }
        // }

        // crew range check

        // int crewLen = forms.size();
        // if ((1 <= crewLen) && (crewLen <= 10000)){
        //     System.out.println("true");
        // }

        // same letter check
        // 제 이 엠
        // 제 이 슨
        // check_lsit = [0 1]
        // 이중 for문을 사용해서 아스키 코드의 차이의 값이 값으면
        // 해당 인덱스의 위치를 check에 추가 후
        // check를 i , i + 1씩 돌려서 체크 해 해준다.



    }
}