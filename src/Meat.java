import java.time.LocalDate;

public class Meat extends Material implements DisCount{
    private double weight;

    public Meat() {
    }

    public Meat(double weight) {
        this.weight = weight;
    }

    public Meat(String name, String id, LocalDate manufactureDate, int cost, double weight) {
        super(name, id, manufactureDate, cost);
        this.weight = weight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public double getAmount() {
        return getCost() * weight;
    }
    public LocalDate getExpiryDate() {
        return getManufactureDate().plusDays(7);
    }
    public double getRealMoney() {
        return getAmount()*0.97;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Loại: Thịt" +
                ", Trọng lượng: " + weight +
                ", Thành tiền: " + getAmount();
    }
}
