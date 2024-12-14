package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Address;

import java.util.List;
import java.util.Optional;

public interface AddressServices {
    List<Address> getAllAddresses();
    Optional<Address> getAddressById(Long id);
    Address createAddress(Address address);
    Address updateAddress(Address address);
    void deleteAddress(Long id);
}
