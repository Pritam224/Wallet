
import exceptions.InsufficientAmount;
import wallet.Money;
import wallet.Wallet;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static wallet.Money.dollar;
import static wallet.Money.rupee;

public class WalletTest {
    @Test
    void shouldReturnTrueWhenTheMoneyIsDepositedToTheWallet() {
        Wallet wallet = new Wallet(0);
        Money oneRupee = rupee(1);

        wallet.deposit(oneRupee);

        assertThat(wallet.checkAmountInRupee(), is(equalTo(oneRupee)));
    }


    @Test
    void shouldReturnTrueWhenTheMoneyIsWithdrawnSuccessfully() throws InsufficientAmount{
        Wallet wallet = new Wallet(0);
        Money seventyNineRupee = rupee(79);
        Money oneDollar = rupee(1);

        wallet.deposit(seventyNineRupee);
        wallet.withdraw(oneDollar);

        assertThat(wallet.checkAmountInRupee(), is(equalTo(rupee(78))));
    }

    @Test
    void ShouldThrowExceptionWhenTheWithdrawalMoneyIsMoreThanTheWalletMoney() {
        Wallet wallet = new Wallet(0);
        Money twoDollar = dollar(2);
        Money twoHundredRupee = rupee(200);

        wallet.deposit(twoDollar);

        assertThrows(InsufficientAmount.class, () -> {
            wallet.withdraw(twoHundredRupee);
        });

    }


}
