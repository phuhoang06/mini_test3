import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MaterialManager manager = new MaterialManager();

        // Thêm 5 đối tượng bột
        manager.addMaterial(new CrispyFlour( "Bột chiên giòn 1","F001", LocalDate.now(), 50000, 10));
        manager.addMaterial(new CrispyFlour("Bột chiên giòn 2", "F002", LocalDate.now(), 55000, 15));
        manager.addMaterial(new CrispyFlour("Bột chiên giòn 3", "F003", LocalDate.now(), 60000, 20));
        manager.addMaterial(new CrispyFlour("Bột chiên giòn 4", "F004", LocalDate.now(), 65000, 25));
        manager.addMaterial(new CrispyFlour("Bột chiên giòn 5", "F005", LocalDate.now(), 70000, 30));

        // Thêm 5 đối tượng thịt
        manager.addMaterial(new Meat("Thịt bò 1", "M001", LocalDate.now(), 200000, 2.5));
        manager.addMaterial(new Meat("Thịt bò 2", "M002", LocalDate.now(), 210000, 3.0));
        manager.addMaterial(new Meat("Thịt bò 3", "M003", LocalDate.now(), 220000, 3.5));
        manager.addMaterial(new Meat("Thịt bò 4", "M004", LocalDate.now(), 230000, 4.0));
        manager.addMaterial(new Meat("Thịt bò 5", "M005", LocalDate.now(), 240000, 4.5));

        // Hiển thị menu quản lý
        manager.manageMaterials();

        // Tính tổng tiền của 10 vật liệu
        double totalAmount = manager.calculateTotalAmount();
        System.out.println("Tổng tiền của 10 vật liệu: " + totalAmount);

        // Sắp xếp vật liệu theo giá
        manager.sortMaterialsByPrice();
        manager.displayMaterials();

        // Tính số chênh lệch giữa chiết khấu và không chiết khấu
        manager.calculateDiscountDifference();
    }
}
