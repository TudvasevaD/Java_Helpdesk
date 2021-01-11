package sai.daria.helpdesk.repo;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import sai.daria.helpdesk.entities.Request;

import java.util.List;
import java.util.Optional;

@Repository
@Component
public interface RequestRepository extends JpaRepository<Request,Integer> {

    @Query("from Request")
    public List<Request> findStudents(Pageable page);

    Optional<Request> findByUsername(String username);

    @Query("from Request r " +
            "where lower(r.status) like lower(:mask) or " +
            "lower(r.theme) like lower(:mask) or " +
            "lower(r.user) like lower(:mask) or " +
            "lower(r.rdate) like lower(:mask) ")
    public List<Request> findStudents(@Param("mask") String mask, Pageable page);

}
