package lv.javaguru.java2.jg_entertainment;

import lv.javaguru.java2.jg_entertainment.restaurant.core.requests.visitors.Ordering;
import lv.javaguru.java2.jg_entertainment.restaurant.core.requests.visitors.Paging;
import lv.javaguru.java2.jg_entertainment.restaurant.core.requests.visitors.RequestAddVisitor;
import lv.javaguru.java2.jg_entertainment.restaurant.core.requests.visitors.SearchVisitorsRequest;
import lv.javaguru.java2.jg_entertainment.restaurant.core.responses.visitors.SearchVisitorsResponse;
import lv.javaguru.java2.jg_entertainment.restaurant.core.services.services_visitors.SearchVisitorsService;
import lv.javaguru.java2.jg_entertainment.restaurant.core.services.services_visitors.ServiceAddAllVisitors;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AcceptanceSearchTest {

    private ApplicationContextRestaurant appContest = new ApplicationContextRestaurant();

    @Test
    public void shouldReturnCorrectVisitorsList() {
        RequestAddVisitor addVisitor = new RequestAddVisitor("name", "surnameA", 2569874L);
        getAddVisitorService().execute(addVisitor);

        RequestAddVisitor addVisitor1 = new RequestAddVisitor("name", "surnameB", 2569874L);
        getAddVisitorService().execute(addVisitor1);

        RequestAddVisitor addVisitor2 = new RequestAddVisitor("name", "surnameC", 2569874L);
        getAddVisitorService().execute(addVisitor2);

        SearchVisitorsRequest request = new SearchVisitorsRequest("name", null);
        SearchVisitorsResponse response = getSearchVisitorService().execute(request);

        assertEquals(response.getVisitors().size(), 3);
        assertEquals(response.getVisitors().get(0).getClientName(), "name");
        assertEquals(response.getVisitors().get(0).getSurname(), "surnameA");
        assertEquals(response.getVisitors().get(1).getClientName(), "name");
        assertEquals(response.getVisitors().get(1).getSurname(), "surnameB");
        assertEquals(response.getVisitors().get(2).getClientName(), "name");
        assertEquals(response.getVisitors().get(2).getSurname(), "surnameC");
    }

    @Test
    public void shouldOrderingAscendingVisitors() {
        RequestAddVisitor addVisitor = new RequestAddVisitor("name", "surname", 2569874L);
        getAddVisitorService().execute(addVisitor);

        RequestAddVisitor addVisitor1 = new RequestAddVisitor("name", "surnameA", 2569874L);
        getAddVisitorService().execute(addVisitor1);

        Ordering ordering = new Ordering("name", "ASCENDING");
        SearchVisitorsRequest request = new SearchVisitorsRequest("name", null, ordering);
        SearchVisitorsResponse response = getSearchVisitorService().execute(request);

        assertEquals(response.getVisitors().size(), 2);
        assertEquals(response.getVisitors().get(0).getClientName(), "name");
        assertEquals(response.getVisitors().get(0).getSurname(), "surname");
        assertEquals(response.getVisitors().get(1).getClientName(), "name");
        assertEquals(response.getVisitors().get(1).getSurname(), "surnameA");
    }

    @Test
    public void shouldOrderingPagingVisitors() {
        RequestAddVisitor addVisitor = new RequestAddVisitor("name", "surname", 2569874L);
        getAddVisitorService().execute(addVisitor);

        RequestAddVisitor addVisitor1 = new RequestAddVisitor("name", "surnameA", 2569874L);
        getAddVisitorService().execute(addVisitor1);

        Ordering ordering = new Ordering("surname", "ASCENDING");
        Paging paging = new Paging(1, 1);

        SearchVisitorsRequest request = new SearchVisitorsRequest(null, "surname", ordering, paging);
        SearchVisitorsResponse response = getSearchVisitorService().execute(request);

        assertEquals(response.getVisitors().size(), 1);
        assertEquals(response.getVisitors().get(0).getClientName(), "name");
        assertEquals(response.getVisitors().get(0).getSurname(), "surname");

    }

    private ServiceAddAllVisitors getAddVisitorService() {
        return appContest.getBean(ServiceAddAllVisitors.class);
    }

    private SearchVisitorsService getSearchVisitorService() {
        return appContest.getBean(SearchVisitorsService.class);
    }
}