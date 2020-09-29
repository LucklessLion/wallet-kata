package wallet.model;

public enum StockType {
  Dollar("USD"),
  Euro("EUR"),
  GreatBritainPound("GBP"),
  Bitcoin("BTC"),
  Etherneum("ETC");

  private StockType(String symbol){
    this.symbol = symbol;
  }

  private String symbol;
}
