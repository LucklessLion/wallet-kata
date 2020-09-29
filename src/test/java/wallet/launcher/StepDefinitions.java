package wallet.launcher;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import wallet.domain.ExchangeRateService;
import wallet.domain.StockEvaluator;
import wallet.domain.WalletEvaluator;
import wallet.model.Stock;
import wallet.model.StockType;
import wallet.model.Wallet;

import java.util.HashMap;
import java.util.Map;

public class StepDefinitions {
  private Stock stock;
  private Wallet wallet;
  private StockType type;
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
    this.type = StockType.valueOf(type);
  }

  @Then("I get {double}")
  public void i_get(Double quantity) {
    ExchangeRateService service = new ExchangeRateService() {
      @Override
      public double getCurrentRate(StockType source, StockType target) {
        String exchange = source.name() + "-" + target.name();
        if (rates.containsKey(exchange)) {
          return rates.get(exchange);
        }
        else {
          return 1;
        }
      }
    };
    StockEvaluator valuator = new StockEvaluator(service);
    Assert.assertEquals(quantity, valuator.evaluate(stock, this.type), Double.MIN_VALUE);
  }

  @Given("a wallet containing a stock of {double} {string}")
  public void a_wallet_containing_a_stock_of(Double quantity, String type) {
    this.wallet = new Wallet();
    this.wallet.add(new Stock(StockType.valueOf(type), quantity));
  }

  @Then("I obtain {double}")
  public void i_obtain(Double quantity) {
    ExchangeRateService service = new ExchangeRateService() {
      @Override
      public double getCurrentRate(StockType source, StockType target) {
        String exchange = source.name() + "-" + target.name();
        if (rates.containsKey(exchange)) {
          return rates.get(exchange);
        }
        else {
          return 1;
        }
      }
    };
    WalletEvaluator valuator = new WalletEvaluator(service);
    Assert.assertEquals(quantity, valuator.evaluate(wallet, this.type.name()), Double.MIN_VALUE);
  }

}
