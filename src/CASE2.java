void main() {
    intentosIntroducirCodigo = 5;
    IO.println("Proceso para anular una multa\n" +
            "-------------------------------");
    if (codigoTicket.isEmpty()) IO.println("No hay ninguna multa introducida");

    do {
        codigoTeclado = IO.readln("Introduce tu codigo de tu ticket (%d/5): ".formatted(intentosIntroducirCodigo));
        intentosIntroducirCodigo--;

        if (!codigoTeclado.equals(codigoTicket)) {
            IO.println("Codigo introducido incorrecto o no existe");

        }
    } while (!codigoTeclado.equals(codigoTicket) && intentosIntroducirCodigo > 0);

    codigoRevertido = Integer.parseInt(codigoTeclado.substring(3));
    if (codigoRevertido % 7 == 0) {
        IO.println("Hola %s , codigo introducido correcto".formatted(nombrePersonaTicket));
        IO.println("""
                                    
                                    Causas para una multa
                                    \t1 Por exceder el tiempo permitido (3€)
                                    \t2 Por carecer de ticket (6€)
                                    
                                    """);
        int respuestaMenu2 = Integer.parseInt(IO.readln("Introduce numero (1-2): "));

        if (respuestaMenu2 == 1) {
            do {
                IO.println("""
                                            
                                            Anotaciones:
                                            
                                            \tEl dinero se puede meter en varios intentos
                                            \tLa maquina no da cambio
                                            """);
                cantidadAbonadaAnulo += Double.parseDouble(IO.readln("Introduce 3€ para anular la multa: "));
            } while (cantidadAbonadaAnulo < 3.00);
            //TODO: ESTAS DOS LINEAS ESTAN PENSADAS PARA EL PUNTO 4, QUE HAY QUE CALCULAR EL TOTAL RECAUDADO Y NUMERO DE MULTAS
            IO.println("Multa pagada");
            codigoTicket = "";
            cantidadAbonadaAnulo = 0;
            dineroAcumulativoMultas += cantidadAbonadaAnulo;
            numMultas += 1;

        }
        if (respuestaMenu2 == 2) {
            do {
                IO.println(cantidadAbonadaAnulo);
                IO.println("""
                                            
                                            Anotaciones: 
                                            
                                            \tEl dinero se puede meter en varios intentos
                                            \tLa maquina no da cambio
                                            """);
                cantidadAbonadaAnulo += Double.parseDouble(IO.readln("Introduce 6€ para anular la multa: "));
            } while (cantidadAbonadaAnulo < 6.00);
            //TODO: ESTAS DOS LINEAS ESTAN PENSADAS PARA EL PUNTO 4, QUE HAY QUE CALCULAR EL TOTAL RECAUDADO Y NUMERO DE MULTAS
            IO.println("Multa pagada");
            codigoTicket = "";
            //TODO: LE DAMOS ESTE VALOR AL TICKET PARA QUE SE BORRE DE LA VARIABLE
            cantidadAbonadaAnulo = 0;
            //TODO: CANTIDADABONADA A 0 PARA QUE NO SE GUARDE EL DINERO
            dineroAcumulativoMultas += cantidadAbonadaAnulo;
            numMultas += 1;
        }
    } else {
        IO.println("Codigo invalido");
    }


}
}