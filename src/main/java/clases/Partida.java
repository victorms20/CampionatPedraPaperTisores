package clases;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="partida")
public class Partida {

    private String id_partida;
    public Jugador jugador1;
    public Jugador jugador2;
    public Date data;


    @Id
    @Column(name="id_partida")
    public String getId() {
        return id_partida;
    }

    public void setId(String id) {
        this.id_partida = id;
    }

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador1", nullable = false)
    public Jugador getJugador1() {
        return jugador1;
    }

    public void setJugador1(Jugador jugador1) {
        this.jugador1 = jugador1;
    }

    @Fetch(FetchMode.JOIN)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_jugador2", nullable = false)
    public Jugador getJugador2() {
        return jugador2;
    }

    public void setJugador2(Jugador jugador2) {
        this.jugador2 = jugador2;
    }

    @Column(name="data")
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
