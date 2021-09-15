package lv.javaguru.java2.core.responce.Remove;

import lv.javaguru.java2.core.responce.CoreError;
import lv.javaguru.java2.core.responce.CoreResponse;

import java.util.List;

public class RemoveAdvertismentResponse extends CoreResponse {

    private boolean advertismentRemoved;

    public RemoveAdvertismentResponse(boolean advertismentRemoved) {this.advertismentRemoved = advertismentRemoved;}

    public RemoveAdvertismentResponse(List<CoreError> errors) {super(errors);}

    public boolean isAdvertismentRemoved() {return advertismentRemoved; }

}

