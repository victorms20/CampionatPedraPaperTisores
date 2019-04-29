package Querys;

import clases.Jugada;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JugadaQuery {
    //Conexion BD
    public EntityManagerFactory torneo = Persistence.createEntityManagerFactory("persistencia");
    public  EntityManager em = this.torneo.createEntityManager();

    //Coger la jugada a partir de la ID de la partida
    public Jugada jugada(String partidaId) {
        String consulta = "SELECT j FROM Jugada j WHERE j.partidaId = " + partidaId;

        return em.createQuery(consulta,Jugada.class).setMaxResults(1).getResultList().get(0);
    }

    //Le paso los 2 jugadores y miro quien gana de los dos en el juego
    public Integer ganadorJuego(String tiradajugador1, String tiradajugador2) {
        int ganador = 0;

        if (tiradajugador1.equals("pedra") && tiradajugador2.equals("paper")) {
           ganador = 2;
        }else if (tiradajugador1.equals("pedra") && tiradajugador2.equals("tisores")) {
            ganador = 1;
        }else if (tiradajugador1.equals("paper") && tiradajugador2.equals("tisores")) {
            ganador = 2;
        }else if (tiradajugador1.equals("paper") && tiradajugador2.equals("pedra")) {
            ganador = 1;
        }else if (tiradajugador1.equals("tisores") && tiradajugador2.equals("pedra")) {
            ganador = 2;
        }else if (tiradajugador1.equals("tisores") && tiradajugador2.equals("paper")) {
            ganador = 1;
        }

        return ganador;
    }

    // Coger ultima jugada que ha echo a partir de la partida que esta jugando y ordenarlo
    public Jugada getLastJugada(String idPartida) {
        Integer idpartidaINT = Integer.parseInt(idPartida);
        String consulta = "SELECT j FROM Jugada j where j.partidaId = "+ idpartidaINT +" order by j.num_jugada desc";

        return em.createQuery(consulta, Jugada.class).setMaxResults(1).getResultList().get(0);
    }
}
