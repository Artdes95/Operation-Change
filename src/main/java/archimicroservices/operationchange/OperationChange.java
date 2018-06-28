package archimicroservices.operationchange;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity

public class OperationChange {

    @Id
    private Long id;
    private Long  idTauxChange;
    private double amount;
    private String date;
    private String ccySrc;
    private String ccyDest;
    private double trnTaux;

    @Override
    public String toString() {
        return String.format(
                "Operation number : id=%d, %f '%s'/'%s'= %f ('%s')",
                id, amount, ccySrc, ccyDest, trnTaux, date);
    }
}
