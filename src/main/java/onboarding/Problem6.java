package onboarding;

import java.util.ArrayList;
import java.util.List;

public class Problem6 {
    private static List<List<String>> candidates = new ArrayList<List<String>>();
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = new ArrayList<>();


        for(List<String> person : forms) {
            List<String> words = collectTwoCharacters(person.get(0));

            if (getIndexOfDuplication(words) != -1) {
                answer.add(person.get(1));
            }

            candidates.add(words);
        }

        return answer;
    }

    /**
     * 입력받은 이름을 2글자가 되도록 쪼개서 모은다 (ex: 제이슨 -> 제이,이슨)
     */

    private static List<String> collectTwoCharacters(String name) {
        ArrayList<String> words = new ArrayList<>();
        for(int i=0; i<name.length()-1; i++) {
            String twoCharacter = String.valueOf(name.substring(i,i+2));
            words.add(twoCharacter);
        }

        return words;
    }

    /**
     * 이전에 모여진 2글자들의 모음에서 현재 가지고있는 2글자들 발견된 index를 반환한다.
     * 해당 index는 form의 index와 동일함
     *  (등록되어 있다면 같은 글자가 연속적으로 포함된다는 뜻)
     */
    private static int getIndexOfDuplication(List<String> words) {
        for(int i=0; i<candidates.size(); i++) {
            for(String twoCharacter : words) {
                if ( candidates.get(i).contains(twoCharacter) ) {
                    return i;
                }
            }
        }

        return -1;
    }
}
