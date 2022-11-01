package onboarding;

public class Problem3 {
    private static final int CLAP_COUNT_UNDER_ONE = 0;
    private static final int CLAP_COUNT_UNDER_TEN = 3;
    private static final int CLAP_COUNT_UNDER_HUNDRED = (CLAP_COUNT_UNDER_TEN * 10) + (3 * 10);          // 60
    private static final int CLAP_COUNT_UNDER_THOUSAND = (CLAP_COUNT_UNDER_HUNDRED * 10) + (3 * 100);      // 900
    private static final int CLAP_COUNT_UNDER_TEN_THOUSANDS = (CLAP_COUNT_UNDER_THOUSAND * 10) + (3 * 1000);  // 12000
    private static final int[] clapCountUnits = {CLAP_COUNT_UNDER_ONE, CLAP_COUNT_UNDER_TEN, CLAP_COUNT_UNDER_HUNDRED, CLAP_COUNT_UNDER_THOUSAND, CLAP_COUNT_UNDER_TEN_THOUSANDS};

    public static int solution(int number) {
        assert (number >= 1 && number <= 10000);

        int clapCount = 0;

        int digitOffset = 0;            // 오른쪽으로부터 '몇 칸' 떨어져 있는 자릿수인지를 나타내는 값 (예: 1의 자리는 '오른쪽으로부터 0칸 떨어진' 자리, 10의 자리는 '오른쪽으로부터 1칸 떨어진 자리'로 한다)
        int valueUnderCurrentDigit = 0; // 현재 살펴보는 자릿수 미만 자리들의 값 (예: 399이고 백의 자리를 살펴보고 있다면, 이 값은 99, 303이며 백의 자리를 살펴보고 있다면, 이 값은 3)
        int digitValue;                 // 각 자리의 수를 나타내는 값 (0, 1, 2, 3, ... , 7, 8, 9)

        while (number > 0) {

            digitValue = number % 10;

            if ((digitValue / 3) >= 1) {
                clapCount += (Math.ceil((double) digitValue / 3) - 1) * (int) Math.pow(10, digitOffset);
            }

            clapCount += digitValue * Problem3.clapCountUnits[digitOffset];

            if (digitValue != 0 && digitValue % 3 == 0) {
                clapCount += (valueUnderCurrentDigit + 1);
            }

            valueUnderCurrentDigit += (digitValue * (int) Math.pow(10, digitOffset));
            number = number / 10;

            digitOffset++;
        }

        return clapCount;
    }
}
