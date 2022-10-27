package onboarding;

import java.util.HashMap;
import java.util.List;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        /**
         * 문제 조건
         * 1. 이메일은 이메일 형식에 부합하며 전체 길이가 11자 이상 20자 미만이다
         * 2. 신청할 수 있는 이메일은 email.com 도메인으로만 제한한다.
         * 3. 닉네임은 한글만 가능하며, 전체 길이는 1자 이상 20자 미만이다
         *
         * 구현 기능
         * 1. 크루들의 닉네임 중 두 글자 이상의 문자가 연속적으로 순서에 맞추어 포함되어 있는 경우 중복으로 간주하는 기능 구현
         * ( 닉네임이 한 글자이며, 중복되는 경우는 포함하지 않음)
         *  1) 크루들의 닉네임에 접근 해 가능한 모든 두 글자 경우의 수를 Set으로 담음
         *  2) Set으로 담은 가능한 모든 두 글자의 경우를 Map에 담음. key는 글자의 경우, Value는 0으로 초기화
         *  3) 크루들의 닉네임에 접근, contains를 사용해 Map의 value에 ++ 해 줌
         *  4) value가 2 이상인 두 글자 출력
         *  5) 해당 글자를 가지고 있는 유저를 set으로 담음 (중복 제거)
         *
         *  2. 중복 문자를 가지고 있는 유저의 email주소를 담고, 오름차순으로 정렬
         */

        List<String> answer = List.of("answer");
        return answer;
    }

}
