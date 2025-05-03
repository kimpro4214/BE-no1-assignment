package LV3;

public enum OperatorType {
    PLUS('+'), MINUS('-'), MULTIPLY('*'), DIVIDE('/');

    private final char symbol;

    OperatorType(char symbol) {
        this.symbol = symbol;
    }

    public static OperatorType fromChar(char ch) {
        for (OperatorType op : values()) {
            if (op.symbol == ch) return op;
        }
        throw new IllegalArgumentException("올바르지 않은 연산자입니다: " + ch);
    }

    public char getSymbol() {
        return symbol;
    }
}
