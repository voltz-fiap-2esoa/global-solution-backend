package models;

import java.time.LocalDateTime;
import java.util.Objects;

/** Alerta gerado por uma estação. */
public class Alert {

    private Long id;
    private Station station;           // many-to-one
    private SeverityLevel level;
    private String message;
    private LocalDateTime timestamp;
    private AlertStatus status;
    private String affectedArea;
    private GeoCoordinate location;    // ponto central da área afetada

    /* === Construtores === */
    public Alert() { }
    public Alert(Long id, SeverityLevel level, String message,
                 LocalDateTime timestamp, AlertStatus status,
                 String affectedArea, GeoCoordinate location) {
        this.id = id;
        this.level = level;
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
        this.affectedArea = affectedArea;
        this.location = location;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Station getStation() { return station; }
    void setStation(Station station) { this.station = station; }

    public SeverityLevel getLevel() { return level; }
    public void setLevel(SeverityLevel level) { this.level = level; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public AlertStatus getStatus() { return status; }
    public void setStatus(AlertStatus status) { this.status = status; }

    public String getAffectedArea() { return affectedArea; }
    public void setAffectedArea(String affectedArea) { this.affectedArea = affectedArea; }

    public GeoCoordinate getLocation() { return location; }
    public void setLocation(GeoCoordinate location) { this.location = location; }


    /* === equals & hashCode baseados no id === */
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Alert a)) return false;
        return Objects.equals(id, a.id);
    }
    @Override public int hashCode() { return Objects.hash(id); }
}