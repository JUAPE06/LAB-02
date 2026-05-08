package com.laboratorio.proyectoucv;

public class Llamada {
    private String tipo;
    private double minutos;
    private String horario;

    public Llamada(String tipo, double minutos, String horario) {
        this.tipo = tipo;
        this.minutos = minutos;
        this.horario = horario;
    }

    public double calcularCostoPorMinuto() {
        // Lógica basada en la tabla de costos de la guía [cite: 58]
        if (tipo.equalsIgnoreCase("Fijo")) {
            return horario.equalsIgnoreCase("Mañana-Tarde") ? 0.20 : 0.15;
        } else {
            return horario.equalsIgnoreCase("Mañana-Tarde") ? 0.50 : 0.35;
        }
    }

    public double calcularCostoTotal() {
        // Costo Total = Costo por minuto * Minutos [cite: 60]
        return calcularCostoPorMinuto() * minutos;
    }
}