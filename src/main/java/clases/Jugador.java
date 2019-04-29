package clases;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jugador")
public class Jugador {

    private String id_jugador;
    public String nom;
    public String alies;
    public Integer ranquing;

    @Id
    @Column(name="id_jugador")
    public String getId() {
        return id_jugador;
    }

    public void setId(String id) {
        this.id_jugador = id;
    }
    @Column(name="nom")
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column(name="alies")
    public String getAlies() {
        return alies;
    }

    public void setAlies(String alies) {
        this.alies = alies;
    }

    @Column(name="ranquing")
    public Integer getRanquing() {
        return ranquing;
    }

    public void setRanquing(Integer ranquing) {
        this.ranquing = ranquing;
    }


}
