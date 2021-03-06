package wallet;

import org.junit.Assert;
import wallet.domain.GlobalEvaluator;
import wallet.model.Stock;
import wallet.model.StockType;
import wallet.model.Wallet;

class WalletContext extends Context {
  private Wallet wallet;
  private String type;

  WalletContext given_a_wallet(){
    this.wallet = new Wallet();
    return this;
  }

  WalletContext when_I_evaluate_it_in(String type){
    this.type = type;
    return this;
  }

  WalletContext with_a_stock(double quantity, String type){
    this.wallet.add(new Stock(StockType.valueOf(type), quantity));
    return this;
  }

  WalletContext and_an_exchange_rate(String exchange, double rate){
    super.addAnExchangeRate(exchange, rate);
    return this;
  }

  void then_I_get(double quantity){
    GlobalEvaluator evaluator = new GlobalEvaluator(getExchangeRateService(), StockType.valueOf(this.type));
    Assert.assertEquals(quantity, evaluator.evaluateWallet(wallet).getQuantity(), Double.MIN_VALUE);
  }
}
