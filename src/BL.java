import java.util.Objects;


public class BL extends Contenedor {
    private String numeroBL;
    private String Contenedor;
    private String vin1;
    private String vin2;
    private String vin3;

    public BL(String contenedor, String vin1, String vin2, String vin3) {
        this.Contenedor = contenedor;
        this.vin1 = vin1;
        this.vin2 = vin2;
        this.vin3 = vin3;
    }
    public BL(String contenedor, String vin1, String vin2) {
        this.Contenedor = contenedor;
        this.vin1 = vin1;
        this.vin2 = vin2;
    }
    public BL(String contenedor, String vin1) {
        this.Contenedor = contenedor;
        this.vin1 = vin1;
    }
    public BL(String contenedor) {
        this.Contenedor = contenedor;
    }
    public BL() {}

    public void mostrarBL() {
        if(!Objects.equals(Contenedor, null)){
            System.out.print("Numero de Contenedor: ");
            System.out.println(Contenedor);
            System.out.print("Contenedor valido: ");
            System.out.println(validarContenedor(Contenedor));
        }
        if(!Objects.equals(vin1, null)) {
            System.out.print("Numero de vin 1: ");
            parametros(vin1);
        }
        if(!Objects.equals(vin2, null)) {
            System.out.print("Numero de vin 2: ");
            parametros(vin2);
        }
        if(!Objects.equals(vin3, null)) {
            System.out.print("Numero de vin 3: ");
            parametros(vin3);
        }
    }

    private void parametros(String vin) {
        System.out.println(vin);
        System.out.print("Tipo de carrocería: ");
        System.out.println(obtenerAtributo(vin,"Body Class"));
        System.out.print("Modelo: ");
        System.out.println(obtenerAtributo(vin,"Make"));
        System.out.print("Marca: ");
        System.out.println(obtenerAtributo(vin,"Model"));
        System.out.print("Año: ");
        System.out.println(obtenerAtributo(vin,"Model Year"));
        System.out.print("Desplasamiento del motor (L): ");
        System.out.println(obtenerAtributo(vin,"Displacement (L)"));
        System.out.println();
    }


}
