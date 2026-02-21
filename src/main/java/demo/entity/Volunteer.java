package demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "volunteers")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Volunteer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String mobile;
    private String area;     // सेवा क्षेत्र
    private String city;
    private Boolean active;
}
