
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private static final String ADD_VALUES_COMERCIAL_1 = "INSERT INTO tareas VALUES(1," + "'{{\"pedidos 8:30\",\"lineal 11:30\"}," + "{\"proveedores 14:30\", \"RRHH 18:30\"}}')";
    private static final String ADD_VALUES_COMERCIAL_2 = "INSERT INTO tareas VALUES(2," + "'{{\"debrief 8:30\",\"comida 15:30\"}," + "{\"visita madrid 10:30\", \"firmar contratos 16:30\"}}')";
    private static final String QUERY_FIRST_DAILY_TASKS = "SELECT tareas.comercial_id, agenda[1:1] from tareas order by comercial_id;";
    private static final String QUERY_SECOND_DAILY_TASKS = "SELECT tareas.comercial_id, agenda[2:2] from tareas order by comercial_id;";
    private static final String QUERY_UPDATE ="UPDATE tareas SET agenda[1:1] = '{\"pedidos 08:30\",\"lineal 11:30\"}' WHERE comercial_id = 1";
    private static final String QUERY_SELECT = "SELECT * from tareas order by comercial_id;";
    private static final String SECOND_PARAMETER_DAILY_TASKS_QUERY ="agenda[1]";
    private static final String THIRD_PARAMETER_DAILY_TASKS_QUERY ="agenda[2]";

    public static void showMenu() {

        Utils utils = new Utils();
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        int opcion;


        while (continuar){
            System.out.println("");
            System.out.println("##############################################################################################################################");
            System.out.println("######################################################    APARTADO 4   #######################################################");
            System.out.println("##############################################################################################################################");
            System.out.println("1 - Añade dos nuevos comerciales a la agenda de la tabla ‘tareas’ con sus respectivas tareas");
            System.out.println("2 - Consulta para cada comercial las tareas del día 1");
            System.out.println("3 - Consulta para cada comercial la primera tarea del segundo día");
            System.out.println("4 - Modifica alguna tarea de alguno de los comerciales de tu base de datos");
            System.out.println("5 - Muestra todos los comerciales con sus tareas.");
            System.out.println("6 - Salir.");

            System.out.println("Introduzca una opción:");
            try{
                opcion = scanner.nextInt();
                switch (opcion){
                    case 1:
                        utils.statements().executeUpdate(ADD_VALUES_COMERCIAL_1);
                        utils.statements().executeUpdate(ADD_VALUES_COMERCIAL_2);
                        break;
                    case 2:
                        utils.resultSet(QUERY_FIRST_DAILY_TASKS);
                        break;
                    case 3:
                        utils.trimmedResultSet(QUERY_SECOND_DAILY_TASKS);
                        break;
                    case 4:
                        System.out.println("Resultado antes de actualizar:");
                        utils.resultSet(QUERY_FIRST_DAILY_TASKS);
                        System.out.println();
                        System.out.println("SQL insertado: " + QUERY_UPDATE);
                        utils.updateResult(QUERY_UPDATE);
                        System.out.println();
                        System.out.println("Resultado después de actualizar:");
                        utils.resultSet(QUERY_FIRST_DAILY_TASKS);
                        break;
                    case 5:
                        utils.resultSet(QUERY_SELECT);
                        break;
                    case 6:
                        System.exit(0);
                        continuar = false;
                    default:
                        System.out.println("Introduce una opción correcta (1-6)");
                }
            }catch (InputMismatchException | SQLException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
