package wallet.domain;

import wallet.model.Stock;
import wallet.model.StockType;
import wallet.model.Wallet;

public interface Evaluator {

  Stock evaluateStock(Stock stock);

  Stock evaluateWallet(Wallet wallet);

  StockType getTargetStockType();
}
