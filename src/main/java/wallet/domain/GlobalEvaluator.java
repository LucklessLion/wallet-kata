package wallet.domain;

import wallet.model.Stock;
import wallet.model.StockType;
import wallet.model.Wallet;

public class GlobalEvaluator implements Evaluator {

  private ExchangeRateService rateService;
  private StockType target;

  public GlobalEvaluator(ExchangeRateService service, StockType target){
    this.rateService = service;
    this.target = target;
  }

  @Override
  public Stock evaluateStock(Stock stock) {
    return new Stock(target, this.rateService.getCurrentRate(stock.getType(), target) * stock.getQuantity());
  }

  @Override
  public Stock evaluateWallet(Wallet wallet) {
    return wallet.accept(this);
  }

  @Override
  public StockType getTargetStockType() {
    return this.target;
  }
}
