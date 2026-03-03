package br.com.albert.domain;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produto_seq")
    @SequenceGenerator(name = "produto_seq", sequenceName = "seq_produto", initialValue = 1 , allocationSize = 1)
    private Long id;

    @Column(name = "Nome" , length = 30 , nullable = false)
    private String nome;

    @Column(name = "TipoDeProduto", length = 30, nullable = false)
    private String tipoDeProduto;

    @Column(name = "Valor", length = 30, nullable = false)
    private String valor;


    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoDeProduto() {
        return tipoDeProduto;
    }

    public void setTipoDeProduto(String tipoDeProduto) {
        this.tipoDeProduto = tipoDeProduto;
    }


}
