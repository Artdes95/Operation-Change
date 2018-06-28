package archimicroservices.operationchange;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OperationChangeRepository extends JpaRepository<OperationChange, Long> {


    Optional<OperationChange> findById(Long id);

}
