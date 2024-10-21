package utils;

public enum TipoAsiento {
    NORMAL(100.0),
    VIP(200.0),
    PREMIUM(400.0);
    private Double costo;

    TipoAsiento(Double costo) {
        this.costo = costo;
    }

    //--------------Getters y Setters-------------
    public Double getCosto() {
        return costo;
    }

}

