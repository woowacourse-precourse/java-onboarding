package onboarding.problem6;

import java.util.Collections;
import java.util.List;

public class Constant {
    static final int INPUT_MIN_SIZE = 1;
    static final int INPUT_MAX_SIZE = 10000;
    static final int NAME_MIN_LENGTH = 1;
    static final int NAME_MAX_LENGTH = 19;
    static final int EMAIL_MIN_LENGTH = 11;
    static final int EMAIL_MAX_LENGTH = 19;
    static final String KOREAN_REGEX = "^[가-힇]*$";
    static final String EMAIL_REGEX = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
    static final String EMAIL_DOMAIN = "email.com";
    static final List<String> EXCEPTION = Collections.emptyList();

}
