package wallet.model;

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

  public List<Stock> getStocks() {
    return stocks;
  }
}
