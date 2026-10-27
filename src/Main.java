void main() {
    String opcionTeclado = "0", respuestaOpcion = "0",tarifa_ticket;
    int residenteTeclado = 0;
    boolean ejecutar = true;
    while (ejecutar == true){

        IO.println("""
            \n1. Obtener un ticket
            2. Anular una multa
            \t2.1. Por exceder el tiempo permitido
            \t2.2 Por carecer de ticket
            3. Consultar fecha y hora actual, tarifas y horarios
            4. Menu de administrador
            \t4.1 Dinero ingresado en tickets y tickets generados
            \t4.2 Dinero ingresado por multas y multas anuladas
            \t4.3 Apagar el software
            """);
        opcionTeclado = IO.readln("Introduce un numero del 1 al 4: ");
        if (opcionTeclado.equals("-1")){
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

                case "4","4.1","4.2","4.3" -> "Proceso para entrar en el menu administrador\n" +
                        "-----------------------------------";
                default -> "Esa opcion no existe\n" +
                        "----------------------------";
            };
            IO.println(respuestaOpcion);
            if (opcionTeclado.equals("1")){
                IO.println("Eres residente?:\n1. Si\n2. No ");
                residenteTeclado = Integer.parseInt(IO.readln("Introduce 1 si eres residente o 2 si no lo eres "));
                tarifa_ticket = switch (residenteTeclado){
                    case 1-> "Duracion\tResidentes:\n" +
                            "00:15:00 - 0.10 €\n00:29:50 - 0.20 €\n00:59:31 - 0.40 €\n01:29:12 - 0.60 €\n02:00:00 - 0.80 €";
                    case 2-> "Duracion\tNo residentes:\n" +
                            "00:15:00 - 0.25 €\n00:29:50 - 0.45 €\n00:59:31 - 0.85 €\n01:29:12 - 1.25 €\n02:00:00 - 1.70 €";
                    default -> "Parametro introducido erroneo";
                };
                IO.println("Tus tarifas son:\n "+tarifa_ticket);
            }
        }

    }


}
