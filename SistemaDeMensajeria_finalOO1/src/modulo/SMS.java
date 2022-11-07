package modulo;

import java.time.LocalDate;
import java.time.LocalTime;

public class SMS extends Mensaje {
	private int numeroOrigen;
	private int numeroDestino;
	private boolean visto;
	private String texto;
	private OperadorMovil operadorOrigen;
	private OperadorMovil operadorDestino;

	public SMS(int idMensaje, LocalDate fechaEnvio, LocalTime horaEnvio, int numeroOrigen, int numeroDestino,String texto,
			boolean visto, OperadorMovil operadorOrigen, OperadorMovil operadorDestino) throws Exception {
		super(idMensaje, fechaEnvio, horaEnvio);
		this.numeroOrigen = numeroOrigen;
		this.setNumeroDestino(numeroDestino);
		this.visto = visto;
		this.texto=texto;
		this.operadorOrigen = operadorOrigen;
		this.operadorDestino = operadorDestino;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getNumeroOrigen() {
		return numeroOrigen;
	}

	public void setNumeroOrigen(int numeroOrigen) {
		this.numeroOrigen = numeroOrigen;
	}

	public int getNumeroDestino() {
		return numeroDestino;
	}

	public void setNumeroDestino(int numeroDestino) throws Exception {
		if (String.valueOf(numeroDestino).length() != 10) {
			throw new Exception("no tiene 10 numeros exactos");
		}
		this.numeroDestino = numeroDestino;
	}

	public boolean isVisto() {
		return visto;
	}

	public void setVisto(boolean visto) {
		this.visto = visto;
	}

	public OperadorMovil getOperadorOrigen() {
		return operadorOrigen;
	}

	public void setOperadorOrigen(OperadorMovil operadorOrigen) {
		this.operadorOrigen = operadorOrigen;
	}

	public OperadorMovil getOperadorDestino() {
		return operadorDestino;
	}

	public void setOperadorDestino(OperadorMovil operadorDestino) {
		this.operadorDestino = operadorDestino;
	}

	@Override
	public boolean cambiarDeEstado(boolean estadoNuevo) {
		this.setVisto(estadoNuevo);
		return this.visto;
	}

	@Override
	public String toString() {
		return "\n---------SMS---------\n [numeroOrigen=" + numeroOrigen + "\n numeroDestino=" + numeroDestino + "\n visto=" + visto
				+ "\n texto=" + texto + "\n operadorOrigen= " + operadorOrigen + "\n operadorDestino=" + operadorDestino
				+ " "+super.toString();
	}

	
}
