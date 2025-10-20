package calculator;

public class StringCalculator {
    public int add(String input) {
        //공백 문자열 처리
        if (input == null || input.isEmpty()) {
            return 0;
        }

        // 파싱 구현 예정

        // exception 처리
        throw new IllegalArgumentException("Unsupported input for current step");
    }
}
