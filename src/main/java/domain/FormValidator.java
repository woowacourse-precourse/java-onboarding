package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 크루들의 닉네임 신청 폼 목록에 대하여 유효하지 않은 신청 폼을 검증하는 클래스 닉네임이 중복(두 글자 이상의 문자가 연속적으로 순서에
 * 맞추어 포함되어 있는 경우)이면 유효하지 않은 신청 폼이다.
 * @author yoondgu
 */
public class FormValidator {
    private Map<String, List<Form>> usedTwoWordsInfo;
    private Set<Form> invalidForms;

    /**
     * 객체 생성 시 사용된 두 글자 문자열에 대한 정보와 유효하지 않은 폼 정보를 초기화를 강제한다.
     * @param forms
     */
    public FormValidator(List<Form> forms) {
        initUsedTwoWordsInfo(forms);
        initInvalidForms();
    }

    /**
     * 유효하지 않은 폼 정보를 반환한다.
     * @return 닉네임
     */
    public Set<Form> getInvalidForms() {
        return invalidForms;
    }

    /**
     * 복수 개의 신청 폼을 전달받아 usedTwoWordsInfo를 초기화한다.
     * @param forms
     */
    private void initUsedTwoWordsInfo(List<Form> forms) {
        this.usedTwoWordsInfo = new HashMap<>();
        for (Form form : forms) {
            updateUsedTwoWordsInfo(form);
        }
    }

    /**
     * 하나의 신청 폼에 존재하는 모든 두 글자 문자열(twoWord)에 대하여, usedTwoWordsInfo의 정보를 갱신한다.
     * usedTwoWordsInfo는 두 글자 문자열과 이를 사용한 신청 폼 리스트를 저장하는 Map타입의 변수이다. key값으로 중복을
     * 허용하지 않는 두 글자 문자열, value값으로 해당 key값을 닉네임에 사용하는 모든 신청 폼 객체의 리스트를 가진다.
     * @param form
     */
    private void updateUsedTwoWordsInfo(Form form) {
        for (String twoWord : form.getAllUsedTwoWordsByNickname()) {
            // twoWord가 result의 key로 이미 존재하면 리스트값을 가져오고, 존재하지 않으면 새 리스트를 생성한다.
            List<Form> duplicatedForms = (usedTwoWordsInfo.containsKey(twoWord)) ?
                    usedTwoWordsInfo.get(twoWord) : new ArrayList<Form>();
            duplicatedForms.add(form);
            usedTwoWordsInfo.put(twoWord, duplicatedForms);
        }
    }

    /**
     * usedTwoWordsInfo를 이용해 invalidForms를 초기화한다. 초기화되는 값은 중복 닉네임을 신청한 모든 폼 객체의
     * 리스트이다.
     */
    private void initInvalidForms() {
        Set<Form> invalidForms = new HashSet<>();
        for (String twoWord : usedTwoWordsInfo.keySet()) {
            List<Form> usingForms = usedTwoWordsInfo.get(twoWord);
            if (usingForms.size() > 1) {
                invalidForms.addAll(usingForms);
            }
        }
        this.invalidForms = invalidForms;
    }
}
