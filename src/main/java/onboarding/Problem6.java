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
 *      - is_duplicate_exist(Candidate target) = target 과 중복인 닉네임이 있는지 candidate_arr 을 돌면서 확인
 *          - is_nickname_duplicate_with(Candidate target, Candidate compare) = target, compare 의 닉네임이 중복인지 모든 조합을 이용해서 탐색
 *              - make_two_letter_word_start_from(String str, int index ) = str 에서 index 부터 시작하는 길이가 2인 substring 을 반환
 *              - check_nickname_duplicate(Candidate candidate, String word) = candidate 의 닉네임에 word 가 있으면 중복 닉네임 찾음 표시
 *
 *  - make_result() = candidate 들 중 중복 아이디가 있는 candidate 의 이메일을 담은 list 를 생성
 *      - add_result_who_has_duplicate_nickname(Candidate candidate) = candidate 와 중복된 아이디가 있는 경우 result 에 email 을 add
 *
 * - sort_result_alphabetically() = result 를 알파벳 오름차순으로 정렬
 *
 * - show_result() = result 를 리스트로 반환
 *
 */

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        List<String> answer = List.of("answer");
        return answer;
    }
}
