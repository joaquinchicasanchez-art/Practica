import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
void main() throws InterruptedException {
    String opcionTeclado = "0", respuestaOpcion = "0", tarifa_ticket, codigoRevertido;
    char residenteTeclado = 0, horaSimulada;
    double dinerosIntroducir = 0;
    boolean ejecutar = true;
    int dinerosCentimos = 0, contadorTicket = 1, intentosIntroducirCodigo = 5;
    String tiempo_salida = "", codigoTicket = "", nombrePersonaTicket = "", codigoTeclado = "";

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

        //Menu (Quiza quitarle los 2.1,2.2,4.1,etc)//
        IO.println("""
                \n1. Obtener un ticket
                2. Anular una multa
                \t2.1 Por exceder el tiempo permitido
                \t2.2 Por carecer de ticket
                3. Consultar fecha y hora actual, tarifas y horarios
                4. Menu de administrador
                \t4.1 Dinero ingresado en tickets y tickets generados
                \t4.2 Dinero ingresado por multas y multas anuladas
                \t4.3 Apagar el software
                """);

        opcionTeclado = IO.readln("Introduce un numero del 1 al 4: ");

        //Con esto si pongo 4.3 me salgo del menu

        if (opcionTeclado.equals("4.3")) {
            ejecutar = false;
            IO.println("Has salido del sistema correctamente");

        } else {
            switch (opcionTeclado) {
                case "1" -> {
                    IO.println("Proceso para obtener un ticket\n" +
                            "-------------------------------");
                    Thread.sleep(1000);
                    for (int i = 0; i < 45; i++) {
                        IO.println();
                    }
                    //Hay que configurar lo de simular la hora, si dices que si, la hora la pones tu, si dices que no te coge la hora con el datatime.
                    nombrePersonaTicket = IO.readln("Introduzca su nombre: ");
                    horaSimulada = (IO.readln("Deseas simular la hora?: S/N ").charAt(0));
                    residenteTeclado = (IO.readln("Eres residente?: S/N ").charAt(0));
                    residenteTeclado = Character.toUpperCase(residenteTeclado);
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

                        if (dinerosIntroducir < 0) IO.println("Cantidad negativa");

                        if (dinerosIntroducir < 0.10 && dinerosIntroducir >= 0) IO.println("Dinero Insuficiente");

                        if (dinerosIntroducir >= 0.10 && dinerosIntroducir < 0.20)
                            tiempo_salida = "15 minutos";

                        if (dinerosIntroducir >= 0.20 && dinerosIntroducir < 0.40)
                            tiempo_salida = "29 minutos y 50 segundos";

                        if (dinerosIntroducir >= 0.40 && dinerosIntroducir < 0.60)
                            tiempo_salida = "59 minutos y 31 segundos";

                        if (dinerosIntroducir >= 0.60 && dinerosIntroducir < 0.80)
                            tiempo_salida = "1 hora, 29 minutos y 12 segundos";

                        if (dinerosIntroducir >= 0.80)
                            tiempo_salida = "2 horas";

                        dinerosCentimos = (int) Math.round(dinerosIntroducir * 100);;

                        codigoTicket = "MAR" + (((contadorTicket * 10000) + dinerosCentimos) * 7);
                        //TODO: para deshacer el codigo es substring (3) y / 7

                        if (dinerosIntroducir >= 0.10) {
                            contadorTicket ++;
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
                                    """.formatted(codigoTicket, "Residente", nombrePersonaTicket, dinerosIntroducir, tiempo_salida, "sin hacer", "sin hacer"));
                        }
                    }

                    if (residenteTeclado == 'N') {
                        if (dinerosIntroducir < 0) IO.println("Cantidad negativa");

                        if (dinerosIntroducir < 0.25 && dinerosIntroducir > 0) IO.println("Dinero Insuficiente");

                        if (dinerosIntroducir >= 0.25 && dinerosIntroducir < 0.45)
                            tiempo_salida = "15 minutos";

                        if (dinerosIntroducir >= 0.45 && dinerosIntroducir < 0.85)
                            tiempo_salida = "29 minutos y 50 segundos";

                        if (dinerosIntroducir >= 0.85 && dinerosIntroducir < 1.25)
                            tiempo_salida = "59 minutos y 31 segundos";

                        if (dinerosIntroducir >= 1.25 && dinerosIntroducir < 1.70)
                            tiempo_salida = "1 hora, 29 minutos y 12 segundos";

                        if (dinerosIntroducir >= 1.70)
                            tiempo_salida = "2 horas";

                        dinerosCentimos = (int) Math.round(dinerosIntroducir * 100);
                        //FIXME: ARREGLADO LO DE LOS CENTIMOS CON MATH.ROUND

                        codigoTicket = "MAR" + (((contadorTicket * 10000) + dinerosCentimos) * 7);
                        //TODO: para deshacer el codigo es substring (3) y / 7

                        if (dinerosIntroducir >= 0.25) {
                            contadorTicket ++;
                            IO.println("""
                                    +-----------------------------------+
                                    |            ZONA AZUL              |
                                    |     TICKET DE APARCAMIENTO        |
                                    +-----------------------------------+
                                    | Código:    %-22s |
                                    | Cliente:   %-22s |
                                    | Nombre:    %-22s  |
                                    | Importe:   %-6.2f €                |
                                    | Tiempo:    %-22s |
                                    +-----------------------------------+
                                    |    ¡Gracias por su visita!        |
                                    +-----------------------------------+
                                    """.formatted(codigoTicket, "No Residente", nombrePersonaTicket, dinerosIntroducir, tiempo_salida));
                        }
                    }
                }


                case "2", "2.1", "2.2" -> {
                    IO.println("Proceso para anular una multa\n" +
                            "-------------------------------");
                    if (codigoTicket.equals(""))IO.println("No hay ninguna multa introducida");
                    else {
                        do {
                            codigoTeclado = IO.readln("Introduce tu codigo de tu ticket (%d/5): ".formatted(intentosIntroducirCodigo));
                            if (codigoTeclado.equals(codigoTicket)) {
                                IO.println("Codigo introducido incorrecto o no existe");
                                IO.readln("Presiona enter para volver a intentar: ");
                                intentosIntroducirCodigo --;

                            }
                        }while (codigoTeclado.equals(codigoTicket) || intentosIntroducirCodigo == 0);

                            IO.println("Hola %s , codigo introducido correcto".formatted(nombrePersonaTicket));


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


            //TODO: introducir thread.sleep(milisegundos), implementar lo de simular la hora
            if (ejecutar == true) {
                IO.println("\nPresione ENTER para volver a empezar...");
                IO.readln();
            }
        }
    } while (ejecutar);
}
