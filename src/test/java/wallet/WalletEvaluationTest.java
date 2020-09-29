package wallet;

import org.junit.Test;

public class WalletEvaluationTest {

  @Test
  public void evaluateEmptyWallet(){
    WalletContext context = new WalletContext();
    context.given_a_wallet()
        .when_I_evaluate_it_in("Euro")
        .then_I_get(0.0);
  }

  @Test
  public void evaluateAWalletWithOneStockType(){
    WalletContext context = new WalletContext();
    context.given_a_wallet()
        .with_a_stock(5, "Dollar")
        .when_I_evaluate_it_in("Euro")
        .and_an_exchange_rate("Dollar-Euro", 0.8)
        .then_I_get(4.0);
  }


  @Test
  public void evaluateAWalletWithTwoStocks(){
    WalletContext context = new WalletContext();
    context.given_a_wallet()
            .with_a_stock(1, "Dollar").and_an_exchange_rate("Dollar-Euro", 0.8)
            .with_a_stock(1, "Bitcoin").and_an_exchange_rate("Bitcoin-Euro", 9014.00)
            .when_I_evaluate_it_in("Euro")
            .then_I_get(9014.80);
  }
}
