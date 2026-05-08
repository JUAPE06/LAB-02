package com.laboratorio.proyectoucv;

public class Embarque {
    private String codigo;
    private String distribuidor;
    private String tipoLadrillo;
    private String tipoCamion;
    private int cantidad;

    public Embarque(String codigo, String distribuidor, String tipoLadrillo, String tipoCamion, int cantidad) {
        this.codigo = codigo;
        this.distribuidor = distribuidor;
        this.tipoLadrillo = tipoLadrillo;
        this.tipoCamion = tipoCamion;
        this.cantidad = cantidad;
    }

    public double obtenerPrecioUnidad() {
        // Precio por tipo de ladrillo [cite: 64]
        return tipoLadrillo.equalsIgnoreCase("King Kong") ? 1.20 : 1.00;
    }

    public double calcularGastosEnvio() {
        // Gastos de envío según cantidad y tipo de camión [cite: 66]
        if (cantidad <= 3000) {
            return tipoCamion.equalsIgnoreCase("Paletizados") ? 420.0 : 490.0;
        } else {
            return tipoCamion.equalsIgnoreCase("Paletizados") ? 350.0 : 420.0;
        }
    }

    public double calcularCostoTotalEmbarque() {
        double importeBruto = obtenerPrecioUnidad() * cantidad;
        // Fórmula: 1.19 * (importe bruto + gastos de envío) [cite: 68]
        return 1.19 * (importeBruto + calcularGastosEnvio());
    }
}