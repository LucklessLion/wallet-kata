package wallet.domain;

import wallet.model.Wallet;

public class WalletEvaluator {


  private StockEvaluator evaluator;

  public WalletEvaluator(ExchangeRateService exchangeRateService){
    this.evaluator = new StockEvaluator(exchangeRateService);
  }

  public double evaluate(Wallet wallet, String type){
    return wallet
            .getStocks()
            .stream()
            .mapToDouble(stock -> this.evaluator.evaluate(stock, type)).sum();
  }

}
