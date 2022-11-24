
package TrabajoPOOFinal;

import java.io.IOException;
import java.util.LinkedList;

public class ListaDeContactos {
    private LinkedList<Contacto> productos;

    public ListaDeContactos() {
        productos=new LinkedList();
    }
    
    public void agregar(Contacto a){
        productos.add(a);
    }
    
    public void eliminar(int indice){
        productos.remove(indice);
    }
       
       
    public int total(){
        return productos.size();
    }
    
    public Contacto obtener(int indice){
        return productos.get(indice);
    }
    
       
    public void cargarProductos(){
        BDContactos bd=new BDContactos();
        productos=bd.obtener();        
    }
    
    public void guardarEnArchivo() throws IOException{
        BDContactos bd=new BDContactos();
        bd.borrarTodo();
        for(int i=0; i<productos.size();i++){
        bd.registrarProducto(productos.get(i));
    }
    }
}
