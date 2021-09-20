package lv.javaguru.java2.services.Add;


import lv.javaguru.java2.Specialist;
import org.mockito.ArgumentMatcher;

public class SpecialistMatcher implements ArgumentMatcher<Specialist> {
    String name;
    String surname;
    String profession;

    public SpecialistMatcher(String name, String surname, String profession) {
        this.name = name;
        this.surname = surname;
        this.profession = profession;
    }

    @Override
    public boolean matches(Specialist specialist) {
        return specialist.getSpecialistName().equals(name) && specialist.getSpecialistSurname().equals(surname) &&
                specialist.getSpecialistProfession().equals(profession);
    }
}

