package org.example.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "equations")
public class Equation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "equation_value")
    String equationValue;
    //    @OneToMany(mappedBy = "rootValue", fetch = FetchType.LAZY)
    @OneToMany
    List<Root> rootList;
}
