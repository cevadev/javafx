package com.ceva.intro;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloFXApp extends Application{
    private int width = 350;
    private int height = 150;
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        Scene mainScene = new Scene(usingButtons(), width,height);
        stage.setScene(mainScene);
        stage.setTitle("Base Catalog Application");
        stage.show();
    }

    private VBox usingButtons(){
        Label nameLbl = new Label("Ingrese su nombre");
        TextField nameFld = new TextField();

        Label msg = new Label();
        msg.setStyle("-fx-text-fill: blue;");

        Button sayHelloBtn = new Button("Say hello");
        Button exitBtn = new Button("Exit");

        sayHelloBtn.setOnAction(actionEvent -> {
            String name = nameFld.getText();
            if(name.trim().length() > 0){
                msg.setText("Hello " + name);
            }else{
                msg.setText("Hello no name");
            }
        });

        // exit action
        exitBtn.setOnAction(actionEvent -> Platform.exit());

        VBox root = new VBox();
        root.setSpacing(5); // aplicamos espacio de 5 px en lo hijos
        root.getChildren().addAll(nameLbl, nameFld, msg, sayHelloBtn, exitBtn);

        return root;
    }

    private VBox printBasicText(){
        Text appName = new Text("Base Catalog"); // text node
        Button exitBtn = new Button("Thanks");
        VBox root = new VBox(); //node root de la app
        root.getChildren().add(appName);
        root.getChildren().add(exitBtn);
        return root;
    }
}
