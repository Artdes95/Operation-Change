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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTauxChange() {
        return idTauxChange;
    }

    public void setIdTauxChange(Long idTauxChange) {
        this.idTauxChange = idTauxChange;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCcySrc() {
        return ccySrc;
    }

    public void setCcySrc(String ccySrc) {
        this.ccySrc = ccySrc;
    }

    public String getCcyDest() {
        return ccyDest;
    }

    public void setCcyDest(String ccyDest) {
        this.ccyDest = ccyDest;
    }

    public double getTrnTaux() {
        return trnTaux;
    }

    public void setTrnTaux(double trnTaux) {
        this.trnTaux = trnTaux;
    }
}
