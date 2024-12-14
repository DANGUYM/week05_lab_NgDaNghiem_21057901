package vn.edu.iuh.fit.backend.services;

import vn.edu.iuh.fit.backend.models.Company;

import java.util.List;
import java.util.Optional;


public interface CompanyServices {
    List<Company> getAllCompanies();
    Optional<Company> getCompanyById(Long id);
    Company createCompany(Company company);
    Company updateCompany(Long id, Company companyDetails);
    void deleteCompany(Long id);

    Optional<Company> findByEmail(String email);

    boolean existsByEmail(String email);
}
