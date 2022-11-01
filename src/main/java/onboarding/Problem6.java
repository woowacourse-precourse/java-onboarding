package onboarding;


import custom.problem6.DuplicateCheckResolver;
import custom.problem6.Form;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * > 요구사항
 * 1. word를 2개씩 끊어서 연속되게 hash에 저장, 이 때 hash에는 word의 소속을 알기 위해 email을 같이 매핑해준다.
 * 2. 순회하면서 hash key에 word가 있느지 여부에 따라 중복여부를 결정한다.
 * 3. 중복이면 해당 word에 저장된 value인 email과 현재 email을 결과 set에 넣어준다.
 * 4. 정렬해서 출력한다.
 */
public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        List<Form> formList = makeFormList(forms);

        DuplicateCheckResolver duplicateCheckResolver = new DuplicateCheckResolver();
        Set<String> duplicateNicknameSet = duplicateCheckResolver.findDuplicateForm(formList);

        return convertAnswerFormat(duplicateNicknameSet);
    }

    private static List<Form> makeFormList(List<List<String>> forms) {
        return forms.stream()
            .map(Form::of)
            .collect(Collectors.toList());
    }

    private static List<String> convertAnswerFormat(Set<String> answer) {
        return answer.stream()
            .sorted()
            .collect(Collectors.toList());
    }

}

