package wallet.domain;

import wallet.model.StockType;
import wallet.model.Wallet;

public class WalletEvaluator {


  private StockEvaluator evaluator;

  public WalletEvaluator(ExchangeRateService exchangeRateService){
    this.evaluator = new StockEvaluator(exchangeRateService);
  }

  public double evaluate(Wallet wallet, String type){
    StockType stockType = StockType.valueOf(type);
    return wallet
            .getStocks()
            .stream()
            .mapToDouble(stock -> this.evaluator.evaluate(stock, stockType)).sum();
  }

}
