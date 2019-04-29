package clases;

import Querys.JugadaQuery;
import Querys.PartidaQuery;

import javax.persistence.*;
import java.util.List;

public class App {
    //Implemento los metodos
    static JugadaQuery queryJugada = new JugadaQuery();
    static PartidaQuery partidaQuery = new PartidaQuery();

    public static void main(String[] args) {

        //Ejecuta BD TORNEO de MariaDB (MySQL)
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        //Partidas
        Partida partida;


        //Coger primera partida
        partida = partidaQuery.getFirstPartida(1);

        //Compruebo que hasta que sigan habiendo partidas siga buscando
        while (partida != null) {

            Jugador ganador;

            //Primero cojo la ultima jugada de la partida
            Jugada partidaFinal = queryJugada.getLastJugada(partida.getId());
            //Segundo miro las tiradas de dicha partida pasada anteriormente
            Integer ganadorfinal = queryJugada.ganadorJuego(partidaFinal.getTirada1(), partidaFinal.getTirada2());

            //Compruebo si el ganador es el Jugador1 o Jugador2
            if (ganadorfinal == 1) {
                ganador = partida.getJugador1();
            } else {
                ganador = partida.getJugador2();
            }

            //Cojo la id de la jugada actual a partir de la partida que se esta jugando para coger toda la informacion
            Jugada jugada = queryJugada.jugada(partida.getId());

            //Imprimo la informacion
                System.out.println("INFO: Ganador: " + ganador.getNom() +
                    " > Partida " + jugada.getPartidaId().getId() +
                    ", jugador1: " + jugada.getPartidaId().getJugador1().getNom() +
                    ", jugador2: " + jugada.getPartidaId().getJugador2().getNom() +
                    ", data=" + jugada.getPartidaId().getData() +
                    ", jugades=" + "[ jugador1= " + jugada.getTirada1() + "jugador2=" + jugada.getTirada2() + "]");

            //Paso a la siguiente partida a partir de la partida actual y el ganador actual
            partida = getNextPartida(partida.getId(), ganador.getId());
            em.flush();
        }
        em.close();
    }

    //Devuelve Lista Partidas del ganador
    private static Partida getNextPartida(String idPartida,String jugadorId){
        List<Partida> partides = partidaQuery.getNextPartida(idPartida,jugadorId);

        for(Partida partida: partides){
            if (Integer.parseInt(partida.getId()) > Integer.parseInt(idPartida)){
                return partida;
            }
        }
        return null;
    }
}
