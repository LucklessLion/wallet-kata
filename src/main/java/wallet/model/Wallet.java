package wallet.model;

import wallet.domain.Evaluator;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

  private List<Stock> stocks;

  public Wallet() {
    this.stocks = new ArrayList<>();
  }

  public void add(Stock stock) {
    this.stocks.add(stock);
  }

  public Stock accept(Evaluator evaluator){
    Stock none = new Stock(evaluator.getTargetStockType(), 0);
    return this.stocks
            .stream()
            .map(s -> { return evaluator.evaluateStock(s); })
            .reduce(none, (subtotal, stock) ->
            {
              return new Stock(subtotal.getType(), subtotal.getQuantity()+stock.getQuantity());
            });
  }

}
