import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Random;

public class Main {
    private static final String TEMP_PASSWORD = "Progra2024";
    private static final String TEMP_ID = "0601200501142";
    private static double saldoAhorro = 100000; // LPS
    private static double saldoCheques = 10000; // USD
    private static Map<String, Double> cuentas = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("BIENVENIDO, POR FAVOR INGRESE SU NUMERO DE IDENTIFICACION SIN GUIONES");
        String id = scanner.nextLine();

        if (!id.equals(TEMP_ID)) {
            System.out.println("Usuario incorrect");
            return;
        }

        int attempts = 0;
        while (attempts < 3) {
            System.out.println("Por favor ingrese su contraseña temporal");
            String tempPassword = scanner.nextLine();

            if (tempPassword.equals(TEMP_PASSWORD)) {
                break;
            }

            attempts++;
            if (attempts == 3) {
                System.out.println("Contraseña incorrecta. Se han agotado los intentos");
                return;
            }

            System.out.println("Contraseña incorrecta. Intentos restantes: " + (3 - attempts));
        }

        System.out.println("Por favor, ingrese su nuevo usuario:");
        String username = scanner.nextLine();

        System.out.println("Por favor, ingrese su nueva contraseña:");
        String password = scanner.nextLine();

        if (password.length() < 8) {
            System.out.println("La contraseña no cumple con el parametro de seguridad");
            return;
        }

        System.out.println("Contraseña creada exitosamente");

        while (true) {
            System.out.println("Por favor, ingrese su usuario:");
            String inputUsername = scanner.nextLine();

            System.out.println("Por favor, ingrese su contraseña:");
            String inputPassword = scanner.nextLine();

            if (inputUsername.equals(username) && inputPassword.equals(password)) {
                System.out.println("Acceso concedido");
                break;
            } else {
                System.out.println("SU USUARIO O CONTRASEÑA ES INCORRECTA");
            }
        }
        Scanner scanner2 = new Scanner(System.in);

        while (true) {
            System.out.println("\nMENU PRINCIPAL:\n ● 1. POSICION CONSOLIDADA\n ● 2. CONSULTAS\n ● 3. GESTION DE CUENTAS\n ● 4. OPERACIONES BANCARIAS\n ● 0. SALIR");
            System.out.println("\nPor favor, elija una opción:");

            String opcion = scanner2.nextLine();
            double saldoAhorro = 100000; // LPS
            double saldoCheques = 10000; // USD
            // Para generar montos aleatorios
            Random rand = new Random();
            switch (opcion) {

                case "1":
                    System.out.println("Has seleccionado POSICION CONSOLIDADA");
                    // Ahora presentamos las cuentas y sus saldos de una vez
                    System.out.printf("✤ . Cuenta de ahorro (LPS): LPS %.2f%n", saldoAhorro);
                    System.out.printf("✤ . Cuenta de cheques (USD): USD %.2f%n", saldoCheques);
                    break;

                case "2":
                    System.out.println("Has seleccionado Consultas");
                    System.out.println("\n✤ 1. Visualizar movimientos de cuentas\n✤ 2. Generar estados de cuenta\n");
                    System.out.println("Por favor, elija una opción:");
                    String opcionConsulta = scanner2.nextLine();
                    switch (opcionConsulta) {
                        case "1":
                            System.out.println("Visualizando movimientos de cuentas:");
                            System.out.printf("%-27s|%-21s|%-21s|%-10s%n", "FECHA", "CUENTA DE ORIGEN", "CUENTA DE DESTINO", "MONTO");
                            System.out.println("--------------------------------------------------------------------------------------------");
                            // Nombres de cuentas posibles
                            String[] posiblesNombres = {"Juan Lopez", "Maria Martinez", "Andres Perez", "Luis Torres", "Patricia Ramirez", "Sury Martinez", "Pablo Barahona", "Mauricio Palma"};

                            // Generamos 10 registros aleatorios
                            for (int i = 0; i < 10; i++) {
                                int horaRandom = 10 + rand.nextInt(13);
                                String minSegRandom = ":" + (10 + rand.nextInt(50)) + ":" + (10 + rand.nextInt(50));
                                String fechaRandom = "Sat Mar " + (15 + rand.nextInt(2)) + " " + horaRandom + minSegRandom + " CST 2024";
                                String cuentaOrigenRandom = "Carlos Montoya";
                                String cuentaDestinoRandom = posiblesNombres[rand.nextInt(posiblesNombres.length)];
                                double montoAleatorio = 500.0 + (2000.0 - 500.0) * rand.nextDouble();
                                System.out.printf("%-27s|%-21s|%-21s|%.2f%n", fechaRandom, cuentaOrigenRandom, cuentaDestinoRandom, montoAleatorio);
                            }
                            break;
                        case "2":
                            System.out.println("Generar estados de cuenta:");
                            System.out.println("Por favor, ingrese el mes y el año:");
                            String fecha = scanner2.nextLine();
                            // Aquí puedes validar la entrada y generar el informe correspondiente
                            System.out.println("Generando estados de cuenta para la fecha especificada...");

                            // Cabecera de la tabla
                            System.out.println("FECHA                   | TRANSACCION         | MONTO");
                            System.out.println("---------------------------------------------------------");

                            // Datos ficticios para la demostración
                            String[] transacciones = {"Depósito", "Retiro", "Pago", "Transferencia"};

                            // Nota: No volvemos a declarar Random rand aquí, usamos el que se declaró al principio

                            // Generar 10 registros aleatorios
                            for (int i = 0; i < 10; i++) {
                                String fechaRandom = "Mar 16 08:48:" + (10 + rand.nextInt(50)) + " CST 2024";
                                String transaccionRandom = transacciones[rand.nextInt(transacciones.length)];
                                double montoRandom = 100.0 + (1000.0 - 100.0) * rand.nextDouble();
                                System.out.printf("%-23s | %-18s | %.2f%n", fechaRandom, transaccionRandom, montoRandom);
                            }
                            break;
                        default:
                            System.out.println("Opción no válida");
                            break;
                    }
                    break;
                case "3":
                    System.out.println("Has seleccionado Gestion de cuenta");
                    crearCuenta();
                    break;
                case "4":
                    System.out.println("Has seleccionado Operaciones Bancarias");
                    System.out.println("\n✤ 1. Depósito\n✤ 2. Retiro");
                    String opcionOperacion = scanner.nextLine();

                    switch (opcionOperacion) {
                        case "1":
                            realizarDeposito();
                            break;
                        case "2":
                            realizarRetiro();
                            break;
                        default:
                            System.out.println("Opción no válida");
                    }
                    break;
                case "0":
                    System.out.println("Has seleccionado Salir");
                    return; // Este comando sale del método `main()`
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public static void crearCuenta() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Por favor, ingrese los siguientes datos:");

        System.out.println("Nombre completo:");
        String nombreCompleto = scanner.nextLine();

        System.out.println("Identidad:");
        String identidad = scanner.nextLine();

        System.out.println("Número de teléfono:");
        String numTelefono = scanner.nextLine();

        // Agrega la cuenta al HashMap con un saldo inicial de 0
        cuentas.put(identidad, 0.0);
        System.out.println("La cuenta ha sido creada exitosamente.");
    }

    public static void realizarDeposito() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("CUENTA ORIGEN:");
        String idOrigen = scanner.nextLine();

        System.out.println("CUENTA DESTINO:");
        String idDestino = scanner.nextLine();

        if (!cuentas.containsKey(idDestino)) {
            System.out.println("La cuenta de destino no existe.");
            return;
        }

        System.out.println("MONTO:");
        Double monto = scanner.nextDouble();

        cuentas.put(idDestino, cuentas.get(idDestino) + monto);

        System.out.println("Su monto fue enviado exitosamente");
    }

    public static void realizarRetiro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Cuenta de ahorro (LPS): LPS " + saldoAhorro);

        System.out.println("MONTO A RETIRAR:");
        Double monto = scanner.nextDouble();

        if (saldoAhorro < monto) {
            System.out.println("El monto a retirar sobrepasa su saldo.");
            return;
        }

        saldoAhorro -= monto;

        System.out.println("Retiro exitoso. Su nuevo saldo es: LPS " + saldoAhorro);
    }
}




