package nextstep.utils;

public class StringUtils {

    private static final String DEFAULT_FILL = "-";

    public static String padLeft(String input, int length) {
        return padLeft(input, DEFAULT_FILL, length);
    }

    public static String padLeft(String input, String fill, int length) {
        if (input.length() >= length) {
            return input;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length - input.length()) {
            sb.append(fill);
        }
        sb.append(input);

        return sb.toString();
    }

}
