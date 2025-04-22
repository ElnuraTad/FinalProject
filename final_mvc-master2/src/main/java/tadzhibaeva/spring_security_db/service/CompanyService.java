package tadzhibaeva.spring_security_db.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tadzhibaeva.spring_security_db.entity.Company;
import tadzhibaeva.spring_security_db.repo.CompanyRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;

    public List<Company> getAllCompany() {
        return companyRepository.findAll();
    }

    public void save(Company company) {
        companyRepository.save(company);
    }

    public Company getById(Long id) {
        return companyRepository.findById(id).get();
    }

    public void delete(Long id) {
        companyRepository.deleteById(id);
    }
}
