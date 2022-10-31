package onboarding.problem2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecryptorTest {

    Decryptor decryptor;

    @BeforeEach
    public void init() {
        StringMainStack stringMainStack = new StringMainStack();
        StringSubStack stringSubStack = new StringSubStack();
        StackCalculator<StringMainStack, StringSubStack> stackCalculator = new StringStackCalculator();

        decryptor = new StringStackDecryptor(stringMainStack, stringSubStack, stackCalculator);
    }

    @Test
    void 암호해독기_암호해독_성공() throws Exception {
        decryptor.insertCrypto("hello");
        String result = decryptor.decrypt();

        assertThat(result).isEqualTo("heo");
    }
}