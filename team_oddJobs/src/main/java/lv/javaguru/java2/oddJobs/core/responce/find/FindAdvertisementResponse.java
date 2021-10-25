package lv.javaguru.java2.oddJobs.core.responce.find;

import lv.javaguru.java2.oddJobs.core.responce.CoreError;
import lv.javaguru.java2.oddJobs.core.responce.CoreResponse;
import lv.javaguru.java2.oddJobs.domain.Advertisement;

import java.util.List;

public class FindAdvertisementResponse extends CoreResponse {

    private List<Advertisement> advertisements;

    public FindAdvertisementResponse(List<CoreError> errors, List<Advertisement> advertisements) {
        super(errors);
        this.advertisements = advertisements;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }
}