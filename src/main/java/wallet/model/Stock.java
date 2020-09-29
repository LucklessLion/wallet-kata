package wallet.model;

public class Stock {

  private final StockType type;
  private final double quantity;

  public Stock(StockType type, double quantity) {
    this.type = type;
    this.quantity = quantity;
  }

  public StockType getType() {
    return type;
  }

  public double getQuantity() {
    return quantity;
  }

}
