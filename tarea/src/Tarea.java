import java.io.*;

public class Tarea {
    private static final String NOMBRE_ARCHIVO = "C:/Users/diego/Tareas_Poo/Repo_tareas/tareas.txt";
//PODEMOS ESPECIFICAR RUTA DONDE QUEREMOS ESCRIBIR EL ARCHIVO


    public void AnotarTarea(String tarea) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO,true))) {
            //APPENED EN TRUE PARA EVITAR SOBREESCRITURA:ES DECIR AGGREGA SIN BORRAR EL CONTENIDO EXISTENTE SIN EL CADA VEZ Q AGREGEMOS BORRARA O ESTANDO EN FALSE
            bw.write(tarea);
            bw.newLine();
            System.out.println("La tarea ha sido guardada.");
        } catch (IOException e) {
            System.out.println("Error al momento de tratar escribir en el archivo tareasU6.txt: " + e);
        }
    }

    public void LeerTarea() {
        try (BufferedReader br = new BufferedReader(new FileReader(NOMBRE_ARCHIVO))) {
            String linea;
            System.out.println("*****Tareas guardadas*******");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo de tareas no existe o no fue encontrado");
        } catch (IOException e) {
            System.out.println("Error al momento de tratar de  leer el archivo tareasU6.txt: " + e);
        }
    }
}
