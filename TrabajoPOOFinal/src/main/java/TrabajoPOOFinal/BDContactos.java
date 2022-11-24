package TrabajoPOOFinal;

import java.io.IOException;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class BDContactos {

    public LinkedList<Contacto> obtener() {
        LinkedList<Contacto> productos = null;
        Archivo archivo = new Archivo("contactos.txt");
        LinkedList<String> lineas = archivo.obtenerTextoDelArchivo();
        if (lineas != null) {
            productos = new LinkedList();
            for (int i = 0; i < lineas.size(); i++) {
                String linea = lineas.get(i);
                StringTokenizer tokens = new StringTokenizer(linea, ";");
                String nombre = tokens.nextToken();
                String apellido = tokens.nextToken();
                String cedula = tokens.nextToken();

                productos.add(new Contacto(nombre, apellido, cedula));
            }
        }
        return productos;
    }

    public boolean registrarProducto(Contacto p) throws IOException {
        Archivo archivo = new Archivo("contactos.txt");
        return archivo.registrar(p.getNombre()+ ";" + p.getApellido()+ ";" + p.getCedula());

        
    }

    public boolean borrarTodo() {
        Archivo archivo = new Archivo("contactos.txt");
        return archivo.borrarContenido();
    }
}
