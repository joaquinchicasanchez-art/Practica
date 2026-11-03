import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
void main() {

    LocalDateTime ahora = LocalDateTime.now();
    LocalDateTime fin = ahora.plusMinutes(89).plusSeconds(12);   // tramo de 01:29:12

    int hora = ahora.getHour();
    int diaSemana = ahora.getDayOfWeek().getValue();   // 1 = lunes … 7 = domingo

    long minutosQueQuedan = ChronoUnit.MINUTES.between(ahora, fin);
    IO.println(fin);
}