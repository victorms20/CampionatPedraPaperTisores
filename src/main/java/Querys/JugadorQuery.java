package Querys;

import clases.Jugador;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class JugadorQuery {

    public EntityManagerFactory torneo = Persistence.createEntityManagerFactory("persistencia");
    public  EntityManager em = this.torneo.createEntityManager();

    //Devuelve Jugador
    public List<Jugador> Jugador() {
        String consulta = "SELECT j FROM Jugada j";

        List<Jugador> jugadas = em.createQuery(consulta).getResultList();
        return jugadas;
    }
}
