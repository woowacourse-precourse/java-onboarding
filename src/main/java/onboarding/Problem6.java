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
        
        // for(int i = 0; i < forms.size();i++){ // 닉네임 길이 (1 ~ 19)
        //     int len = forms.get(i).get(1).length();
        //     if((1 <= len) && (len < 20)){
        //         System.out.println(true);
        //     }
        // }
        // for(int i = 0; i < forms.size();i++){ // 닉네임 한글 체크
        //     String name = forms.get(i).get(1);
        //     if(Pattern.matches("^[가-힣]*$", name) == true){
        //         System.out.println("참");            
        //     }
        // }

    }
}