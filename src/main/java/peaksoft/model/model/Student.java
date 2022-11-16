package peaksoft.model.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import static javax.persistence.CascadeType.REMOVE;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @SequenceGenerator(name = "student_seq",
            sequenceName = "student_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_seq")

    private Long id;

    private String firstName;

    private String lastName;

    private int phoneNumber;

    private String email;

    private StudyFormat studyFormat;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH},
            fetch = FetchType.EAGER)
    private Group group;

}
