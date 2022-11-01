package onboarding.problem4;

import onboarding.problem4.exception.MessageOutOfSizeException;

public class MessageValidator {
    private static final int MIN_MESSAGE_LENGTH = 1;
    private static final int MAX_MESSAGE_LENGTH = 1_000;

    public void validate(String message) {
        if(!isSatisfiedStringLength(message)) {
            throw new MessageOutOfSizeException();
        }

    }

    private boolean isSatisfiedStringLength(String message) {
        int messageLength = message.length();
        return messageLength >= MIN_MESSAGE_LENGTH && messageLength <= MAX_MESSAGE_LENGTH;
    }


}
