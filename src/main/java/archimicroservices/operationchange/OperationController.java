package archimicroservices.operationchange;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OperationController {
    @Autowired
    private Environment environment;
    @Autowired
    private OperationChangeRepository repository;


    @GetMapping("/devise-change/operation")
    public List<OperationChange> retrouveAll
            (){
        return repository.findAll();
    }

    @GetMapping("/devise-change/operation/{id}")
    public Optional<OperationChange> retrouveOperationId
            (@PathVariable Long id){
        return repository.findById(id);
    }

    @PostMapping("/devise-change/operation/create")
    public OperationChange ajoutOperation(@RequestBody OperationChange operationChange){
        return repository.save(operationChange);}

    @PostMapping("/devise-change/operation/modify")
    public OperationChange modifierOperation(@RequestBody OperationChange operationChange){
        return repository.save(operationChange);}

    @PostMapping("/devise-change/operation/delete")
    public void supprimerOperation(@RequestBody OperationChange operationChange){
        repository.delete(operationChange);}

     @PostMapping("/devise-change/operation/createwithouttaux")
    public OperationChange creationSansTaux(@RequestBody OperationChange operationChange) throws Exception {
         HttpURLConnectionTaux http = new HttpURLConnectionTaux();
         double v = http.sendGet(operationChange.getCcySrc(), operationChange.getCcyDest(), operationChange.getDate());
         operationChange.setTrnTaux(v);
         return repository.save(operationChange);
     }


}
