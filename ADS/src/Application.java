import Controlador.CBusqueda;
import Modelo.MBusqueda;
import Vistas.Filtros;
import Vistas.VBusqueda;

/**
 * Created by Frank on 27/04/2016.
 */
public class Application {

    private VBusqueda vista;
    private MBusqueda modelo;
    private CBusqueda controlador;

    private static Application instance;

    private Application(){
        this.vista = new VBusqueda();
        this.modelo = new MBusqueda();
        this.controlador = new CBusqueda(modelo, vista);
    }

    static Application getInstance(){
        if(instance == null){
            instance = new Application();
        }
        return instance;
    }

    void run(){
        controlador.start();
    }


}
