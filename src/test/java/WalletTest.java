
import exceptions.InvalidAmountToDeposit;
import wallet.Currency;
import wallet.Wallet;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class WalletTest {
    @Test
    void shouldReturnTrueWhenTheMoneyIsDepositedToTheWallet() throws InvalidAmountToDeposit {
        Wallet wallet = new Wallet(0, Currency.Rs);

        assertThat(wallet.deposit(1,Currency.Rs), is(true));
    }
}
