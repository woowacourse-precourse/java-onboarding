package onboarding.problem2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class cryptoGameTest {

    @Test
    void findDuplicate() {
        String cryptogram = "browoanoommnaon";
        String result = "brown";
        assertThat(CryptoGame.start(cryptogram)).isEqualTo(result);
    }

    @Test
    void case2() {
        String cryptogram = "zyelleyz";
        String result = "";
        assertThat(CryptoGame.start(cryptogram)).isEqualTo(result);
    }

    @Test
    void case3() {
        String cryptogram = "aaabdddc";
        String result = "bc";
        assertThat(CryptoGame.start(cryptogram)).isEqualTo(result);
    }
    @Test
    void if_capital_letter() {
        String cryptogram = "aAbBBCC1!";
        assertThrows(CryptoException.class, () -> CryptoGame.start(cryptogram));
    }


    @Test
    void if_under_MIN() {
        String cryptogram = "";
        assertThrows(CryptoException.class, () -> CryptoGame.start(cryptogram));
    }

    @Test
    void if_over_MAX() {
        String cryptogram = "t89CrBAlZ0EwrrTcrczGijGzJDvQK3Pl1YeJcQ1swn" +
                "Z0dvoadd0RtojzK4HoP2GqgCtXAlP6NROoTOr83sSO1W" +
                "ur6naer48DKYZp5hOJNxflRxN1nxGXTDiJ1Z4Jr8iZEgj92gpdcJyEx" +
                "dXhLv26Vpxexy8JX2rikArkfxJpPKVp1ZWdatUkivefvzqlQkiDvbsQpnDJ1T" +
                "kvYBFxJS7xM3yxLJcsMoSIUHEcL1uoMDXZkpGo0gk4Pj9dL1smvfSivo7" +
                "pmfTJh6K9gLOxm7ER1hKro0N00n" +
                "6cngo0rdsW5WZ1zYmlniuqG24bute121rhTGNtQCmktWjzgUJhlrPjiwoqOAS3" +
                "uTZE5TVbcZNDmITVYumntfRtXQGdHAkvZKR316BPFlbs5HU" +
                "dep016XJE1ZxccXyJJ9Ey477WDBEXKOEIsXqDClxxH5VaW6CSGvMgVeR1WFRb5S8ls3rg1du" +
                "lo8Y6J0DMIp5YMXZlAl01FJdBFbRoAMYEYjtD6351J1d39NFnSAVhfAN9e180HcNE8O5PehN" +
                "oQnLD7ZPQsEJnErVCau5Lv6O1vckfmYeC2Evvk6Rs9DrGTkDih96ZDp0uhypErbq25DawRfdEo" +
                "T44Q5VW7wGFk6jM4K5keTAyTbeJTgUDe7yCYQraYBfnJETzaznqr65yhOpoWugupzI6qCvfuK9jh" +
                "vDhOkgpzP9bdGOr7Cwoc8waVGFs1XcuUDPDFueTdtkLDUTAYTebqcz2D1dYS6OSd" +
                "x9dgWFaahfzOcwPtx7jifdkCeJCB9qW9Y2njYjRYWKqmpD03K" +
                "MbDiaIgDT3Hzreo3iZYDyngDPUmWDBXn7mbHfnluDXHpr8p5fAyR4k9blMUlqYt" +
                "z7MbDvuDL2UChefWG9iLM7yOrHnoEB4wJ7NeP5pYoExSM0kQQ0pBCdnQ9tM2x5Rw76D9WGs3FeTg" +
                "a42sT05UNnuIfVwIdEwU1j0IBGCNVxCgwzd0fVtKghT" +
                "mh9zlrnwqQtLScE0i";
        assertThrows(CryptoException.class, () -> CryptoGame.start(cryptogram));
    }
}
