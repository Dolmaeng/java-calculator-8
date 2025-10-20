package calculator;

import java.util.regex.Pattern;

public class StringCalculator {

    private static final Pattern DEFAULT_DELIMS = Pattern.compile("[,:]");

    public int add(String input) {
        //공백 문자열 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 파싱
        String[] tokens = DEFAULT_DELIMS.split(input);
        return sumTokens(tokens);

//        // exception 처리
//        throw new IllegalArgumentException("Unsupported input for current step");
    }

    private int sumTokens(String[] tokens) {
        if (tokens.length == 0) {
            throw new IllegalArgumentException("tokens의 길이가 0입니다.");
        }
        int sum = 0;
        for (String token : tokens) {
            if (token.isEmpty()) {
                throw new IllegalArgumentException("token이 비었습니다.");
            }

            if (!token.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException("Non-numeric 토큰: " + token);
            }

            int value = Integer.parseInt(token);

            if (value <= 0) {
                throw new IllegalArgumentException("양수가 아닌 토큰: " + token);
            }

            sum += value;
        }
        return sum;
    }


}
