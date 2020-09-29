package wallet;

import wallet.domain.ExchangeRateService;
import wallet.model.StockType;

import java.util.HashMap;
import java.util.Map;

public class Context {


  private Map<String, Double> rates;

  protected Context() {
    this.rates = new HashMap<>();
  }

  protected void addAnExchangeRate(String exchange, double rate){
    this.rates.put(exchange, rate);
  }

  protected ExchangeRateService getExchangeRateService(){
    return new ExchangeRateService() {
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
  }

}
