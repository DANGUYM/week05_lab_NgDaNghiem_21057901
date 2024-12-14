package vn.edu.iuh.fit.backend.models.dto;

import com.neovisionaries.i18n.CountryCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyForm {
    private String compName;
    private String email;
    private String phone;
    private String webUrl;
    private AddressForm address;
    private String about;

    public CompanyForm() {
        this.address = new AddressForm();
    }

    @Getter
    @Setter
    public static class AddressForm {
        private String street;
        private String city;
        private CountryCode country;
        private String zipcode;
        private String number;
    }
}
