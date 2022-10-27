/*
 * 두글자 이상의 문자가 연속이면 중복으로 간주.
 * 크루는 1명 이상 10000명 이하 = 가변적, 시간 복잡도 계산
 * 이메일의 아이디가 11자 이상 20자 미만인지 확인
 * 이메일의 양식이 맞는지 확인
 * 닉네임이 한글인지 확인, 길이는 1자 이상 20자 미만인지 확인
 * result = 중복 제거, 문자열을 오름차순
 */
package onboarding;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
    public static void main(String[] args){
        String[][] email = {{"jm@email.com", "제이엠"},{"jason@email.com", "제이슨"},{"woniee@email.com", "워니"},{"mj@email.com", "엠제이"},{"nowm@email.com", "이제엠"}};
        for(int i = 0; i < email.length;i++){
            System.out.print(email[i][0]);
            System.out.print(',');
            // for(int j = 0; j <email[i].length;j++){
            //     System.out.print(email[i][0]);
            //     System.out.print(',');
            // }
        }
    }
}
