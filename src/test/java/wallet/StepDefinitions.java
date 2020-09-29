package wallet;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import wallet.domain.ExchangeRateService;
import wallet.domain.StockEvaluator;
import wallet.model.Stock;
import wallet.model.StockType;

import java.util.HashMap;
import java.util.Map;

public class StepDefinitions {
  private Stock stock;
  private String type;
  private Map<String, Double> rates = new HashMap<>();


  @Given("a stock of {double} {string}")
  public void a_stock_of(Double quantity, String type) {
    this.stock = new Stock(StockType.valueOf(type), quantity);
  }

  @Given("a exchange rate {string} at {double}")
  public void a_exchange_rate_at(String exchange, Double rate) {
    this.rates.put(exchange, rate);
  }

  @When("I evaluate it in {string}")
  public void i_evaluate_it_in(String type) {
    this.type = type;
  }

  @Then("I get {double}")
  public void i_get(Double quantity) {
    ExchangeRateService service = new ExchangeRateService() {
      @Override
      public double getCurrentRate(StockType source, StockType target) {
        String exchange = source + "-" + target;
        if (rates.containsKey(exchange)) {
          return rates.get(exchange);
        }
        else {
          return 1;
        }
      }
    };
    StockEvaluator valuator = new StockEvaluator(service);
    Assert.assertEquals(quantity, valuator.evaluate(stock, StockType.valueOf(this.type)), Double.MIN_VALUE);
  }

}
