package application;

import java.math.BigInteger;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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

public class müsteriController {
public müsteriController() {
		
		baglanti=veritabaniutil.Baglan();
		
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Kayitlar_müsteri,String> ADRES;

    @FXML
    private TableColumn<Kayitlar_müsteri, String> SOYİSİM;

    @FXML
    private TableView<Kayitlar_müsteri> TABLEMÜSTERİ;

    @FXML
    private TableColumn<Kayitlar_müsteri, BigInteger> TC;

    @FXML
    private TableColumn<Kayitlar_müsteri, BigInteger> TELNO;

    @FXML
    private Button btn_ekle;

    @FXML
    private Button btn_güncelle;

    @FXML
    private Button btn_sil;

    @FXML
    private Button btn_temizle;

    @FXML
    private TextField txt_adres;

    @FXML
    private TextField txt_isim;

    @FXML
    private TextField txt_soyisim;

    @FXML
    private TextField txt_tc;

    @FXML
    private TextField txt_telno;

    @FXML
    private TableColumn<Kayitlar_müsteri, String> İSİM;
    
    
    Connection baglanti=null;
    PreparedStatement sorguİfadesi=null;
    ResultSet getirilen=null;
   String sql;
   
   
   
   
   
   
   
   
   
   
   
   public void DegerleriGetir2(TableView tablo) {
		 sql="select * from müsteri" ;
		 ObservableList<Kayitlar_müsteri> kayitlarliste2=FXCollections.observableArrayList();
		   try {
			   sorguİfadesi=baglanti.prepareStatement(sql);
			   ResultSet getirilen=sorguİfadesi.executeQuery();
			   while(getirilen.next()) {
				   
	 kayitlarliste2.add(new Kayitlar_müsteri(getirilen.getString("TC"),getirilen.getString("İSİM"),getirilen.getString("SOYİSİM"),getirilen.getString("TELNO"),getirilen.getString("ADRES")));
			   }
			   TC.setCellValueFactory(new PropertyValueFactory<>("tc"));
			   İSİM.setCellValueFactory(new PropertyValueFactory<>("isim"));
			   SOYİSİM.setCellValueFactory(new PropertyValueFactory<>("soyisim"));
			   
			  TELNO.setCellValueFactory(new PropertyValueFactory<>("telno"));
			   
			 ADRES.setCellValueFactory(new PropertyValueFactory<>("adres"));
			   TABLEMÜSTERİ.setItems(kayitlarliste2);
			  
			   
			   } catch (Exception e) {
			// TODO: handle exception
				   System.out.println(e.getMessage().toString());
		}
		   
		   
		   
	   }
   
   
   
   
   
   
   
   
   
    @FXML
    void TABLEMÜSTERİ_MouseClicked(MouseEvent event) {
    	Kayitlar_müsteri kayit=new Kayitlar_müsteri(sql, sql, sql, sql, sql);
    	kayit=(Kayitlar_müsteri) TABLEMÜSTERİ.getItems().get(TABLEMÜSTERİ.getSelectionModel().getSelectedIndex());
    	txt_tc.setText(kayit.getTc());
    	txt_isim.setText(kayit.getIsim());
    	txt_soyisim.setText(String.valueOf(kayit.getSoyisim()));
    	txt_telno.setText(kayit.getTelno());
    	txt_adres.setText(kayit.getAdres());
    	
    }

    @FXML
    void btn_ekle_Click(ActionEvent event) {
    	 String isim = txt_isim.getText();
    	    String soyisim = txt_soyisim.getText();
    	    String tc = txt_tc.getText();
    	    String telno = txt_telno.getText();
    	    String adres = txt_adres.getText();

    	    try {
    	        String sql = "INSERT INTO müsteri (tc, isim, soyisim, telno, adres) VALUES (?, ?, ?, ?, ?)";
    	        PreparedStatement preparedStatement = baglanti.prepareStatement(sql);
    	        preparedStatement.setString(1, tc);
    	        preparedStatement.setString(2, isim);
    	        preparedStatement.setString(3,soyisim);
    	        preparedStatement.setString(4, telno);
    	        preparedStatement.setString(5, adres);

    	        preparedStatement.executeUpdate();
    	        System.out.println("Veri eklendi.");

    	        // Tabloyu güncelle
    	        DegerleriGetir2(TABLEMÜSTERİ);

    	        // Text alanlarını temizle
    	        txt_isim.clear();
    	        txt_soyisim.clear();
    	        txt_tc.clear();
    	        txt_telno.clear();
    	        txt_adres.clear();
    	    } catch (SQLException e) {
    	        System.out.println("Veri ekleme hatası: " + e.getMessage());
    	    }
    }

    @FXML
    void btn_güncelle_Click(ActionEvent event) {
    	
    	
    	Kayitlar_müsteri kayit = TABLEMÜSTERİ.getSelectionModel().getSelectedItem();
        if (kayit != null) {
            String tc = kayit.getTc();
            String yeniIsim = txt_isim.getText();
            String yeniSoyisim = txt_soyisim.getText();
            String yeniTelno = txt_telno.getText();
            String yeniAdres = txt_adres.getText();

            try {
                String sql = "UPDATE müsteri SET isim = ?, soyisim = ?, telno = ?, adres = ? WHERE tc = ?";
                PreparedStatement preparedStatement = baglanti.prepareStatement(sql);
                preparedStatement.setString(1, yeniIsim);
                preparedStatement.setString(2, yeniSoyisim);
                preparedStatement.setString(3, yeniTelno);
                preparedStatement.setString(4, yeniAdres);
                preparedStatement.setString(5, tc);

                preparedStatement.executeUpdate();
                System.out.println("Güncelleme işlemi tamamlandı.");

                // Tabloyu güncelle
                DegerleriGetir2(TABLEMÜSTERİ);

                // Text alanlarını temizle
                txt_isim.clear();
                txt_soyisim.clear();
                txt_telno.clear();
                txt_adres.clear();
            } catch (SQLException e) {
                System.out.println("Güncelleme hatası: " + e.getMessage());
            }
        }
    	
    	
    }

    @FXML
    void btn_sil_Click(ActionEvent event) {
    	 Kayitlar_müsteri kayit = TABLEMÜSTERİ.getSelectionModel().getSelectedItem();
 	    if (kayit != null) {
 	        String tc = kayit.getTc();
 	        
 	        try {
 	            String sql = "DELETE FROM müsteri WHERE tc = ?";
 	            PreparedStatement preparedStatement = baglanti.prepareStatement(sql);
 	            preparedStatement.setString(1, tc);
 	            preparedStatement.executeUpdate();
 	            System.out.println("SİLİNME İŞLEMİ TAMAMLANDI.");
 	            
 	            DegerleriGetir2(TABLEMÜSTERİ);
 	            
 	            txt_tc.clear();
 	            txt_isim.clear();
 	            txt_soyisim.clear();
 	            txt_telno.clear();
 	            txt_adres.clear();
 	           
 	        } catch (SQLException e) {
 	            System.out.println("SİLME HATASI: " + e.getMessage());
 	        }
 	    }
    }

    @FXML
    void btn_temizle_Click(ActionEvent event) {
txt_adres.clear();
txt_tc.clear();
txt_isim.clear();
txt_soyisim.clear();
txt_telno.clear();
    }

    @FXML
    void initialize() {
       
    	DegerleriGetir2(TABLEMÜSTERİ);
    }

}
