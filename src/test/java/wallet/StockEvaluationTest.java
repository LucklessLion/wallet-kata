package wallet;

import org.junit.Test;

public class StockEvaluationTest {

  @Test
  public void evaluateASingleStock(){
    StockContext ctx = new StockContext();
    ctx.given_Stock_of(3, "Dollar")
        .when_I_evaluate_it_in("Euro")
        .with_a_rate(2.0)
        .then_I_get(6.0);
  }

  @Test
  public void evaluateAStockInItsOwnType(){
    StockContext ctx = new StockContext();
    ctx.given_Stock_of(15, "Dollar")
        .when_I_evaluate_it_in("Dollar")
        .with_a_rate(1.0)
        .then_I_get(15.0);
  }

}
