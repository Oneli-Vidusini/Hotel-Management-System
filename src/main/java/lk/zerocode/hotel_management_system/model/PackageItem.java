package lk.zerocode.hotel_management_system.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "package_items")
public class PackageItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Package packages;

    @ManyToOne
    private ServiceItem serviceItems;
}
