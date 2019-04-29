package clases;

import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

import org.hibernate.annotations.Fetch;

@Entity
@Table(name="jugada")
public class Jugada {

    private Integer id;
    private Partida partidaId;
    private Integer num_jugada;
    private String tirada1;
    private String tirada2;

    @Id
    @Column(name="id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_partida", nullable = false)
    public Partida getPartidaId() {
        return partidaId;
    }

    public void setPartidaId(Partida partidaId) {
        this.partidaId = partidaId;
    }

    @Column(name="num_jugada")
    public Integer getNum_jugada() {
        return num_jugada;
    }

    public void setNum_jugada(Integer num_jugada) {
        this.num_jugada = num_jugada;
    }

    @Column(name="tira_jugador1")
    public String getTirada1() {
        return tirada1;
    }

    public void setTirada1(String tirada1) {
        this.tirada1 = tirada1;
    }

    @Column(name="tira_jugador2")
    public String getTirada2() {
        return tirada2;
    }

    public void setTirada2(String tirada2) {
        this.tirada2 = tirada2;
    }
}
