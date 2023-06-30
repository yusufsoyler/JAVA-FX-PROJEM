package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ana1Controller {


	
	
	public void aracformuac(ActionEvent event) {
		
		try {
			
			Stage stage=new Stage();
			AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("arac.fxml"));
			stage.setScene(new Scene(root));
			stage.setTitle("ARAÇ İŞLEMLERİ");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)event.getSource()).getScene().getWindow());
			stage.show();
		

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
public void aracformuac2(ActionEvent event) {
		
		try {
			
			Stage stage=new Stage();
			AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("müsteri.fxml"));
			stage.setScene(new Scene(root));
			stage.setTitle("MÜŞTERİ İŞLEMLERİ");
			stage.initModality(Modality.WINDOW_MODAL);
			stage.initOwner(((Node)event.getSource()).getScene().getWindow());
			stage.show();
		

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
public void aracformuac3(ActionEvent event) {
	
	try {
		
		Stage stage=new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("kiralama.fxml"));
		stage.setScene(new Scene(root));
		stage.setTitle("KİRALAMA İŞLEMLERİ");
		stage.initModality(Modality.WINDOW_MODAL);
		stage.initOwner(((Node)event.getSource()).getScene().getWindow());
		stage.show();
	

	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
	}
	
}

	

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btn_arac;

    @FXML
    private Button btn_cıkıs;

    @FXML
    private Button btn_kiralama;

    @FXML
    private Button btn_müsteri;

    @FXML
    void btn_arac_Click(ActionEvent event) {
aracformuac(event);
    }

    @FXML
    void btn_cıkıs_Click(ActionEvent event) {

    }

    @FXML
    void btn_kiralama_Click(ActionEvent event) {
aracformuac3(event);
    }

    @FXML
    void btn_müsteri_Click(ActionEvent event) {
aracformuac2(event);
    }

    @FXML
    void initialize() {
        
        btn_cıkıs.setOnAction(event -> {
            // Formun kapatılacak işlemleri burada gerçekleştirilir
            Stage stage = (Stage) btn_cıkıs.getScene().getWindow();
            stage.close();
        });

    }

}
