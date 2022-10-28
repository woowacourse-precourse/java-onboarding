package onboarding;

import java.util.List;
import java.util.stream.Stream;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");

        return answer;
    }
}

class Crew{
    private String email;
    private String nickname;

    public Crew(String email, String nickname){
        this.email = checkEmail(email);
        this.nickname = checkNickname(nickname);
    }

    private String checkEmail(String email){
        if(!email.contains("@")||email.length()<11||email.length()>=20) {
            throw new IllegalArgumentException("이메일 형식에 부합하지 않습니다.");
        }
        if(email.split("@",1)[1].equals("email.com")) {
            throw new IllegalArgumentException("이메일의 도메인이 email.com가 아닙니다.");
        }
        return email;
    }

    private String checkNickname(String nickname){
        if(nickname.length()>=20||nickname.length()<1)
            throw new IllegalArgumentException("닉네임의 길이는 1이상 20미만이어야합니다.");
        checkNicknameKorean(nickname);
        return nickname;
    }

    private void checkNicknameKorean(String nickname){
        Stream.of(nickname.split(""))
                .map(x->x.charAt(0))
                .forEach(x->{
                    if(Character.getType(x)!=5)
                        throw new IllegalArgumentException("닉네임은 모두 한글로 이루어져야합니다.");
                });
    }
}