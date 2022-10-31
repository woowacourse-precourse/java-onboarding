package onboarding.problem2;


import java.util.LinkedList;
import java.util.List;

import static java.lang.String.valueOf;


public class Repository {
    // 저장 기능
    public static LinkedList<String> save(String encode) {

        LinkedList<String> repository = new LinkedList<>();

        for (int i = 0; i <= encode.length(); i++) {

            String cryptogram;

            // char 배열의 범위를 벗어난 인덱스 지정이 문제? 인덱스 지정 형식이 문제?

            char collector = encode.charAt(i);
            char verifier = encode.charAt(i+1);

            // 검사 기능(중복 피해가기)
                if (collector != verifier) { repository.add(valueOf(collector)); }

        }
        return repository;
    }
}