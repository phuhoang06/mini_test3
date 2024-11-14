import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;
public class MaterialManager {
    private List<Material> materials;

    public MaterialManager() {
        materials = new ArrayList<>();
    }

    // Phương thức thêm vật liệu
    public void addMaterial(Material material) {
        materials.add(material);
    }

    // Phương thức sửa vật liệu
    public void updateMaterial(String id, Material newMaterial) {
        for (int i = 0; i < materials.size(); i++) {
            if (materials.get(i).getId().equals(id)) {
                materials.set(i, newMaterial);
                System.out.println("Cập nhật vật liệu thành công.");
                return;
            }
        }
        System.out.println("Không tìm thấy vật liệu với ID: " + id);
    }

    // Phương thức xóa vật liệu
    public void deleteMaterial(String id) {
        boolean removed = materials.removeIf(material -> material.getId().equals(id));
        if (removed) {
            System.out.println("Xóa vật liệu thành công.");
        } else {
            System.out.println("Không tìm thấy vật liệu với ID: " + id);
        }
    }

    // Phương thức quản lý vật liệu
    public void manageMaterials() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n=== Quản Lý Vật Liệu ===");
            System.out.println("1. Thêm vật liệu");
            System.out.println("2. Sửa vật liệu");
            System.out.println("3. Xóa vật liệu");
            System.out.println("4. Thoát");
            System.out.print("Chọn chức năng (1-4): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng mới

            switch (choice) {
                case 1:
                    addMaterialOption(scanner);
                    break;
                case 2:
                    updateMaterialOption(scanner);
                    break;
                case 3:
                    deleteMaterialOption(scanner);
                    break;
                case 4:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        } while (choice != 4);
    }

    // Phương thức hỗ trợ thêm vật liệu
    private void addMaterialOption(Scanner scanner) {
        System.out.println("\n--- Thêm Vật Liệu ---");
        System.out.print("Chọn loại vật liệu (1. Bột chiên giòn, 2. Thịt): ");
        int type = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng mới

        System.out.print("Nhập ID: ");
        String id = scanner.nextLine();

        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();

        System.out.print("Nhập ngày sản xuất (YYYY-MM-DD): ");
        LocalDate manufacturingDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Nhập giá: ");
        int cost = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng mới

        if (type == 1) {
            System.out.print("Nhập số lượng: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng mới
            Material crispyFlour = new CrispyFlour(id, name, manufacturingDate, cost, quantity);
            addMaterial(crispyFlour);
        } else if (type == 2) {
            System.out.print("Nhập trọng lượng: ");
            double weight = scanner.nextDouble();
            scanner.nextLine(); // Đọc bỏ dòng mới
            Material meat = new Meat(id, name, manufacturingDate, cost, weight);
            addMaterial(meat);
        } else {
            System.out.println("Loại vật liệu không hợp lệ.");
        }
    }

    // Phương thức hỗ trợ sửa vật liệu
    private void updateMaterialOption(Scanner scanner) {
        System.out.println("\n--- Sửa Vật Liệu ---");
        System.out.print("Nhập ID vật liệu cần sửa: ");
        String id = scanner.nextLine();

        // Tìm vật liệu theo ID
        Material existingMaterial = null;
        for (Material material : materials) {
            if (material.getId().equals(id)) {
                existingMaterial = material;
                break;
            }
        }

        if (existingMaterial == null) {
            System.out.println("Không tìm thấy vật liệu với ID: " + id);
            return;
        }

        // Nhập thông tin mới
        System.out.print("Nhập tên mới: ");
        String name = scanner.nextLine();

        System.out.print("Nhập ngày sản xuất mới (YYYY-MM-DD): ");
        LocalDate manufacturingDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Nhập giá mới: ");
        int cost = scanner.nextInt();
        scanner.nextLine(); // Đọc bỏ dòng mới

        if (existingMaterial instanceof CrispyFlour) {
            System.out.print("Nhập số lượng mới: ");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng mới
            Material newMaterial = new CrispyFlour(id, name, manufacturingDate, cost, quantity);
            updateMaterial(id, newMaterial);
        } else if (existingMaterial instanceof Meat) {
            System.out.print("Nhập trọng lượng mới: ");
            double weight = scanner.nextDouble();
            scanner.nextLine(); // Đọc bỏ dòng mới
            Material newMaterial = new Meat(id, name, manufacturingDate, cost, weight);
            updateMaterial(id, newMaterial);
        }
    }

    // Phương thức hỗ trợ xóa vật liệu
    private void deleteMaterialOption(Scanner scanner) {
        System.out.println("\n--- Xóa Vật Liệu ---");
        System.out.print("Nhập ID vật liệu cần xóa: ");
        String id = scanner.nextLine();
        deleteMaterial(id);
    }

    // Các phương thức khác như tính tổng tiền, sắp xếp theo giá...
    public double calculateTotalAmount() {
        double totalAmount = 0;

        for (Material material : materials) {
            totalAmount += material.getAmount();
        }

        return totalAmount;
    }

    // Phương thức sắp xếp vật liệu theo giá
    public void sortMaterialsByPrice() {
        Collections.sort(materials, new Comparator<Material>() {
            @Override
            public int compare(Material m1, Material m2) {
                double price1 = m1.getAmount();
                double price2 = m2.getAmount();
                return Double.compare(price1, price2);
            }
        });

        System.out.println("Danh sách vật liệu đã được sắp xếp theo giá tăng dần.");
    }

    // Phương thức tính chênh lệch giữa chiết khấu và không chiết khấu
    public void calculateDiscountDifference() {
        double totalAmount = 0;
        double totalRealMoney = 0;

        for (Material material : materials) {
            totalAmount += material.getAmount();
            if (material instanceof DisCount) {
                totalRealMoney += ((DisCount) material).getRealMoney();
            } else {
                totalRealMoney += material.getAmount();
            }
        }

        double difference = totalAmount - totalRealMoney;

        System.out.println("Tổng tiền không chiết khấu: " + (long)totalAmount);
        System.out.println("Tổng tiền có chiết khấu: " + totalRealMoney);
        System.out.println("Số chênh lệch giữa chiết khấu và không chiết khấu: " + difference);
    }

    // Phương thức hiển thị danh sách vật liệu
    public void displayMaterials() {
        System.out.println("\n--- Danh Sách Vật Liệu ---");
        for (Material material : materials) {
            System.out.println(material.toString());
        }
    }

    // Phương thức quản lý vật liệu đã có ở trên...
}



