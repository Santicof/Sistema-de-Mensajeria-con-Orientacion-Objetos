package modulo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sitema {
private List<Mensaje> lstMensajes;

public Sitema() {
	
	this.lstMensajes = new ArrayList<Mensaje>();
}

public List<Mensaje> getLstMensajes() {
	return lstMensajes;
}

public boolean agregarEmail(LocalDate fechaEnvio,LocalTime horaEnvio,String origen,String destino,String asunto,String cuerpo) throws Exception {
	int proxId=1;
	if(lstMensajes.size()>0) {
		proxId=lstMensajes.get(lstMensajes.size()-1).getIdMensaje()+1;
	}
	return lstMensajes.add(new Email(proxId, fechaEnvio, horaEnvio, origen, destino, asunto, cuerpo, false));
}


public boolean agregarSMS(LocalDate fechaEnvio,LocalTime horaEnvio,int numeroOrigen,int numeroDestino,String texto,OperadorMovil operadorOrigen,OperadorMovil operadorDestino) throws Exception {
	int proxId=1;
	if(lstMensajes.size()>0) {
		proxId=lstMensajes.get(lstMensajes.size()-1).getIdMensaje()+1;
	}
	
	return lstMensajes.add(new SMS(proxId,fechaEnvio,horaEnvio,numeroOrigen,numeroDestino,texto,false,operadorOrigen,operadorDestino));
}




public List<Mensaje> traerMensaje (String nombreCompania) {
	List<Mensaje> lista=new ArrayList<Mensaje>();
	for(int i=0;i<lstMensajes.size();i++) {
		if(lstMensajes.get(i) instanceof SMS) {
			SMS sms=(SMS)lstMensajes.get(i);
			if(sms.getOperadorOrigen().getCompaniaMovil().equals(nombreCompania)) {
				lista.add(lstMensajes.get(i));
			}
		}
	}
	return lista;
}


public List<Mensaje> traerMensaje(LocalDate fecha,LocalTime horaDesde,LocalTime horaHasta){
	
	List<Mensaje> lista=new ArrayList<Mensaje>();
	for(int i=0;i<lstMensajes.size();i++) {
		if(lstMensajes.get(i).getFechaEnvio().equals(fecha)) {
			if(!(lstMensajes.get(i).getHoraEnvio().isAfter(horaHasta)||lstMensajes.get(i).getHoraEnvio().isBefore(horaDesde))) {
				lista.add(lstMensajes.get(i));
			}
		}
	}
	return lista;
}





public List<Mensaje> traerMensaje(LocalDate fecha,LocalTime horaDesde,LocalTime horaHasta,String codigoCompania){
	
	List<Mensaje> lista=new ArrayList<Mensaje>();
	for(int i=0;i<lstMensajes.size();i++) {
		if(lstMensajes.get(i).getFechaEnvio().equals(fecha)) {
			if(!(lstMensajes.get(i).getHoraEnvio().isAfter(horaHasta)||lstMensajes.get(i).getHoraEnvio().isBefore(horaDesde))) {
				if(lstMensajes.get(i) instanceof SMS) {
					SMS sms=(SMS)lstMensajes.get(i);
					if(sms.getOperadorOrigen().getCompaniaMovil().equals(codigoCompania)) {
					lista.add(sms);
				}
				}
				
			}
		}
	}
	return lista;
}




public Mensaje traerMensaje(int idMensaje) {
	Mensaje men=null;
	int i=0;
	while(men==null&&i<lstMensajes.size()) {
		if(lstMensajes.get(i).getIdMensaje()==idMensaje) {
			men=lstMensajes.get(i);
		}
		i++;
	}
	return men;
}








@Override
public String toString() {
	return "Sitema [lstMensajes=" + lstMensajes + "]";
}




}
