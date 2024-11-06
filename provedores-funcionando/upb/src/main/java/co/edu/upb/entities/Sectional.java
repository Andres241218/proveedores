package co.edu.upb.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Seccional") 
public class Sectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID") 
    private long sectionalId;

    @Column(name = "Nombre", nullable = false) 
    private String sectionalName;

    @OneToMany(mappedBy = "seccional", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SpendingExecutor> spendingExecutors = new ArrayList<>(); 

    // Método para añadir un spendingExecutor
    public void addSpendingExecutor(SpendingExecutor spendingExecutor) {
        spendingExecutors.add(spendingExecutor);
    }

}