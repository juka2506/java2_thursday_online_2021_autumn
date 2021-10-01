package lv.javaguru.java2.qwe.core.database;

import lv.javaguru.java2.qwe.Bond;
import lv.javaguru.java2.qwe.Security;
import lv.javaguru.java2.qwe.Stock;
import lv.javaguru.java2.qwe.core.requests.data_requests.FilterStocksByMultipleParametersRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface Database {

    ArrayList<Security> getSecurityList();

    String getStringForTest();

    int getNumberForTest();

    void addStock(Stock stock);

    void addBond(Bond bond);

    boolean removeSecurity(String name);

    List<Security> getAllSecurityList();

    Optional<Security> findSecurityByName(String name);

    List<Security> filterStocksByMultipleParameters(List<Security> list,
                                                    FilterStocksByMultipleParametersRequest request, int i);

}