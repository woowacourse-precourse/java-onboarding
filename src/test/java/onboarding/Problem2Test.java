package onboarding;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class Problem2Test {
    // 문자열의 연속된 중복문자 삭제

    String input = "browoanoommnaon";

    @Test
    void 중복문자_없을때까지_제거() {
        assertThat(solution(input)).isEqualTo("brown");
        assertThat(solution("jualllauj")).isEqualTo("");
    }

    private String rereplace(String input){
        while(deleteIdx(input).size()!=0){
            input = replace(input);
        }
        return input;
    }

    @Test
    void 중복문자_제거() {
        assertThat(replace(input)).isEqualTo("browoannaon");
    }

    private String replace(String input) {
        List<Integer> delete = deleteIdx(input);
        char[] chars = input.toCharArray();
        for (int i : delete) {
            String temp = Character.toString(chars[i])+Character.toString(chars[i]);
            input = input.replace(temp,"");
        }
        return input;
    }

    // 삭제할 문자 인덱스 반환
    private List<Integer> deleteIdx(String input){
        char[] chars = input.toCharArray();
        List<Integer> delete = new ArrayList<>();
        for (int i=1; i<chars.length; i++){
            if (chars[i-1]==chars[i]) delete.add(i);
        }
        return delete;
    }
}