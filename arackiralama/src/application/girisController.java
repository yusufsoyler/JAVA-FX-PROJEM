package application;


import java.net.URL;
import java.nio.file.FileSystemAlreadyExistsException;
import java.util.ResourceBundle;

import com.mysql.util.veritabaniutil;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.sql.*;


public class girisController {

	public girisController() {
		
		baglanti=veritabaniutil.Baglan();
		
	}
	
	
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
    private Button btn_ekle;

    @FXML
    private Button btn_giris;

    @FXML
    private Button btn_güncelle;

    @FXML
    private Button btn_sil;

    @FXML
    private Label lbl_sonuc;

    @FXML
    private TextField txt_kul;

    @FXML
    private TextField txt_sifre;

    @FXML
    void btn_ekle_Click(ActionEvent event) {
    	sql="insert into  login(kul_ad,sifre,yetki) values(?,?,?)";

    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		sorguifadesi.setString(2, txt_sifre.getText().trim());
    		sorguifadesi.setString(1, txt_kul.getText().trim());
    		sorguifadesi.setString(3, "0");
    		sorguifadesi.executeUpdate();
    		lbl_sonuc.setText("KULLANICI EKLEME GERÇEKLEŞTİ");
    		
    		
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		lbl_sonuc.setText(e.getMessage().toString());
    	}
    }

    @FXML
    void btn_giris_Click(ActionEvent event) {
    	
sql=" select*from  login where kul_ad=? and sifre=?";
    	try {
    		
    		sorguifadesi=baglanti.prepareStatement(sql);
    		sorguifadesi.setString(1, txt_kul.getText().trim());
    		sorguifadesi.setString(2, txt_sifre.getText().trim());
    		
    		ResultSet getirilen=sorguifadesi.executeQuery();
    		
    		if (!getirilen.next()) {
    			lbl_sonuc.setText("KULLANICI ADI VEYA ŞİFRE HATALI");
				
			}else {
				getirilen.getString(1);
				System.out.println("kİD:"+getirilen.getString("kİD"));
				System.out.println("kullanıcı:"+getirilen.getString("kul_ad"));
				System.out.println("şifre:"+getirilen.getString("sifre"));
				System.out.println("yetki:"+getirilen.getString("yetki"));
				Stage stage = (Stage) btn_giris.getScene().getWindow();
		       
		        stage.close();
				anaformuac(event);

				
				//currentStage
				
			}
    		
			
		} catch (Exception e) {
			// TODO: handle exception
			lbl_sonuc.setText(e.getMessage().toString());
		}
    	
    	
    	
    }

    @FXML
    void btn_güncelle_Click(ActionEvent event) {
    	sql="update login set sifre=? where kul_ad=?";

    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		sorguifadesi.setString(1, txt_sifre.getText().trim());
    		sorguifadesi.setString(2, txt_kul.getText().trim());
    		sorguifadesi.executeUpdate();
    		lbl_sonuc.setText("ŞİFRE GÜNCELLEME GERÇEKLEŞTİ");
    		
    		
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		lbl_sonuc.setText(e.getMessage().toString());
    	}
    }

    @FXML
    void btn_sil_Click(ActionEvent event) {
    	sql="delete from login where sifre=? and kul_ad=?";

    	try {
    		sorguifadesi=baglanti.prepareStatement(sql);
    		sorguifadesi.setString(2, txt_sifre.getText().trim());
    		sorguifadesi.setString(1, txt_kul.getText().trim());
    		sorguifadesi.executeUpdate();
    		lbl_sonuc.setText("KULLANICI SİLME GERÇEKLEŞTİ");
    		
    		
    		
    	} catch (Exception e) {
    		// TODO: handle exception
    		lbl_sonuc.setText(e.getMessage().toString());
    	}
    }
    
	Connection baglanti=null;
	PreparedStatement sorguifadesi=null;
	ResultSet getirilen=null;
	String sql;


    @FXML
    void initialize() {
        

    }

}
