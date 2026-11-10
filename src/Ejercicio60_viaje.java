void main() throws InterruptedException {
    double gasto1 = 0, gasto2 = 0, gasto3 = 0, gasto4 = 0, gasto5 = 0, media = 0, suma = 0, paga1 = 0,
            paga2 = 0, paga3 = 0, paga4 = 0, paga5 = 0;
    int contador = 2;
    boolean puntero = true;
    String pagarDeber;



    do {
        IO.println("""
                1. Introducir los gastos de los viajeros
                2. Calcular el reparto
                3. Mostrar el reparto
                4. Salir
                """);
        int menu = Integer.parseInt(IO.readln("Introduce un numero para elegir: "));
        switch (menu) {
            case 1 -> {
                gasto1 = Integer.parseInt(IO.readln("Introduce cuanto se ha gastado el primero: "));

                gasto2 = Integer.parseInt(IO.readln("Introduce cuanto se ha gastado el segundo: "));

                gasto3 = Integer.parseInt(IO.readln("Introduce cuanto se ha gastado el tercero (Introduce -1 si no existe): "));
                if (gasto3 != -1) contador++;
                else gasto3 = 0;

                gasto4 = Integer.parseInt(IO.readln("Introduce cuanto se ha gastado el cuarto (Introduce -1 si no existe): "));
                if (gasto4 != -1) contador++;
                else gasto4 = 0;

                gasto5 = Integer.parseInt(IO.readln("Introduce cuanto se ha gastado el quinto (Introduce -1 si no existe): "));
                if (gasto5 != -1) contador++;
                else gasto5 = 0;
            }
            case 2 -> {
                if (gasto1 == 0 || gasto2 == 0) {
                    IO.println();
                    IO.println("No has introducido los datos suficientes");
                    Thread.sleep(2000);
                    for (int i = 0; i < 50; i++) {
                        IO.println();
                    }
                } else {
                    suma = gasto1 + gasto2 + gasto3 + gasto4 + gasto5;
                    media = suma / contador;
                    IO.println("Cada persona debe pagar %.2f".formatted(media));

                    paga1 = media - gasto1;
                    paga2 = media - gasto2;
                    paga3 = media - gasto3;
                    paga4 = media - gasto4;
                    paga5 = media - gasto5;
                }
            }
            case 3 -> {
                if (gasto1 == 0 || gasto2 == 0) IO.println("No has introducido los datos suficientes");
                else {
                    if (paga1 >= 0) pagarDeber = "pagar";
                    else {
                        pagarDeber = "recibir";
                        paga1 = Math.abs(paga1);
                    }
                    IO.println("El primero se ha gastado %.2f, debe %s %.2f €".formatted(gasto1, pagarDeber, paga1));

                    if (paga2 >= 0) pagarDeber = "pagar";
                    else {
                        pagarDeber = "recibir";
                        paga2 = Math.abs(paga2);
                    }
                    IO.println("El segundo se ha gastado %.2f, debe %s %.2f €".formatted(gasto2, pagarDeber, paga2));

                    if (contador >= 3) {
                        if (paga3 >= 0) pagarDeber = "pagar";
                        else {
                            pagarDeber = "recibir";
                            paga3 = Math.abs(paga3);
                        }
                        IO.println("El tercero se ha gastado %.2f, debe %s %.2f €".formatted(gasto3, pagarDeber, paga3));
                    }


                    if (contador >= 4) {
                        if (paga4 >= 0) pagarDeber = "pagar";
                        else {
                            pagarDeber = "recibir";
                            paga4 = Math.abs(paga4);
                        }
                        IO.println("El cuarto se ha gastado %.2f, debe %s %.2f €".formatted(gasto4, pagarDeber, paga4));
                    }
                    if (contador >= 5) {
                        if (paga5 >= 0) pagarDeber = "pagar";
                        else {
                            pagarDeber = "recibir";
                            paga5 = Math.abs(paga5);
                        }
                        IO.println("El quinto se ha gastado %.2f, debe %s %.2f €".formatted(gasto5, pagarDeber, paga5));
                    }
                }
            }
            case 4 -> {
                IO.println("Programa finalizado, ¡¡hasta la proxima!!");
                puntero = false;
            }
        }
    } while (puntero);

}