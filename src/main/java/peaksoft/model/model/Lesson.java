package peaksoft.model.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class Lesson {

    @Id
    @SequenceGenerator(name = "lesson_seq",
            sequenceName = "lesson_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "lesson_seq")

    private Long id;

    private String lessonName;

    @ManyToOne(cascade = {
            DETACH,
            MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH},fetch = FetchType.EAGER)
    private Course course;

    @OneToMany(cascade = {CascadeType.REFRESH,MERGE,REMOVE,DETACH},fetch = FetchType.LAZY,mappedBy = "lesson")
    private List<Task> tasks = new ArrayList<>();

}
