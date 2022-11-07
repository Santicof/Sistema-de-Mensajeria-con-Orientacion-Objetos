package modulo;

import java.time.LocalDate;
import java.time.LocalTime;

public class Email extends Mensaje {
	private String origen;
	private String destino;
	private String asunto;
	private String cuerpo;
	private boolean recibido;
	public Email(int idMensaje, LocalDate fechaEnvio, LocalTime horaEnvio, String origen, String destino, String asunto,
			String cuerpo, boolean recibido) throws Exception {
		super(idMensaje, fechaEnvio, horaEnvio);
		this.origen = origen;
		this.setDestino(destino);
		this.asunto = asunto;
		this.cuerpo = cuerpo;
		this.recibido = recibido;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) throws Exception {
		if(validacion(destino)) {
			
		}
		this.destino = destino;
	}
	public String getAsunto() {
		return asunto;
	}
	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}
	public String getCuerpo() {
		return cuerpo;
	}
	public void setCuerpo(String cuerpo) {
		this.cuerpo = cuerpo;
	}
	public boolean isRecibido() {
		return recibido;
	}
	public void setRecibido(boolean recibido) {
		this.recibido = recibido;
	}
	
	public boolean  validacion(String arro) throws Exception {
		int pos=arro.indexOf('@');
		if(pos<0) {
			throw new Exception("no contien arroba");
		}
		return true;
	}
	
	@Override
	public boolean cambiarDeEstado(boolean estadoNuevo) {
		this.setRecibido(estadoNuevo);
		return this.recibido;
	}
	
	
	
	@Override
	public String toString() {
		return "\n----------Email----------\n [origen=" + origen + "\n destino=" + destino + "\n asunto=" + asunto + "\n cuerpo=" + cuerpo
				+ "\n recibido=" + recibido + "\n "+super.toString();
	}


}
