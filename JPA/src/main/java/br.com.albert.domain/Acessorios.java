package br.com.albert.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_acessorios")
public class Acessorios {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "aceesorio_seq")
    @SequenceGenerator(name  = "aceesorio_seq", sequenceName = "seq_aceesorio", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name  = "Turbo" , length = 30, nullable = false)
    private String turbo;

    @Column(name = "Farois", length = 50, nullable = false)
    private String Farois;


    public String getTurbo() {
        return turbo;
    }

    public void setTurbo(String turbo) {
        this.turbo = turbo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFarois() {
        return Farois;
    }

    public void setFarois(String farois) {
        Farois = farois;
    }


}
