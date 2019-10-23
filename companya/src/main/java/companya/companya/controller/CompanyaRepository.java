package companya.companya.controller;

import companya.companya.companyData.CustomerDeatail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyaRepository extends JpaRepository<CustomerDeatail, Integer> {
    List<CustomerDeatail> findByUsername(String username);
}
