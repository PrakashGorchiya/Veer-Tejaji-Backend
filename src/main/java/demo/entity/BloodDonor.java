package demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "blood_donors")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BloodDonor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String bloodGroup;
    private String mobile;
    private String city;
    private Boolean available;
}
