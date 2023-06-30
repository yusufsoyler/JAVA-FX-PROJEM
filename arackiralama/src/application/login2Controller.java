package application;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class login2Controller implements Initializable {
	



public void anaformuac(ActionEvent event) {
	
	try {
		
		Stage stage=new Stage();
		AnchorPane root=(AnchorPane)FXMLLoader.load(getClass().getResource("ana1.fxml"));
		stage.setScene(new Scene(root));
		stage.setTitle("ANASAYFA");
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
    private Button btn_giris;

    @FXML
    private Label lblMessage;

    @FXML
    private TextField txt_kul;

    @FXML
    private TextField txt_sifre;

    
    @FXML
    void btn_giris_Click(ActionEvent event) {
    	
    	 if ((txt_kul.getText().equals("admin")||txt_kul.getText().equals("123")) && txt_sifre.getText().equals("123")) {
    		 
    	        lblMessage.setText("Giriş başarılı!");
    	        
    	       anaformuac(event);
    	       
    	    } else {
    	        lblMessage.setText("Hatalı kullanıcı adı veya şifre!");
    	    }
    	 
    	    txt_kul.clear();
    	    txt_sifre.clear();
    	    
      
    }


    @FXML
    void initialize() {
       

    }


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}

}
