package wallet;

import org.junit.Assert;
import wallet.domain.StockValuator;
import wallet.model.Stock;

class StockContext {
  private Stock stock;
  private String type;
  private double rate;

  StockContext given_Stock_of(double quantity, String type){
    this.stock = new Stock(type, quantity);
    return this;
  }
  StockContext when_I_evaluate_it_in(String type){
    this.type = type;
    return this;
  }

  StockContext with_a_rate(double rate){
    this.rate = rate;
    return this;
  }

  void then_I_get(double quantity){
    StockValuator valuator = new StockValuator((src, target) ->{ return rate;});
    Assert.assertEquals(quantity, valuator.evaluate(stock, this.type), Double.MIN_VALUE);
  }
}
