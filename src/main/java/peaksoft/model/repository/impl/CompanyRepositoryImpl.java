package peaksoft.model.repository.impl;

import org.springframework.stereotype.Repository;
import peaksoft.model.model.Company;
import peaksoft.model.repository.CompanyRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Repository
@Transactional
public class CompanyRepositoryImpl implements CompanyRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Company> getAllCompanies() {
        return entityManager
                .createQuery("select c from Company c", Company.class)
                .getResultList();
    }

    @Override
    public void saveCompany(Company company) {
        entityManager.persist(company);

    }

    @Override
    public Company getCompanyById(Long id) {
        return entityManager.find(Company.class, id);
    }

    @Override
    public void updateCompany(Company company) {
        entityManager.merge(company);

    }

    @Override
    public void removeCompany(Company company) {
        entityManager.remove(entityManager.contains(company) ? company : entityManager.merge(company));

    }
}
