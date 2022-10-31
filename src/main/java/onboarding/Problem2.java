package onboarding;

import onboarding.problem2.Decryptor;
import onboarding.problem2.StackCalculator;
import onboarding.problem2.StringMainStack;
import onboarding.problem2.StringStackCalculator;
import onboarding.problem2.StringStackDecryptor;
import onboarding.problem2.StringSubStack;

public class Problem2 {
    public static String solution(String cryptogram) {
        StringMainStack stringMainStack = new StringMainStack();
        StringSubStack stringSubStack = new StringSubStack();
        StackCalculator<StringMainStack, StringSubStack> stackCalculator = new StringStackCalculator();
        Decryptor decryptor = new StringStackDecryptor(stringMainStack, stringSubStack, stackCalculator);

        decryptor.insertCrypto(cryptogram);
        return decryptor.decrypt();
    }
}
