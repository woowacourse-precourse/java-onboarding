package onboarding;

import onboarding.problem2.CryptoGame;

import java.awt.*;
import java.util.Stack;

public class Problem2 {

    public static String solution(String cryptogram) {
        CryptoGame cryptoGame = new CryptoGame(cryptogram);
        return cryptoGame.remove();
    }

}
