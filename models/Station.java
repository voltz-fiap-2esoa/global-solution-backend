package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** Estação de monitoramento. */
public class Station {

    private Long id;
    private String name;
    private GeoCoordinate location;
    private SeverityLevel riskLevel;
    private int humidity;              // %
    private double groundMovement;     // mm
    private LocalDateTime lastUpdate;
    private final List<Alert> alerts = new ArrayList<>();

    /* === Construtores === */
    public Station() { }
    public Station(Long id, String name, GeoCoordinate location,
                   SeverityLevel riskLevel, int humidity,
                   double groundMovement, LocalDateTime lastUpdate) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.riskLevel = riskLevel;
        this.humidity = humidity;
        this.groundMovement = groundMovement;
        this.lastUpdate = lastUpdate;
    }

    /* === Associação bidirecional utilitária === */
    public void addAlert(Alert alert) {
        alerts.add(alert);
        alert.setStation(this);
    }
    
    public void removeAlert(Alert alert) {
        alerts.remove(alert);
        alert.setStation(null);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public GeoCoordinate getLocation() { return location; }
    public void setLocation(GeoCoordinate location) { this.location = location; }

    public SeverityLevel getRiskLevel() { return riskLevel; }
    public void setRiskLevel(SeverityLevel riskLevel) { this.riskLevel = riskLevel; }

    public int getHumidity() { return humidity; }
    public void setHumidity(int humidity) { this.humidity = humidity; }

    public double getGroundMovement() { return groundMovement; }
    public void setGroundMovement(double groundMovement) { this.groundMovement = groundMovement; }

    public LocalDateTime getLastUpdate() { return lastUpdate; }
    public void setLastUpdate(LocalDateTime lastUpdate) { this.lastUpdate = lastUpdate; }

    public List<Alert> getAlerts() { return alerts; }

    /* === equals & hashCode baseados no id === */
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Station s)) return false;
        return Objects.equals(id, s.id);
    }
    @Override public int hashCode() { return Objects.hash(id); }
}