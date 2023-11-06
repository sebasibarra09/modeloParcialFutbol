package ar.edu.unlam.pb2.ea3;

import java.util.Comparator;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class EquipoDeFutbol {
	
	private String nombre;
	private Set<Jugador> jugadores;
	private TreeSet<Jugador> jugadoresPorPrecio = new TreeSet<>(Comparator.comparing(Jugador::getNumero));
	private TreeSet<Jugador> jugadoresPorCamiseta = new TreeSet<>(Comparator.comparing(Jugador::getNumero));
	
	public EquipoDeFutbol(String nombre) {
		this.nombre = nombre;
		this.jugadores = new HashSet<>();
	}

	/*
	 * La capacidad m�xima de un equipo es 23. Cualquier intento de agregar m�s
	 * jugadores generar� una excepci�n (CapacidadMaximaException). Adem�s, no
	 * deber� permitir duplicar Jugadores (JugadorDuplicadoException).
	 */
	public void agregarJugador(Jugador jugador) throws CapacidadMaximaException, JugadorDuplicadoException {
		if (jugadores.size() >= 23) {
			throw new CapacidadMaximaException();
		}
		if (jugadores.contains(jugador)) {
			throw new JugadorDuplicadoException();
		}
		jugadores.add(jugador);
	}

	/*
	 * Permite cambiar cualquier jugador. Un intento de cambiar un jugador no
	 * presente en el equipo generar� una excepci�n (JugadoreInexistenteException).
	 */
	public Boolean cambiarJugador(Jugador saliente, Jugador entrante) throws JugadoreInexistenteException {
		if (!jugadores.contains(saliente)) {
			throw new JugadoreInexistenteException();
		}
		jugadores.remove(saliente);
		return jugadores.add(entrante);
	
	}
	
	public TreeSet<Jugador> devolverPlanteOrdenadoPorNombreDeJugador() {
		TreeSet<Jugador> jugadoresOrdenadosPorNombre = new TreeSet<>(jugadores);

		return jugadoresOrdenadosPorNombre;
	}

	public TreeSet<Jugador> devolverPlanteOrdenadoPorPrecioDeCompraDeJugador() {
		jugadoresPorPrecio.addAll(jugadores);
		return jugadoresPorPrecio;
	}

	public TreeSet<Jugador> devolverPlanteOrdenadoPorNumeroDeCamisetaDeJugador() {
		jugadoresPorCamiseta.addAll(jugadores);
		return jugadoresPorCamiseta;
	}

	public Set<Jugador> getJugadores() {
		return jugadores;
	}

	public void setJugadores(Set<Jugador> jugadores) {
		this.jugadores = jugadores;
	}


}
