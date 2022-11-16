package peaksoft.model.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Task {

    @Id
    @SequenceGenerator(name = "task_seq",
            sequenceName = "task_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "task_seq")

    private Long id;

    private String taskName;

    private String taskText;

    private LocalDate deadline;

    @ManyToOne(cascade = {
            DETACH, MERGE, REFRESH},fetch = FetchType.EAGER)
    private Lesson lesson;
}
