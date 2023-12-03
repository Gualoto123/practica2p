import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class Lista {
    List<PuntoAcceso> listadoDispositivo;

    public Lista() {
        listadoDispositivo= new ArrayList<>();
        listadoDispositivo.add(new PuntoAcceso(1, "CISCO", "111", 25f));
    }
    public void agregarDispositivo(PuntoAcceso dato){
        for(PuntoAcceso p : listadoDispositivo){
            if(dato.getCodigo()==p.getCodigo()){
                p.setMarca(dato.getMarca());
                p.setIp(dato.getIp());
                p.setPrecio(dato.getPrecio());
                JOptionPane.showMessageDialog(null, "Actualizado");
                return;
            }
        }
        listadoDispositivo.add(dato);
        JOptionPane.showMessageDialog(null, "Ingresado");
    }
    public float sumatoria(int indice, String Marca){
     if(indice<listadoDispositivo.size()){
         if(listadoDispositivo.get(indice).getMarca().equals(Marca)){
             return listadoDispositivo.get(indice).getPrecio()+sumatoria(indice+1,Marca);
         }else{
             return sumatoria(indice+1, Marca);
         }
     }
     return 0;
    }

    public float sumatoria(String marca){
        return sumatoria(0, marca);
    }
public List<PuntoAcceso> listaOrdenada(){
        List<PuntoAcceso> listaOrdenada= new ArrayList<>(listadoDispositivo);
        PuntoAcceso aux;
for(int i=0; i<listaOrdenada.size()-1;i++){
    for(int j=i+1; j<listaOrdenada.size();j++ ){
        if(listaOrdenada.get(i).getCodigo() > listaOrdenada.get(j).getCodigo()){
            aux=listaOrdenada.get(i);
            listaOrdenada.set(i,listaOrdenada.get(j));
            listaOrdenada.set(j,aux);
        }

    }
}
      return listaOrdenada;
}

}
