package wallet;

import exceptions.InvalidAmountToDeposit;

public class Wallet {
    private final double value;
    private final Currency currency;
    private double TotalAmountInDollar = 0;
    private double TotalAmountInRupee = 0;

    public Wallet(double value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    public boolean deposit(double value, Currency currency) throws InvalidAmountToDeposit {
        if (value <= 0) {
            throw new InvalidAmountToDeposit();
        }
        if (currency == Currency.$) {
            TotalAmountInDollar += value;
        } else {
            TotalAmountInRupee += value;
        }
        return true;
    }


}
