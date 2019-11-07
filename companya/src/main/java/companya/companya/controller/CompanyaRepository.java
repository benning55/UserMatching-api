package companya.companya.controller;

import companya.companya.companyData.CustomerDeatail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyaRepository extends JpaRepository<CustomerDeatail, Integer> {
    List<CustomerDeatail> findByUsername(String username);

    @Query("select cd from CustomerDeatail cd where cd.first_name = :first_name and  cd.last_name = :last_name")
    List<CustomerDeatail> findByFirstnameAndLastName(@Param("first_name") String first_name,
                                                     @Param("last_name") String last_name);
}
