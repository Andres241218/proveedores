package co.edu.upb.entities;



import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonInclude(JsonInclude.Include.NON_NULL)

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Categoria")
public class Category {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private long categoryId;

    @Column(name = "Nombre") 
    private String categoryName;
    

}
 
