import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
void main() {
    String opcionTeclado = "0", respuestaOpcion = "0",tarifa_ticket;
    char residenteTeclado = 0, horaSimulada;
    double dinerosIntroducir = 0;
    boolean ejecutar = true;
    int dinerosCentimos = 0;
    String tiempo_salida = "", codigoTicket = "", nombrePersonaTicket = "";

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

        if (opcionTeclado.equals("4.3")){
            ejecutar=false;
            IO.println("Has salido del sistema correctamente");

        }else {
            respuestaOpcion = switch (opcionTeclado){
                case "1" -> "Proceso para obtener un ticket\n" +
                        "-------------------------------";
                case "2","2.1","2.2" -> "Proceso para anular una multa\n" +
                        "-------------------------------";
                case "3" -> "Consultorio de fecha y hora actual, tarifas y horarios\n" +
                        "----------------------------------------------------------";

                case "4","4.1","4.2" -> "Proceso para entrar en el menu administrador\n" +
                        "-----------------------------------";
                default -> "Esa opcion no existe\n" +
                        "----------------------------";
            };
            IO.println(respuestaOpcion);
            if (opcionTeclado.equals("1")){
                //Hay que configurar lo de simular la hora, si dices que si, la hora la pones tu, si dices que no te coge la hora con el datatime.
                nombrePersonaTicket = IO.readln("Introduzca su nombre: ");
                horaSimulada = (IO.readln("Deseas simular la hora?: S/N ").charAt(0));
                residenteTeclado = (IO.readln("Eres residente?: S/N ").charAt(0));
                residenteTeclado = Character.toUpperCase(residenteTeclado);
                tarifa_ticket = switch (residenteTeclado){
                    case 'S'-> """
                            Duracion\tResidentes:
                             00:15:00   0.10 €
                             00:29:50   0.20 €
                             00:59:31   0.40 €
                             01:29:12   0.60 €
                             02:00:00   0.80 €""";
                    case 'N'-> """
                            Duracion\tNo residentes:
                             00:15:00   0.25 €
                             00:29:50   0.45 €
                             00:59:31   0.85 €
                             01:29:12   1.25 €
                             02:00:00   1.70 €""";
                    default -> "Parametro introducido erroneo";
                };

                IO.println("Tus tarifas son:\n "+tarifa_ticket);
                dinerosIntroducir = Double.parseDouble(IO.readln("Introduce la cantidad de € a introducir: "));

                if (residenteTeclado == 'S'){

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

                dinerosCentimos = (int) (dinerosIntroducir * 100)*4;
                //FIXME: Al castear un numero por ejemplo 1.13, la variable se trunca y se queda con 1.1299999999999
                String centimosString = String.valueOf(dinerosCentimos);

                codigoTicket = "MAR" + centimosString + nombrePersonaTicket.substring(2) ;
                if (dinerosIntroducir >= 0.10){

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
            """.formatted(codigoTicket, "Residente",nombrePersonaTicket, dinerosIntroducir, tiempo_salida));
                }
                    }

                }
                if (residenteTeclado == 'N'){
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

                    dinerosCentimos = (int) (dinerosIntroducir * 100)*4;
                    //FIXME: Al castear un numero por ejemplo 1.13, la variable se trunca y se queda con 1.1299999999999
                    String centimosString = String.valueOf(dinerosCentimos);

                    codigoTicket = "MAR" + centimosString + nombrePersonaTicket.substring(2) ;
                    if (dinerosIntroducir >= 0.25){
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
            """.formatted(codigoTicket, "No Residente",nombrePersonaTicket, dinerosIntroducir, tiempo_salida));
                    }
                }
            }
        //TODO: introducir thread.sleep(milisegundos), implementar lo de simular la hora
        if (ejecutar == true) {
            IO.println("\nPresione ENTER para volver a empezar...");
            IO.readln();
        }
        }while (ejecutar);
}
