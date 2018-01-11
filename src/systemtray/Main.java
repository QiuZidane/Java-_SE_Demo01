package systemtray;

import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Lighting;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(final Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();

        if (SystemTray.isSupported()) {
            SystemTray tray = SystemTray.getSystemTray();
            Image image = Toolkit.getDefaultToolkit().getImage("temp/capture.png");
            PopupMenu popup = new PopupMenu();
            MenuItem item = new MenuItem("Exit");
            MenuItem item1 = new MenuItem("Exit111");

            popup.add(item);
            popup.add(item1);

            TrayIcon trayIcon = new TrayIcon(image, "Amr_Trial", popup);

            ActionListener listener = new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent arg0) {
                    // TODO Auto-generated method stub
                    System.exit(0);
                }
            };

            ActionListener listener1 = new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent arg0) {
                    Platform.runLater(() -> {
                        primaryStage.show();
                    });
                }
            };

            ActionListener listenerTray = new ActionListener() {
                @Override
                public void actionPerformed(java.awt.event.ActionEvent arg0) {
                    // TODO Auto-generated method stub

                    Platform.runLater(() -> {

                        primaryStage.hide();

                    });

                }
            };

            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
//                    super.mouseClicked(e);
                    if (e.getClickCount() == 2) {
                        System.out.println("double click");

                        Platform.runLater(()->{
                            showPane();
                        });


                    }
                }
            });
//            trayIcon.addActionListener(listenerTray);
            item.addActionListener(listener);
            item1.addActionListener(listener1);

            try {
                tray.add(trayIcon);
            } catch (Exception e) {
                System.err.println("Can't add to tray");
            }
        } else {
            System.err.println("Tray unavailable");
        }
        //
    }

    private void showPane(){
        final Stage stage = new Stage();

        //create root node of scene, i.e. group
        Group rootGroup = new Group();

        //create scene with set width, height and color
        Scene scene = new Scene(rootGroup, 200, 200, Color.WHITESMOKE);

        //set scene to stage
        stage.setScene(scene);

        //set title to stage
        stage.setTitle("New stage");

        //center stage on screen
        stage.centerOnScreen();

        //show the stage
        stage.show();

        //add some node to scene
        Text text = new Text(20, 110, "JavaFX");
        text.setFill(Color.DODGERBLUE);
        text.setEffect(new Lighting());
        text.setFont(Font.font(Font.getDefault().getFamily(), 50));

        //add text to the main root group
        rootGroup.getChildren().add(text);
    }
}