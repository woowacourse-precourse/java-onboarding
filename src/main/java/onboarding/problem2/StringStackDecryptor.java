package onboarding.problem2;

public class StringStackDecryptor implements Decryptor{

    private final StringMainStack stringMainStack;
    private final StringSubStack stringSubStack;
    private final StackCalculator<StringMainStack, StringSubStack> stackCalculator;

    public StringStackDecryptor(StringMainStack stringMainStack,
        StringSubStack stringSubStack,
        StackCalculator<StringMainStack, StringSubStack> stackCalculator) {
        this.stringMainStack = stringMainStack;
        this.stringSubStack = stringSubStack;
        this.stackCalculator = stackCalculator;
    }

    @Override
    public String decrypt() {
        while(this.stackCalculator.deleteDuplicatedCharacter(this.stringMainStack, this.stringSubStack)) {
            this.stringMainStack.pushString(this.stringSubStack.makeString());
        }

        return this.stringSubStack.makeString();
    }

    @Override
    public void insertCrypto(String crypto) {
        this.stringMainStack.pushString(crypto);
    }
}
