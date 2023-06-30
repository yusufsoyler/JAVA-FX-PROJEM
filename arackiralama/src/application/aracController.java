package application;

import java.io.ObjectInputStream.GetField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLClientInfoException;
import java.util.ResourceBundle;

import com.mysql.util.veritabaniutil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import java.sql.*;


public class aracController {
public aracController() {
		
		baglanti=veritabaniutil.Baglan();
		
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Kayitlar_arac, Integer> KM;

    @FXML
    private TableColumn<Kayitlar_arac, String> MARKA;

    @FXML
    private TableColumn<Kayitlar_arac, String> PLAKA;

    @FXML
    private TableColumn<Kayitlar_arac, String> RENK;

    @FXML
    private TableColumn<Kayitlar_arac, String> YAKIT;

    @FXML
    private TableColumn<Kayitlar_arac, Integer> YIL;
    
    @FXML
    private TableColumn<Kayitlar_arac, Integer> ÜCRET;

    @FXML
    private Button btn1_ekle;

    @FXML
    private Button btn1_güncelle;

    @FXML
    private Button btn1_sil;

    @FXML
    private Button btn1_yenile;

    @FXML
    private TableView<Kayitlar_arac> tablearac;

    @FXML
    private TextField txtkm;

    @FXML
    private TextField txtmarka;

    @FXML
    private TextField txtplaka;

    @FXML
    private TextField txtrenk;

    @FXML
    private TextField txtyakıt;

    @FXML
    private TextField txtyıl;

    @FXML
    private TextField txtücret;
    Connection baglanti=null;
    PreparedStatement sorguİfadesi=null;
    ResultSet getirilen=null;
   String sql;


  
   public void DegerleriGetir(TableView tablo) {
	 sql="select * from aracislemleri" ;
	 ObservableList<Kayitlar_arac> kayitlarliste=FXCollections.observableArrayList();
	   try {
		   sorguİfadesi=baglanti.prepareStatement(sql);
		   ResultSet getirilen=sorguİfadesi.executeQuery();
		   while(getirilen.next()) {
			   
			 kayitlarliste.add(new Kayitlar_arac(getirilen.getString("PLAKA"),getirilen.getString("MARKA"),getirilen.getInt("YIL"),getirilen.getString("RENK"),getirilen.getString("YAKIT"),getirilen.getInt("KM"),getirilen.getInt("ÜCRET")));  
		   }
		   PLAKA.setCellValueFactory(new PropertyValueFactory<>("plaka"));
		   MARKA.setCellValueFactory(new PropertyValueFactory<>("marka"));
		   YIL.setCellValueFactory(new PropertyValueFactory<>("yıl"));
		   
		   RENK.setCellValueFactory(new PropertyValueFactory<>("renk"));
		   
		   YAKIT.setCellValueFactory(new PropertyValueFactory<>("yakıt"));
		   
		   KM.setCellValueFactory(new PropertyValueFactory<>("km"));
		   
		  ÜCRET.setCellValueFactory(new PropertyValueFactory<>("ücret"));
		  tablearac.setItems(kayitlarliste);
		   
		   } catch (Exception e) {
		// TODO: handle exception
			   System.out.println(e.getMessage().toString());
	}
	   
	   
	   
   }

    @FXML
    void btn1_ekle_Click(ActionEvent event) {
    	try {
            String plaka = txtplaka.getText();
            String marka = txtmarka.getText();
            int yil = Integer.parseInt(txtyıl.getText());
            String renk = txtrenk.getText();
            String yakit = txtyakıt.getText();
            int km = Integer.parseInt(txtkm.getText());
            int ucret = Integer.parseInt(txtücret.getText());
            
            String sql = "INSERT INTO aracislemleri (PLAKA, MARKA, YIL, RENK, YAKIT, KM, ÜCRET) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = baglanti.prepareStatement(sql);
            preparedStatement.setString(1, plaka);
            preparedStatement.setString(2, marka);
            preparedStatement.setInt(3, yil);
            preparedStatement.setString(4, renk);
            preparedStatement.setString(5, yakit);
            preparedStatement.setInt(6, km);
            preparedStatement.setInt(7, ucret);
            
            preparedStatement.executeUpdate();
            System.out.println("EKLEME BAŞARILI.");
            
            DegerleriGetir(tablearac);
            
            txtplaka.clear();
            txtmarka.clear();
            txtyıl.clear();
            txtrenk.clear();
            txtyakıt.clear();
            txtkm.clear();
            txtücret.clear();
        } catch (SQLException e) {
            System.out.println("HATA: " + e.getMessage());
        }

    }

    @FXML
    void btn1_güncelle_Click(ActionEvent event) {
    	Kayitlar_arac kayit = tablearac.getSelectionModel().getSelectedItem();
        if (kayit != null) {
            String plaka = kayit.getPlaka();
            
            try {
                String sql = "UPDATE aracislemleri SET MARKA = ?, YIL = ?, RENK = ?, YAKIT = ?, KM = ?, ÜCRET = ? WHERE PLAKA = ?";
                PreparedStatement preparedStatement = baglanti.prepareStatement(sql);
                preparedStatement.setString(1, txtmarka.getText());
                preparedStatement.setInt(2, Integer.parseInt(txtyıl.getText()));
                preparedStatement.setString(3, txtrenk.getText());
                preparedStatement.setString(4, txtyakıt.getText());
                preparedStatement.setInt(5, Integer.parseInt(txtkm.getText()));
                preparedStatement.setInt(6, Integer.parseInt(txtücret.getText()));
                preparedStatement.setString(7, plaka);
                
                preparedStatement.executeUpdate();
                System.out.println("BAŞARIYLA GÜNCELLENDİ.");
                
                DegerleriGetir(tablearac);
                
                txtplaka.clear();
                txtmarka.clear();
                txtyıl.clear();
                txtrenk.clear();
                txtyakıt.clear();
                txtkm.clear();
                txtücret.clear();
            } catch (SQLException e) {
                System.out.println("Error updating data: " + e.getMessage());
            }
        }
        }
    

    @FXML
    void btn1_sil_Click(ActionEvent event) {
    	 Kayitlar_arac kayit = tablearac.getSelectionModel().getSelectedItem();
    	    if (kayit != null) {
    	        String plaka = kayit.getPlaka();
    	        
    	        try {
    	            String sql = "DELETE FROM aracislemleri WHERE PLAKA = ?";
    	            PreparedStatement preparedStatement = baglanti.prepareStatement(sql);
    	            preparedStatement.setString(1, plaka);
    	            preparedStatement.executeUpdate();
    	            System.out.println("SİLİNME İŞLEMİ TAMAMLANDI.");
    	            
    	            DegerleriGetir(tablearac);
    	            
    	            txtplaka.clear();
    	            txtmarka.clear();
    	            txtyıl.clear();
    	            txtrenk.clear();
    	            txtyakıt.clear();
    	            txtkm.clear();
    	            txtücret.clear();
    	        } catch (SQLException e) {
    	            System.out.println("SİLME HATASI: " + e.getMessage());
    	        }
    	    }
    }

    @FXML
    void btn_yenile_Click(ActionEvent event) {
    	 DegerleriGetir(tablearac);
    	    txtplaka.clear();
    	    txtmarka.clear();
    	    txtyıl.clear();
    	    txtrenk.clear();
    	    txtyakıt.clear();
    	    txtkm.clear();
    	    txtücret.clear();
    }

    @FXML
    void tablearac_MouseClick(MouseEvent event) {

    	Kayitlar_arac kayit=new Kayitlar_arac();
    	kayit=(Kayitlar_arac) tablearac.getItems().get(tablearac.getSelectionModel().getSelectedIndex());
    	txtplaka.setText(kayit.getPlaka());
    	txtmarka.setText(kayit.getMarka());
    	txtyıl.setText(String.valueOf(kayit.getYıl()));
    	txtrenk.setText(kayit.getRenk());
    	txtyakıt.setText(kayit.getYakıt());
    	txtkm.setText(String.valueOf(kayit.getKm()));
    	txtücret.setText(String.valueOf(kayit.getÜcret()));
    	
    	
    	
    	
    }

    @FXML
    void initialize() {
       DegerleriGetir(tablearac);

    }

}
