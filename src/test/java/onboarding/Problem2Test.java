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
    void 중복된반복문자체크() {
        boolean[] result = {false,false,true,true,true,true,false,false};
        char[] input = {'b','a','n','n','a','a','n','a'};
        assertThat(checkJungbok(input)).isEqualTo(result);
    }

    private boolean[] checkJungbok(char[] input) {
        boolean[] result = new boolean[input.length];
        for (int i=1; i<input.length; i++){
            if (input[i-1]==input[i]) {
                result[i-1] = true;
                result[i] = true;
            }
        }
        return result;
    }

}