package Querys;

import clases.Partida;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PartidaQuery {
    public EntityManagerFactory torneo = Persistence.createEntityManagerFactory("persistencia");
    public  EntityManager em = this.torneo.createEntityManager();

    //A partir de la Id de la partida te devuelve su ultima partida
    public Partida getFirstPartida(Integer idPartida){
        String consulta = "SELECT p FROM Partida p WHERE p.id = " +idPartida;
        return  em.createQuery(consulta, Partida.class).setMaxResults(1).getResultList().get(0);
    }

    //Paso a la siguiente partida a partir de la partida actual y el ganador actual
    public List<Partida> getNextPartida(String partidaId,String jugadorId){
        String consulta = "SELECT p FROM Partida p WHERE p.id > " + partidaId + " AND p.jugador1.id = "+ "'" + jugadorId +"' OR p.jugador2 = "+ "'" + jugadorId+"' ORDER BY p.id ASC";

        List<Partida> partida = em.createQuery(consulta, Partida.class).getResultList();

        return partida;
    }
}
