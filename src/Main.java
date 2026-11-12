import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

void main() throws InterruptedException {
    final int IDENTIFICADOR = 4096;
    String opcionTeclado = "", respuestaOpcion = "", tarifa_ticket = "", tiempo_salida = "", codigoTicket = "",
            nombrePersonaTicket = "", codigoTeclado = "";
    char residenteTeclado = 0, horaSimulada;
    double dinerosIntroducir = 0, cantidadAbonadaAnulo = 0, dineroAcumulativoMultas = 0, dineroAcumuladoTicket = 0;
    boolean ejecutar = true, dineroSuficiente = true;
    int dinerosCentimos = 0, contadorTicket = 1, intentosIntroducirCodigo, numMultas = 0, codigoRevertido,
            horasAniadir, minutosAniadir, segundosAniadir, codigoTecladoEntero;

    do {

        IO.println("""
                
                [ ZONA AZUL - MARTOS ]
                   ______
                  /|_||_.__
                 (   _    _ _\\
                 =`-(_)--(_)-'
                ======================
                 _   _   _   _   _   _
                ======================
                
                """);


        IO.println("""
                1. Obtener un ticket
                2. Anular una multa
                3. Consultar fecha y hora actual, tarifas y horarios
                4. Menu de administrador
                """);
        // Introducimos el menu y pedimos un numero para seleccionarlo
        opcionTeclado = IO.readln("Introduce un numero del 1 al 4: ");


        switch (opcionTeclado) {
            case "1" -> {
                IO.println("Proceso para obtener un ticket\n" +
                        "-------------------------------");


                Thread.sleep(1000);
                for (int i = 0; i < 45; i++) {
                    IO.println();
                }

                //todo Hay que configurar lo de simular la hora, si dices que si, la hora la pones tu, si dices que no te coge la hora con el datatime.

                // Preguntamos el nombre, si quiere simular la hora y si es residente
                nombrePersonaTicket = IO.readln("Introduzca su nombre: ");
                horaSimulada = (IO.readln("Deseas simular la hora?: S/N ").charAt(0));
                residenteTeclado = (IO.readln("Eres residente?: S/N ").charAt(0));

                //Nos aseguramos que la letra este en mayuscula para que el switch no de problemas
                residenteTeclado = Character.toUpperCase(residenteTeclado);
                horaSimulada = Character.toUpperCase(horaSimulada);

                //Imprimimos los precios dependiendo si es residente o no

                tarifa_ticket = switch (residenteTeclado) {
                    case 'S' -> """
                            Duracion\tResidentes:
                             00:15:00   0.10 €
                             00:29:50   0.20 €
                             00:59:31   0.40 €
                             01:29:12   0.60 €
                             02:00:00   0.80 €""";
                    case 'N' -> """
                            Duracion\tNo residentes:
                             00:15:00   0.25 €
                             00:29:50   0.45 €
                             00:59:31   0.85 €
                             01:29:12   1.25 €
                             02:00:00   1.70 €""";
                    default -> "Parametro introducido erroneo";
                };

                IO.println("Tus tarifas son:\n " + tarifa_ticket);
                dinerosIntroducir = Double.parseDouble(IO.readln("Introduce la cantidad de € a introducir: "));

                if (residenteTeclado == 'S') {

                    if (dinerosIntroducir < 0) {
                        IO.println("Cantidad negativa");
                        dineroSuficiente = false;
                    }

                    if (dinerosIntroducir < 0.10 && dinerosIntroducir > 0) {
                        IO.println("Dinero Insuficiente");
                        dineroSuficiente = false;
                    }
                    if (dinerosIntroducir >= 0.10) dineroSuficiente = true;

                    if (dinerosIntroducir >= 0.10 && dinerosIntroducir < 0.20) {
                        tiempo_salida = "15 minutos";
                        horasAniadir = 0;
                        minutosAniadir = 15;
                        segundosAniadir = 0;
                    }
                    if (dinerosIntroducir >= 0.20 && dinerosIntroducir < 0.40) {
                        tiempo_salida = "29 minutos y 50 segundos";
                        horasAniadir = 0;
                        minutosAniadir = 29;
                        segundosAniadir = 50;
                    }
                    if (dinerosIntroducir >= 0.40 && dinerosIntroducir < 0.60) {
                        tiempo_salida = "59 minutos y 31 segundos";
                        horasAniadir = 0;
                        minutosAniadir = 59;
                        segundosAniadir = 31;
                    }
                    if (dinerosIntroducir >= 0.60 && dinerosIntroducir < 0.80) {
                        tiempo_salida = "1 hora, 29 minutos y 12 segundos";
                        horasAniadir = 1;
                        minutosAniadir = 29;
                        segundosAniadir = 12;
                    }

                    if (dinerosIntroducir >= 0.80) {
                        tiempo_salida = "2 horas";
                        horasAniadir = 2;
                        minutosAniadir = 0;
                        segundosAniadir = 0;
                    }




                }

                if (residenteTeclado == 'N') {

                    if (dinerosIntroducir < 0) {
                        IO.println("Cantidad negativa");
                        dineroSuficiente = false;
                    }

                    if (dinerosIntroducir < 0.25 && dinerosIntroducir > 0) {
                        IO.println("Dinero Insuficiente");
                        dineroSuficiente = false;
                    }
                    if (dinerosIntroducir >= 0.25) dineroSuficiente = true;

                    if (dinerosIntroducir >= 0.25 && dinerosIntroducir < 0.45) {
                        tiempo_salida = "15 minutos";
                        horasAniadir = 0;
                        minutosAniadir = 15;
                        segundosAniadir = 0;
                    }
                    if (dinerosIntroducir >= 0.45 && dinerosIntroducir < 0.85) {
                        tiempo_salida = "29 minutos y 50 segundos";
                        horasAniadir = 0;
                        minutosAniadir = 29;
                        segundosAniadir = 50;
                    }
                    if (dinerosIntroducir >= 0.85 && dinerosIntroducir < 1.25) {
                        tiempo_salida = "59 minutos y 31 segundos";
                        horasAniadir = 0;
                        minutosAniadir = 59;
                        segundosAniadir = 31;
                    }
                    if (dinerosIntroducir >= 1.25 && dinerosIntroducir < 1.70) {
                        tiempo_salida = "1 hora, 29 minutos y 12 segundos";
                        horasAniadir = 1;
                        minutosAniadir = 29;
                        segundosAniadir = 12;
                    }

                    if (dinerosIntroducir >= 1.70) {
                        tiempo_salida = "2 horas";
                        horasAniadir = 2;
                        minutosAniadir = 0;
                        segundosAniadir = 0;
                    }


                }

                if (dineroSuficiente) {
                    //Generamos el ticket multiplicando por un identificador que vale 4096

                    dinerosCentimos = (int) Math.round(dinerosIntroducir * 100);

                    codigoTicket = "MAR" + (dinerosCentimos * IDENTIFICADOR);

                    contadorTicket++;
                    dineroAcumuladoTicket += dinerosIntroducir;
                    IO.println("""
                                +-----------------------------------+
                                |            ZONA AZUL              |
                                |     TICKET DE APARCAMIENTO        |
                                +-----------------------------------+
                                | Código:    %-22s |
                                | Cliente:   %-22s |
                                | Nombre:    %-22s |
                                | Importe:   %-6.2f €                |
                                | Tiempo:    %-22s |
                                | Fecha:      %-22s |
                                | Fecha límite: %-22s |
                                +-----------------------------------+
                                |    ¡Gracias por su visita!        |
                                +-----------------------------------+
                                """.formatted(codigoTicket, "Residente", nombrePersonaTicket, dinerosIntroducir,
                            tiempo_salida, "sin hacer", "sin hacer"));
                }
            }












            case "2" -> {

                do {
                    IO.println("""
                        MENU DE ANULACION DE MULTAS
                        ============================
                        1. Exceder el tiempo permitido (3€)
                        2. Carecer de ticket (6€)
                        """);

                    respuestaOpcion = IO.readln("Introduce respuesta (1-2): ");
                    if (respuestaOpcion != "1" || respuestaOpcion != "2") {
                        IO.println("Esa opcion no existe");
                    }
                } while (respuestaOpcion != "1" || respuestaOpcion != "2" );

                if (respuestaOpcion.equals("1")){


                    do {
                        codigoTeclado = IO.readln("Introduce el codigo del ticket que usastes: ");
                        codigoTecladoEntero = Integer.parseInt(codigoTeclado.substring(3));
                        if (codigoTeclado.substring(0,))
                    }while (codigoTecladoEntero % IDENTIFICADOR != 0)

                } else {

                }

            }
            case "3" -> {
                IO.println("Consultorio de fecha y hora actual, tarifas y horarios\n" +
                        "----------------------------------------------------------");
            }

            case "4", "4.1", "4.2" -> {
                IO.println("Proceso para entrar en el menu administrador\n" +
                        "-----------------------------------");
            }
            default -> {
                IO.println("Esa opcion no existe\n" +
                        "----------------------------");
            }
        }


        if (ejecutar == true) {
            IO.println("\nPresione ENTER para volver a empezar...");
            IO.readln();
        }

    } while (ejecutar);
}
