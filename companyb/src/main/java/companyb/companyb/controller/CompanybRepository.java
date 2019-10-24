package companyb.companyb.controller;

import companyb.companyb.companyData.CustomerDeatail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanybRepository  extends JpaRepository<CustomerDeatail, Integer> {
    List<CustomerDeatail> findByUsername(String username);
}

