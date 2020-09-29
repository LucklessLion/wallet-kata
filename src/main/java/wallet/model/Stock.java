package wallet.model;

public class Stock {

  private final String type;
  private final double quantity;

  public Stock(String type, double quantity) {
    this.type = type;
    this.quantity = quantity;
  }

  public String getType() {
    return type;
  }

  public double getQuantity() {
    return quantity;
  }

}
