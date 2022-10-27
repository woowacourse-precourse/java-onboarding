/*
 * 1,두글자 이상의 문자가 연속이면 중복으로 간주.
 *  - $$$ 방법을 고민 해본다.
 * 2,크루는 1명 이상 10000명 이하 = 가변적, 시간 복잡도 계산
 *  - 숫자 변화에 따른 유동적인 코드 작성
 *  - ??? 시간복잡도를 고려 해본다 ????
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

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    public static boolean email_check(String email){
           if(email.contains("@email.com")){
            return true;
           }
           return false;
        }
        
    public static boolean email_lenght_check(String email){
        int email_lenght = email.length();
        if(11 <= email_lenght && email_lenght < 20){
            return true;
        }
        return false;
    }
           
    public static void main(String[] args){
        String[][] email = {{"jm@email.com", "제이엠"},{"jason@email.com", "제이슨"},{"woniee@email.com", "워니"},{"mj@email.com", "엠제이"},{"nowm@email.com", "이제엠"}};
        for(int i = 0; i < email.length;i++){
        if (email_check(email[i][0]) && email_lenght_check(email[i][0])){
            System.out.print("성공");
        }
        else{
            System.out.print("실패");
        }
    }
            // String target = "@";
            // int target_num = email[i][0].indexOf(target);
            
            // System.out.print(email[i][0]);
            // System.out.print(email[i][0]);
            // System.out.print(',');
            // System.out.print(email[i][0].substring(0,target_num)); // @ 앞 문자열만 파싱
            // System.out.print(',');
            // System.out.print(email[i][0].substring(target_num)); // @ 부터 끝까지 파싱 <- 이메일 양식이 맞는 확인에 쓸 것
            // System.out.print(',');
            // for(int j = 0; j <email[i].length;j++){
            //     System.out.print(email[i][0]);
            //     System.out.print(',');
            // }
        }
    }