package onboarding;


/**
 *
 * [ Candidate ]
 *  - String nickname = 지원자 닉네임
 *  - String email = 지원자 이메일
 *  - boolean need_to_change_nickname = 지원자와 중복되는 닉네임이 있는지 없는지
 *
 *  - find_similar_nickname() = 비슷한 닉네임을 찾음
 *  - need_to_change() = 닉네임을 바꿔야 하는지 반환
 *  - show_email() = email 반환
 *  - show_nickname() = 닉네임 반환
 *
 * [ Nickname_validator ]
 *  - candidate_arr = Candidate 로 이루어져 있는 배열
 *  - result = 중복되는 닉네임을 가진 지원자의 email 을 담아 반환할 리스트
 *
 *  - make_candidate_arr_by_forms( List forms ) = forms 를 이용하여 candidate_arr 생성
 *      - transfer_from_to_candidate = form 을 Candidate 객체로 바꿔서 반환
 *          - find_nickname_from_form(List form) = form 에서 nickname 을 찾아서 반환
 *          - find_email_from_form(List form) = form 에서 email 을 찾아서 반환
 *
 *  - check_all_nickname() = candidate_arr 를 맨처음부터 돌면서 중복이 있는지 확인
 *      - compare_with_all_nickname(Candidate candidate) = candidate 과 중복인 닉네임이 있는지 candidate_arr 을 돌면서 확인
 *          - check_all_cases(Candidate candidate, Candidate target) = candidate, target 의 닉네임이 중복인지 모든 조합을 이용해서 탐색
 *              - make_two_letter_word_start_from(String str, int index ) = str 에서 index 부터 시작하는 길이가 2인 substring 을 반환
 *              - check_target_contains_word(Candidate candidate, String word) = candidate 의 닉네임에 word 가 있으면 중복 닉네임 찾음 표시
 *
 *  - make_result() = candidate 들 중 중복 아이디가 있는 candidate 의 이메일을 담은 list 를 생성
 *      - add_result_who_has_duplicate_nickname(Candidate candidate) = candidate 와 중복된 아이디가 있는 경우 result 에 email 을 add
 *
 * - sort_result_alphabetically() = result 를 알파벳 오름차순으로 정렬
 *
 * - show_result() = result 를 리스트로 반환
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        Nickname_validator nickname_validator = new Nickname_validator();
        nickname_validator.make_candidate_arr_by_forms(forms);
        nickname_validator.check_all_nickname();
        nickname_validator.make_result();
        nickname_validator.sort_result_alphabetically();
        return nickname_validator.show_result();
    }
}

class Candidate {
    private String nickname;
    private String e_mail;
    private boolean nickname_duplicate;

    Candidate(String e_mail, String nickname) {
        this.e_mail = e_mail;
        this.nickname = nickname;
        nickname_duplicate = false;
    }

    public void find_duplicate_nickname() {
        nickname_duplicate = true;
    }

    public boolean need_to_change() {
        return nickname_duplicate;
    }

    public String show_nickname() {
        return this.nickname;
    }

    public String show_e_mail() {
        return this.e_mail;
    }
}

class Nickname_validator {
    private Candidate[] candidate_arr;
    private List<String> result;

    public void make_candidate_arr_by_forms(List<List<String>> forms) {
        candidate_arr = new Candidate[forms.size()];
        for (int index = 0; index < candidate_arr.length; index++) {
            candidate_arr[index] = transfer_form_to_candidate(forms.get(index));
        }
    }

    private Candidate transfer_form_to_candidate(List<String> form) {
        return new Candidate(find_email_from_form(form), find_nickname_from_form(form));
    }

    private String find_nickname_from_form(List<String> form) {
        return form.get(1);
    }

    private String find_email_from_form(List<String> form) {
        return form.get(0);
    }

    public void check_all_nickname() {
        for (Candidate candidate : candidate_arr) {
            compare_with_all_nickname(candidate);
        }
    }

    private void compare_with_all_nickname(Candidate candidate) {
        for (Candidate target : candidate_arr) {
            check_all_cases(candidate, target);
        }
    }

    private void check_all_cases(Candidate candidate, Candidate target) {
        if (candidate == target)
            return;
        String candidate_nickname = candidate.show_nickname();
        for (int start = 0; start < candidate_nickname.length() - 1; start++) {
            check_target_contains_word(target, make_two_letter_word_start_from(candidate_nickname, start));
        }
    }

    private void check_target_contains_word(Candidate candidate, String word) {
        if (candidate.show_nickname().contains(word)) {
            candidate.find_duplicate_nickname();
        }
    }

    private String make_two_letter_word_start_from(String str, int index) {
        return str.substring(index, index + 2);
    }

    public void make_result() {
        result = new ArrayList<>();
        for (Candidate candidate : candidate_arr) {
            add_result_who_has_duplicate_nickname(candidate);
        }
    }

    private void add_result_who_has_duplicate_nickname(Candidate candidate) {
        if (candidate.need_to_change()) {
            this.result.add(candidate.show_e_mail());
        }
    }

    public void sort_result_alphabetically() {
        Collections.sort(this.result);
    }

    public List<String> show_result() {
        return result;
    }
}