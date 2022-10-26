package onboarding.problem3;

import onboarding.problem2.TextDecoder;
import onboarding.problem2.TextDecoderV1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Clap369GameTest {

    @Test
    void test100() {
        Clap369Game game = new Clap369Game(100);

        assertEquals(60, game.getResult());
    }

    @Test
    void test1000() {
        Clap369Game game = new Clap369Game(1000);

        assertEquals(900, game.getResult());
    }

    @Test
    void test10000() {
        Clap369Game game = new Clap369Game(10000);

        assertEquals(12000, game.getResult());
    }
}