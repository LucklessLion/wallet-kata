package wallet.domain;

public interface ExchangeRateService {

  double getCurrentRate(String sourceType, String targetType);
}
