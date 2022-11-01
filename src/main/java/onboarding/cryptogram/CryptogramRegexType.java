package onboarding.cryptogram;

public final class CryptogramRegexType {

	public static final String FORMAT_MATCH_REGEX = "^[a-z]+$";

	public static final String REPEATED_MATCH_REGEX = ".*(\\w)\\1+.*";

	public static final String REPEATED_REMOVAL_REGEX = "(\\w)\\1+";
}
