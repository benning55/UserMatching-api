package companyb.companyb.controller;

import companyb.companyb.companyData.CustomerDeatail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanybRepository  extends JpaRepository<CustomerDeatail, Integer> {
    List<CustomerDeatail> findByUsername(String username);

    @Query("select cd from CustomerDeatail cd where cd.fname = :first_name and  cd.lname = :last_name")
    List<CustomerDeatail> findByFirstnameAndLastName(@Param("first_name") String first_name,
                                                     @Param("last_name") String last_name);
}

