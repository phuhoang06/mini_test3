import java.time.LocalDate;
import java.time.LocalDateTime;

public class CrispyFlour extends Material implements DisCount{
    private int quantity;

    public CrispyFlour() {
    }

    public CrispyFlour(int quantity) {
        this.quantity = quantity;
    }

    public CrispyFlour(String name, String id, LocalDate manufactureDate, int cost, int quantity) {
        super(name, id, manufactureDate, cost);
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public double getAmount() {
        return quantity*getCost();
    }
    public LocalDate getExpiryDate() {
        return getManufactureDate().plusYears(1);
    }
    public double getRealMoney(){
        return getAmount()*0.94;
    }
    @Override
    public String toString() {
        return super.toString() +
                ", Loại: Bột chiên giòn" +
                ", Số lượng: " + quantity +
                ", Thành tiền: " + getAmount();
    }
}
