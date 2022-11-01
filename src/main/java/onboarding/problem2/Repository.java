package onboarding.problem2;



import onboarding.Problem2;

import java.util.LinkedList;
import java.util.List;

import static java.lang.String.valueOf;



public class Repository {
    // 저장 기능
    public static LinkedList<String> save(String encode) {

        LinkedList<String> repository = new LinkedList<>();

        char startIndex = encode.charAt(0);
//        int lastIndex = encode.length();

// browoanoommnaon -> oo mm nn aa oo
        repository.add(valueOf(startIndex));

        // StringIndexOutOfBoundsException 처리
        for (int i=1; i<encode.length()-1; i++) {


            char collect = encode.charAt(i);
            char next = encode.charAt(i+1);
            char before = encode.charAt(i-1);

             // 중복 피해가기
            if(collect != next & collect != before){ repository.add(valueOf(collect)); }

        }
        repository.add(valueOf(encode.
                charAt(encode.length()-1)));



        return repository;
    }
}