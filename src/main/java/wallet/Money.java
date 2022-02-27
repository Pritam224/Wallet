package wallet;

public class Money {
    private double value;
    private Currency currency;

    private Money(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null)
            return false;
        Money money = (Money)object;
        return money.value == this.value && money.currency == this.currency;
    }

    public static Money rupee(double value)
    {
        return new Money(value, Currency.Rs);
    }

    public static Money dollar(double value)
    {
        return new Money(value, Currency.$);
    }

    Double inRupee() {
        return value* currency.getConversionValue();
    }
}
