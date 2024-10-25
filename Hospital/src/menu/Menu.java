package menu;

import hospital.Hospital;
import usuarios.administrador.Administrador;
import usuarios.medicos.Medico;
import usuarios.pacientes.Paciente;
import usuarios.Usuario;
import utils.*;

import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);
    private final Hospital hospital = new Hospital();
    public Usuario usuarioEnSesion;

    public void login(){
        int intentosMaximos = 5, intentosUser=0;
        //Iniciar con el administrador como predeterminado
        //this.mostrarMenuAdmin(hospital.administrador);
        MenuAdministrador menuAdministrador = new MenuAdministrador();
        int opc;
        do {
            opc = menuAdministrador.mostrarMenu(hospital.administrador);
            menuAdministrador.procesarDatosMenu(opc, hospital.administrador, hospital);
        }while (opc != 13);


        while(intentosUser < intentosMaximos){
            System.out.print("\n--------Bienvenido/a--------\n");
            System.out.println("---Inicia sesión para continuar---");

            scanner.nextLine();
            System.out.print("Ingrese su usuario: ");
            String usuario = scanner.nextLine();

            System.out.print("Ingrese su contraseña: ");
            String contrasena = scanner.nextLine();

            usuarioEnSesion = hospital.validarInicioSesion(usuario,contrasena);

            if (usuarioEnSesion instanceof Usuario){
                if (usuarioEnSesion.getRol() == Rol.PACIENTE){
                    Paciente pacienteEnSesion = (Paciente) usuarioEnSesion;

                    //this.mostrarMenuPaciente(pacienteEnSesion);
                    MenuPaciente menuPaciente = new MenuPaciente();
                    int opcion = menuPaciente.mostrarMenu(pacienteEnSesion);
                    menuPaciente.procesarDatosMenu(opcion,pacienteEnSesion,hospital);

                    intentosUser=0;
                }else if (usuarioEnSesion.getRol() == Rol.MEDICO){
                    Medico medicoEnSesion = (Medico) usuarioEnSesion;

                    //this.mostrarMenuMedico(medicoEnSesion);
                    MenuMedico menuMedico = new MenuMedico();
                    int opcion = menuMedico.mostrarMenu(medicoEnSesion);
                    menuMedico.procesarDatosMenu(opcion,medicoEnSesion,hospital);

                    intentosUser=0;
                }else{
                    Administrador AdminEnSesion = (Administrador) usuarioEnSesion;

                    //this.mostrarMenuAdmin(AdminEnSesion);
                    opc = menuAdministrador.mostrarMenu(AdminEnSesion);
                    menuAdministrador.procesarDatosMenu(opc,AdminEnSesion,hospital);

                    intentosUser=0;
                }
            }else{
                intentosUser= mostrarErrorInicioSesion(intentosUser);
            }
        }
        System.out.println("\nLímite de intentos alcanzado\n");
    }

    private int mostrarErrorInicioSesion(int intentosUser){
        System.out.print("\nUsuario o contraseña incorrecta, intente de nuevo\n");
        intentosUser++;
        return intentosUser;
    }
}
