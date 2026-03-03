package br.com.albert.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_carro")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro_seq")
    @SequenceGenerator(name = "carro_seq", sequenceName = "seq_carro", initialValue = 1 , allocationSize = 1)
    private Long id;

    @Column(name = "Modelo" , length = 30 , nullable = false)
    private String modelo;

    @Column(name = "Cor", length = 30, nullable = false)
    private String cor;

    @ManyToOne
    @JoinColumn(name  = "id_marca_fk",
    foreignKey = @ForeignKey(name = "fk_marca_carro"),
    referencedColumnName = "id", nullable = false)
    private Marca marca;

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
