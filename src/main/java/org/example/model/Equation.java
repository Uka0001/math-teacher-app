package org.example.model;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "equations")
public class Equation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "equation_value")
    private String equationValue;
    //    @OneToMany(mappedBy = "rootValue", fetch = FetchType.LAZY)
    @OneToMany(mappedBy = "equation", fetch = FetchType.LAZY)
    private List<Root> rootList;

    @Override
    public String toString() {
        return "Equation{"
                + "equationValue='"
                + equationValue
                + '}';
    }
}
