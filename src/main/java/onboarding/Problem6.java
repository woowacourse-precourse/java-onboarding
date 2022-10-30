package onboarding;

import onboarding.problem6.DuplicationNotificator;

import java.util.List;

/**
 * Problem 6 function list
 * - Create duplication map for each part of nickname
 * - Select emails which needs to be notified
 * - Sort 'need notified' email list
 * - Remove duplicated email from 'need notified' email list
 */
public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        DuplicationNotificator notificator = new DuplicationNotificator(forms);
        return notificator.duplicationNotify();
    }
}
