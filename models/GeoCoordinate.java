package models;

/** Representa um ponto geoespacial (latitude / longitude). */
public record GeoCoordinate(double lat, double lng) {
    public GeoCoordinate {
        if (lat < -90 || lat > 90)
            throw new IllegalArgumentException("Latitude fora do intervalo válido.");
        if (lng < -180 || lng > 180)
            throw new IllegalArgumentException("Longitude fora do intervalo válido.");
    }

    @Override
    public String toString() {
        return String.format("GeoCoordinate{lat=%.6f, lng=%.6f}", lat, lng);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof GeoCoordinate)) return false;
        GeoCoordinate that = (GeoCoordinate) o;
        return Double.compare(that.lat, lat) == 0 && Double.compare(that.lng, lng) == 0;
    }
}