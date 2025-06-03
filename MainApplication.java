import java.time.LocalDateTime;
import models.Alert;
import models.AlertStatus;
import models.GeoCoordinate;
import models.SeverityLevel;
import models.Station;

public class MainApplication {
    public static void main(String[] args) {
        Station estacao = new Station(
                1L,
                "Estação Serra Verde",
                new GeoCoordinate(-23.5505, -46.6333),
                SeverityLevel.HIGH,
                85,
                2.3,
                LocalDateTime.now());

        Alert alerta = new Alert(
                1L,
                SeverityLevel.CRITICAL,
                "Movimento do solo detectado acima do limite crítico (4.1 mm). Evacuação imediata recomendada.",
                LocalDateTime.of(2024, 1, 15, 14, 30, 25),
                AlertStatus.ACTIVE,
                "Bairro Encosta Norte – 150 famílias",
                new GeoCoordinate(-23.5705, -46.6533));

        estacao.addAlert(alerta);

        System.out.println("Estação: " + estacao.getName());
        System.out.println("Localização: " + estacao.getLocation());
        System.out.println("Nível de risco: " + estacao.getRiskLevel());
        System.out.println("Umidade: " + estacao.getHumidity() + "%");
        System.out.println("Movimento do solo: " + estacao.getGroundMovement() + " mm");
        System.out.println("Última atualização: " + estacao.getLastUpdate());

        for (Alert a : estacao.getAlerts()) {
            System.out.println("\nAlerta ID: " + a.getId());
            System.out.println("Nível: " + a.getLevel());
            System.out.println("Mensagem: " + a.getMessage());
            System.out.println("Data/Hora: " + a.getTimestamp());
            System.out.println("Status: " + a.getStatus());
            System.out.println("Área afetada: " + a.getAffectedArea());
            System.out.println("Localização do alerta: " + a.getLocation());
        }
    }
}
