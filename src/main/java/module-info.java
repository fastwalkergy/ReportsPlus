module com.drozal.dataterminal {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires com.almasb.fxgl.all;
    requires jakarta.activation;
    requires jakarta.xml.bind;

    opens com.drozal.dataterminal to javafx.fxml;
    opens com.drozal.dataterminal.logs.Callout to jakarta.xml.bind;
    opens com.drozal.dataterminal.logs.TrafficStop to javafx.fxml, jakarta.xml.bind;
    opens com.drozal.dataterminal.logs.Incident to jakarta.xml.bind;
    opens com.drozal.dataterminal.logs.Search to jakarta.xml.bind;
    opens com.drozal.dataterminal.logs.Arrest to jakarta.xml.bind;
    opens com.drozal.dataterminal.logs.Patrol to jakarta.xml.bind;
    exports com.drozal.dataterminal;
    exports com.drozal.dataterminal.logs.Callout;
    exports com.drozal.dataterminal.util;
    opens com.drozal.dataterminal.util to javafx.fxml;

}