module com.example.informe_2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    // Esto permite que JavaFX acceda a tus clases mediante reflexión
    opens com.laboratorio.proyectoucv to javafx.graphics;

    // Esto exporta el paquete para que sea visible fuera del módulo
    exports com.laboratorio.proyectoucv;
}