package wallet;

public enum Currency {
    Rs(1),
    $(74.85);

    private final double value;

    Currency(double value) {
        this.value = value;
    }
}
