package wallet.domain;

import wallet.model.Stock;
import wallet.model.StockType;

public class StockEvaluator {

  private ExchangeRateService rateService;

  public StockEvaluator(ExchangeRateService exchangeRateService){
    this.rateService = exchangeRateService;
  }

  public double evaluate(Stock stock, StockType type){
    double rate = rateService.getCurrentRate(stock.getType(), type);
    return stock.getQuantity() * rate;
  }
}
