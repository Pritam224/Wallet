package wallet;

import exceptions.InsufficientAmount;
import exceptions.EnteredInvalidAmount;

public class Wallet {

    private double TotalAmountInRupee = 0;


    public boolean deposit(double value, Currency currency) throws EnteredInvalidAmount {
        if (value <= 0) {
            throw new EnteredInvalidAmount();
        }
        TotalAmountInRupee += value * currency.getConversionValue();

        return true;
    }


    public boolean withdraw(double value, Currency currency) throws InsufficientAmount, EnteredInvalidAmount {
        if (value <= 0) {
            throw new EnteredInvalidAmount();
        }
        if (TotalAmountInRupee < value * currency.getConversionValue()) {
            throw new InsufficientAmount();
        }

        TotalAmountInRupee -= value * currency.getConversionValue();
        return true;
    }
}
