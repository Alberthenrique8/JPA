package br.com.albert.domain;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name =  "tb_marca")
public class Marca {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "marca_seq")
    @SequenceGenerator(name  = "marca_seq", sequenceName = "seq_marca", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "marca" , length = 30, nullable = false)
    private String marca;

    @Column(name  = "fabricação", length =30 , nullable = false)
    private String fabricacao;

    @OneToMany(mappedBy = "marca")
    private List<Carro>carros;


    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getFabricacao() {
        return fabricacao;
    }

    public void setFabricacao(String fabricacao) {
        this.fabricacao = fabricacao;
    }
}
