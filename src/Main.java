void main() {
    String opcionTeclado = "0", respuestaOpcion = "0",tarifa_ticket;
    char residenteTeclado, horaSimulada;
    double dinerosIntroducir;
    boolean ejecutar = true;

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
                case "4.3" -> "-1";
                default -> "Esa opcion no existe\n" +
                        "----------------------------";
            };
            IO.println(respuestaOpcion);
            if (opcionTeclado.equals("1")){
                //Hay que configurar lo de simular la hora, si dices que si, la hora la pones tu, si dices que no te coge la hora con el datatime.
                horaSimulada = (IO.readln("Deseas simular la hora?: S/N ").charAt(0));
                residenteTeclado = (IO.readln("Eres residente?: S/N ").charAt(0));
                residenteTeclado = Character.toUpperCase(residenteTeclado);
                tarifa_ticket = switch (residenteTeclado){
                    case 'S'-> "Duracion\tResidentes:\n" +
                            " 00:15:00   0.10 €\n 00:29:50   0.20 €\n 00:59:31   0.40 €\n 01:29:12   0.60 €\n 02:00:00   0.80 €";
                    case 'N'-> "Duracion\tNo residentes:\n" +
                            " 00:15:00   0.25 €\n 00:29:50   0.45 €\n 00:59:31   0.85 €\n 01:29:12   1.25 €\n 02:00:00   1.70 €";
                    default -> "Parametro introducido erroneo";
                };
                IO.println("Tus tarifas son:\n "+tarifa_ticket);
                dinerosIntroducir = Double.parseDouble(IO.readln("Introduce la cantidad de € a introducir: "));
                if (residenteTeclado == 'S'){

                    if (dinerosIntroducir < 0) IO.println("Cantidad negativa");
                if (dinerosIntroducir < 0.10 && dinerosIntroducir > 0) IO.println("Dinero Insuficiente");
                if (dinerosIntroducir >= 0.10 && dinerosIntroducir < 0.20) IO.println("Has pagado por 15 minutos de estacionamiento");
                if (dinerosIntroducir >= 0.20 && dinerosIntroducir < 0.40) IO.println("Has pagado por 29 minutos y 50 segundos de estacionamiento");
                if (dinerosIntroducir >= 0.40 && dinerosIntroducir < 0.60) IO.println("Has pagado por 59 minutos y 31 segundos de estacionamiento");
                if (dinerosIntroducir >= 0.60 && dinerosIntroducir < 0.80) IO.println("Has pagado por 1 hora, 29 minutos y 12 segundos de estacionamiento");
                if (dinerosIntroducir >= 0.80) IO.println("Has pagado por 2 horas de estacionamiento");


                }
                if (residenteTeclado == 'N'){
                    if (dinerosIntroducir < 0) IO.println("Cantidad negativa");
                    if (dinerosIntroducir < 0.25 && dinerosIntroducir > 0) IO.println("Dinero Insuficiente");
                    if (dinerosIntroducir >= 0.25 && dinerosIntroducir < 0.45) IO.println("Has pagado por 15 minutos de estacionamiento");
                    if (dinerosIntroducir >= 0.45 && dinerosIntroducir < 0.85) IO.println("Has pagado por 29 minutos y 50 segundos de estacionamiento");
                    if (dinerosIntroducir >= 0.85 && dinerosIntroducir < 1.25) IO.println("Has pagado por 59 minutos y 31 segundos de estacionamiento");
                    if (dinerosIntroducir >= 1.25 && dinerosIntroducir < 1.70) IO.println("Has pagado por 1 hora, 29 minutos y 12 segundos de estacionamiento");
                    if (dinerosIntroducir >= 1.70) IO.println("Has pagado por 2 horas de estacionamiento");
                }
                //GENERAR TICKET CON CODIGO UNICO
            }
        }

    }while (ejecutar);



}
