package co.edu.upb.entities;

import jakarta.persistence.*;
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
@Table(name = "EJECUTORGASTO")
public class SpendingExecutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Seccional",referencedColumnName = "ID")
    private Sectional seccional; 

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_Usuario" ,referencedColumnName = "ID")
    private User usuario; 



}
