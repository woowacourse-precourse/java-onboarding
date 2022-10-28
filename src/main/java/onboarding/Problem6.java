package onboarding;

import onboarding.domain.EmailSender;

import java.util.List;

public class Problem6 {
    public static List<String> solution(List<List<String>> forms) {
        EmailSender emailSender = new EmailSender(forms);
        return emailSender.sendEmail();
    }
}
