package wallet;

import exceptions.InsufficientAmount;

import static wallet.Money.dollar;
import static wallet.Money.rupee;

public class Wallet {

    private double totalAmountInRupee;

    public Wallet(double totalAmountInRupee) {
        this.totalAmountInRupee = totalAmountInRupee;
    }

    public void deposit(Money money) throws EnteredInvalidAmount {
        if (money.inRupee() <= 0) {
            throw new EnteredInvalidAmount();
        }
        totalAmountInRupee += money.inRupee();

    }

    public void withdraw(Money money) throws InsufficientAmount {

        if (totalAmountInRupee < money.inRupee()) {
            throw new InsufficientAmount();
        }

        totalAmountInRupee -= money.inRupee();
    }


    public Money checkAmountInRupee() {
        return rupee(totalAmountInRupee / Currency.Rs.getConversionValue());
    }

    public Money checkAmountInDollar() {
        return dollar(totalAmountInRupee / Currency.$.getConversionValue());
    }
}
