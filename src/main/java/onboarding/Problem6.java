package onboarding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {

    private static List<String> answer = new ArrayList<>();
    private static List<List<String>> list;

    public static List<String> solution(List<List<String>> forms) {

        list = forms;

        String curr;
        for (int i = 0; i < forms.size(); i++) {
            curr = forms.get(i).get(1);
            check(i, curr);
        }

        Collections.sort(answer);
        return answer;

    }

    // 현재 글자를 2글짜씩 잘라서 전체 리스트에 있는지 체크해보는 메소드
    private static void check(int idx, String curr) {
        String temp;
        int count = 0;
        for (int j = 0; j < curr.length()-1; j++) {
            //2글자씩 자르고 일치하는게 있는지 탐색해보기
            temp = curr.substring(j, j+2);
            for (int k = 0; k < list.size(); k++) {
                if(k != idx && search(k, temp)){
                    count++;
                    break;
                }
            }
        }
        if (count > 0) answer.add(list.get(idx).get(0));
    }

    // 2글자를 통해 검색하는 메소드
    private static boolean search(int idx, String keyword) {
        return list.get(idx).get(1).matches(".*" + keyword+".*");
    }

}


class Nickname {

    private final String nickname;

    private final List<String> partNickName = new ArrayList<>();

    public Nickname(String nickname) {
        validateSize(nickname);
        this.nickname = nickname;
        cuttingNickname();
    }

    private void validateSize(String nickname) {
        if(nickname.length() < 1) {
            throw new IllegalArgumentException("닉네임은 공백은 불가합니다.");
        }
        if(nickname.length() >= 20){
            throw new IllegalArgumentException("닉네임은 20자 미만으로 입력해주세요");
        }
    }

    private void cuttingNickname() {
        String temp;
        for (int j = 0; j < this.nickname.length()-1; j++) {
            temp = this.nickname.substring(j, j + 2);
            this.partNickName.add(temp);
        }
    }

    public String getNickname() {
        return this.nickname;
    }

    public List<String> getPartNickName() {
        return this.partNickName;
    }
}

class Email {

    private final String email;

    public Email(String email) {
        validateSize(email);
        validateDomain(email);
        this.email = email;
    }

    private void validateDomain(String email) {
        if(!email.matches(".+@email.com")){
            throw new IllegalArgumentException("이메일을 ~@email.com 형식으로 입력해주세요.");
        }
    }

    private void validateSize(String email){
        if(email.length() < 11) {
            throw new IllegalArgumentException("이메일은 11자 이상만 가능합니다.");
        }
        if(email.length() > 20) {
            throw new IllegalArgumentException("이메일은 20자 이하만 가능합니다.");
        }
    }

    public String getEmail() {
        return this.email;
    }

}
