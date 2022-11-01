package onboarding;

import onboarding.problem6.DuplicationNotificator;

import java.util.List;

/**
 * Problem 6 기능 목록
 * 1. Nickname 의 부분들과 email 을 mapping 하는 map 을 생성한다.
 * 2. Nickname 의 부분과 mapping 된 email 이 1개 이상이라면 email 들을 notify 목록에 저장한다.
 * 3. 알림이 필요한 email list 를 정렬하고 중복 email 을 제거한다.
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        DuplicationNotificator notificator = new DuplicationNotificator();
        return notificator.notifyEmails(forms);
    }
}
