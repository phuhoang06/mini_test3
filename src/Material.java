import java.io.Serializable;
import java.time.LocalDate;

public abstract class Material  {
    private String name;
    private String id;
    private LocalDate manufactureDate;
    private int cost;



    public Material() {
    }

    public Material(String name, String id, LocalDate manufactureDate, int cost) {
        this.name = name;
        this.id = id;
        this.manufactureDate = manufactureDate;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(LocalDate manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public abstract double getAmount();
    public abstract LocalDate getExpiryDate();

    @Override
    public String toString() {
        return "ID: " + id +
                ", Tên: " + name +
                ", Ngày sản xuất: " + manufactureDate +
                ", Giá: " + cost;
    }

    // Các phương thức abstract
}

