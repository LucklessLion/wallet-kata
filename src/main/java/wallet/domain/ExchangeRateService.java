package wallet.domain;

import wallet.model.StockType;

public interface ExchangeRateService {

  double getCurrentRate(StockType source, StockType target);
}
