package wallet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import wallet.domain.StockEvaluator;
import wallet.model.Stock;
import wallet.model.StockType;

class StockContext extends Context {
  private Stock stock;
  private StockType target;

  StockContext given_Stock_of(double quantity, String type){
    this.stock = new Stock(StockType.valueOf(type), quantity);
    return this;
  }

  StockContext when_I_evaluate_it_in(String type){
    this.target = StockType.valueOf(type);
    return this;
  }

  @Given("a exchange rate {string} at {double}")
  StockContext with_a_rate(String exchange, double rate){
    super.addAnExchangeRate(exchange, rate);
    return this;
  }

  @Then("I get {double}")
  void then_I_get(double quantity){
    StockEvaluator valuator = new StockEvaluator(super.getExchangeRateService());
    Assert.assertEquals(quantity, valuator.evaluate(stock, this.target), Double.MIN_VALUE);
  }
}
