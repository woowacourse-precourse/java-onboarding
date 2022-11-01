package onboarding;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Problem6 {

    public static List<String> solution(List<List<String>> forms) {
        return new Solver6(forms).solve();
    }
}

final class Solver6 {

    /**
     * 크루는 1명 이상 10,000명 이하이다.
     */
    private final List<List<String>> forms;

    /**
     * 중복 사용자의 이메일
     */
    private final List<String> duplicateUsersEmails = new ArrayList<>();

    /**
     * 두 글자에 해당하는 이름을 저장한다.
     */
    private final Set<String> earlyNicknameParts = new HashSet<>();
    private final Set<String> lateNicknameParts = new HashSet<>();

    private final FormValidator validator = new FormValidator();

    /*
        생성자에서 Validation을 수행한다.
        - 신청할 수 있는 이메일은 `email.com` 도메인으로만 제한한다.
        - 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
     */
    public Solver6(final List<List<String>> forms) {
        this.forms =
            forms
                .stream()
                .filter(form -> {
                    String email = form.get(0);
                    String nickname = form.get(1);
                    return valid(email, nickname);
                })
                .collect(Collectors.toList());
    }

    private boolean valid(final String email, final String nickname) {
        return validator.validEmailFormat(email) && validator.validEmailHost(email) && validator.validNickname(nickname);
    }

    public List<String> solve() {
        // 중복 제거
        this.removeEarlyDuplicates();
        this.removeLateDuplicates();

        // 배열 정제
        this.removeEmailDuplicates();
        this.sortEmails();

        return this.duplicateUsersEmails;
    }

    /**
     * 리스트를 2회 반복하여 중복을 제거할 때의 첫 번째 순회의 역할을 수행한다.
     * 앞에 이미 있는 원소 덕분에 중복으로 밝혀진 경우 제거한다.
     * 두 번째 순회 시 중복 확인을 위해 본인의 Segment를 등록한다.
     *
     * <예시>
     *  제이스
     *  제이
     *  이스
     *
     *  제이     [제이]
     *  제이스   v[제이; added to LATE] [이스; added to EARLY]
     *  이스     v[이스]
     *  제이     v[제이; LATE]
     */
    private void removeEarlyDuplicates() {
        this.forms.stream()
            .forEach(form -> {
                String email = form.get(0);
                String nickname = form.get(1);
                twoCharSegmentsOf(nickname)
                    .forEach(x -> {
                        // 이미 이전의 원소가 존재했던 경우 실제로 중복
                        // 이전에 Segment를 등록한 원소가 최초의 원소이면 제거되지 않았으므로 LATE에 등록
                        if (this.earlyNicknameParts.contains(x)) {
                            this.duplicateUsersEmails.add(email);
                            this.lateNicknameParts.add(x);
                        }
                        // 해당 segment가 겹치지 않는 경우 EARLY로 등록 - 아직 본인은 중복이 아님
                        // 이후에 EARLY에서 중복을 찾으면 실제로 중복
                        this.earlyNicknameParts.add(x);
                    });
            });
    }

    /**
     * 리스트를 2회 반복하여 중복을 제거할 때의 두 번째 순회의 역할을 수행한다.
     * 순회 뒷부분에서 그 이전 원소가 중복으로 밝혀진 경우 해당 원소를 제거하는 순회이다.
     * 따라서 해당 순회에서는 더 이상 Segment를 등록하는 일은 없다.
     */
    private void removeLateDuplicates() {
        this.forms.stream()
            .forEach(form -> {
                String email = form.get(0);
                String nickname = form.get(1);
                twoCharSegmentsOf(nickname)
                    .forEach(x -> {
                        if (this.lateNicknameParts.contains(x)) {
                            this.duplicateUsersEmails.add(email);
                        }
                    });
            });
    }

    private List<String> twoCharSegmentsOf(final String nickname) {
        List<String> segments = new ArrayList<>();
        for (int i = 0; i < nickname.length() - 1; i++) {
            String twoCharSegment = nickname.substring(i, i + 2);
            segments.add(twoCharSegment);
        }
        return segments;
    }

    /**
     * 이메일에 해당하는 부분의 문자열의 중복은 제거한다.
     */
    private void removeEmailDuplicates() {
        this.duplicateUsersEmails = new ArrayList<>(new HashSet<>(this.duplicateUsersEmails));
    }

    /**
     * 이메일에 해당하는 부분의 문자열을 오름차순으로 정렬
     */
    private void sortEmails() {
        this.duplicateUsersEmails = this.duplicateUsersEmails.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
    }
}

/**
 * 유효성 검증 논리 분리
 */
final class FormValidator {

    /**
     * 이메일은 이메일 형식에 부합하며, 전체 길이는 11자 이상 20자 미만이다.
     */
    public boolean validEmailFormat(final String email) {
        return email.contains("@") && email.length() >= 11 && email.length() < 20;
    }

    /**
     * 신청할 수 있는 이메일은 `email.com` 도메인으로만 제한한다.
     */
    public boolean validEmailHost(final String email) {
        return email.split("@")[1].equals("email.com");
    }

    /**
     * 닉네임은 한글만 가능하고 전체 길이는 1자 이상 20자 미만이다.
     */
    public boolean validNickname(final String nickname) {
        if (nickname.length() < 1 || nickname.length() >= 20) {
            return false;
        }
        for (int i = 0; i < nickname.length(); i++) {
            if (!koreanCodePoint(nickname.codePointAt(i))) {
                return false;
            }
        }
        return true;
    }

    public boolean koreanCodePoint(final int codePoint) {
        return codePoint >= "가".codePointAt(0) && codePoint <= "힣".codePointAt(0);
    }
}
