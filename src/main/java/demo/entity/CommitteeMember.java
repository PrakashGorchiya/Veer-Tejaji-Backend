package demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "committee_members")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommitteeMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;       // अध्यक्ष
    private String name;       // हिंदी नाम
    private String mobile;     // optional
    private String photoUrl;   // image path
   

}
