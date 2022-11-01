package onboarding;

public class Problem3 {

    static byte[] saveByDigit = new byte[5];
    public static int solution(int number) {
        if (numberOutOfRangeException(number)) {
            return number;
        }
        return countClapCase(number);
    }

    public static int countClapCase(int number) {
        int sum = 0;
        int currentDigitValue;
        for (int i = 0; i < saveByDigit.length; i++) {
            currentDigitValue = number / (int) Math.pow(10, (4 - i));
            saveByDigit[i] = (byte) currentDigitValue;
            number %= (int) Math.pow(10, (4 - i));
            if (saveByDigit[i] != 0 && saveByDigit[i] % 3 == 0 && i != 4) {
                sum += number + 1;
            }
        }
        sum += saveByDigit[0] * tenThousand() + calculateThousandsClapCase(saveByDigit[1]) +
                calculateHundredsClapCase(saveByDigit[2]) + calculateTensClapCase(saveByDigit[3]) +
                calculateOnesClapCase(saveByDigit[4]);
        return sum;
    }
    public static int generalTensDigit() {
        return 3;    // 3,6,9
    }

    public static int specificTensDiigt() {
        return generalTensDigit() + 10;
    }

    public static int generalHundreds() {
        return 7 * generalTensDigit() + 3 * specificTensDiigt();
    }

    public static int specificHundreds() {
        return generalHundreds() + 100;
    }

    public static int generalThousands() {
        return 7 * generalHundreds() + 3 * specificHundreds();
    }
    public static int specificThousands() {
        return generalThousands() + 1000;
    }

    public static int tenThousand() {
        return 7 * generalThousands() + 3 * specificThousands();
    }

    public static int calculateOnesClapCase(int oneNumber) {
        return oneNumber / 3;
    }

    public static int calculateTensClapCase(int tenNumber) {
        int specificTenNumber = (tenNumber - 1) / 3;
        return (tenNumber - specificTenNumber) * generalTensDigit() +
                specificTenNumber * specificTensDiigt();
    }

    public static int calculateHundredsClapCase(int hundredNumber) {
        int specificHundredNumber = (hundredNumber - 1) / 3;
        return (hundredNumber - specificHundredNumber) * generalHundreds() +
                specificHundredNumber * specificHundreds();
    }

    public static int calculateThousandsClapCase(int thousandNumber) {
        int specificThousandNumber = (thousandNumber - 1) / 3;
        return (thousandNumber - specificThousandNumber) * generalThousands() +
                specificThousandNumber * specificThousands();
    }

}