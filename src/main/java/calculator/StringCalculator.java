package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern DEFAULT_DELIMS = Pattern.compile("[,:]");
    private static final Pattern CUSTOM_HEADER = Pattern.compile("^//(.)\\n(.*)$", Pattern.DOTALL);

    public int add(String input) {
        // Null 문자열은 0 반환
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        Matcher m = CUSTOM_HEADER.matcher(input);
        if (m.matches()) {
            String delim = m.group(1);
            String body = m.group(2);
            if (body == null || body.trim().isEmpty()) {
                return 0;
            }
            String regex = Pattern.quote(delim);
            String[] tokens = body.split(regex, -1);
            return sumTokens(tokens);
        }

        // '//'로 시작하나 커스텀 구분자 문법이 잘못 됐을 때
        if (input.startsWith("//")) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 잘못됐습니다.");
        }

        String[] tokens = DEFAULT_DELIMS.split(input, -1);
        return sumTokens(tokens);
    }

    private int sumTokens(String[] tokens) {
        if (tokens.length == 0) {
            throw new IllegalArgumentException("tokens가 비어있음");
        }
        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException("token이 비어있음");
            }
            if (!token.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException("숫자가 아닌 token: " + token);
            }
            int value = Integer.parseInt(token);
            if (value <= 0) {
                throw new IllegalArgumentException("양수가 아닌 number: " + token);
            }
            sum += value;
        }
        return sum;
    }
}
