
import exceptions.InsufficientAmount;
import exceptions.EnteredInvalidAmount;
import wallet.Currency;
import wallet.Wallet;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {
    @Test
    void shouldReturnTrueWhenTheMoneyIsDepositedToTheWallet() throws EnteredInvalidAmount {
        Wallet wallet = new Wallet();

        assertThat(wallet.deposit(1, Currency.Rs), is(true));
    }

    @Test
    void shouldThrowExceptionWhenTheDepositAmountIsInvalid() {
        Wallet wallet = new Wallet();

        assertThrows(EnteredInvalidAmount.class, () -> {
            wallet.deposit(-2, Currency.Rs);
        });
    }

    @Test
    void shouldReturnTrueWhenTheAmountIsWithdrawnSuccessfully() throws InsufficientAmount, EnteredInvalidAmount {
        Wallet wallet = new Wallet();
        wallet.deposit(79, Currency.Rs);

        assertThat(wallet.withdraw(1, Currency.$), is(true));
    }

    @Test
    void ShouldThrowExceptionWhenTheWithdrawalAmountIsMoreThanTheAvailableAmount() throws EnteredInvalidAmount {
        Wallet wallet = new Wallet();
        wallet.deposit(2, Currency.$);

        assertThrows(InsufficientAmount.class, () -> {
            wallet.withdraw(190, Currency.Rs);
        });

    }


}
