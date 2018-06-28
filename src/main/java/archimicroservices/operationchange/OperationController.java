package archimicroservices.operationchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class OperationController {
    @Autowired
    private Environment environment;
    @Autowired
    private OperationChangeRepository repository;


    @GetMapping("/devise-change/operation/get/{id}")
    public String retrouveOperationId
            (@PathVariable Long id){
        Optional<OperationChange> op = repository.findById(id);
        return op.toString();
    }
}
