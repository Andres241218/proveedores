package co.edu.upb.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Evaluacion")
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long id;

    @Column(name = "Fecha", nullable = false)
    private Date date;

    @Column(name = "Calificacion", nullable = false)
    private int rating; 


    @OneToMany(mappedBy = "evaluacion", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Question> questions = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "ID_Proveedor", nullable = false,referencedColumnName = "ID")
    @JsonIgnore
    private Suppliers proveedor;

    @ManyToOne
    @JoinColumn(name = "ID_Usuario", nullable = false,referencedColumnName = "ID")
    @JsonIgnore
    private User usuario;

    // Method to add a question to the evaluation
    public void addQuestion(Question question) {
        questions.add(question);
    }
}
