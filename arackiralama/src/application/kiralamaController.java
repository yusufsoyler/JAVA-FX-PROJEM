package application;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ResourceBundle;

import com.mysql.util.veritabaniutil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class kiralamaController {
public kiralamaController() {
		
		baglanti=veritabaniutil.Baglan();
		
	}
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

 
    @FXML
    private TableColumn<Kayitlar_arac, String> PLAKA;
    @FXML
    private TableColumn<Kayitlar_arac, String> MARKA;

    @FXML
    private TableColumn<Kayitlar_arac, String> KM;

    @FXML
    private TableColumn<Kayitlar_arac, String> RENK;
    @FXML
    private TableColumn<Kayitlar_arac, String> YAKIT;
    
    @FXML
    private TableColumn<Kayitlar_müsteri, String> SOYİSİM;


    @FXML
    private TableColumn<Kayitlar_arac, Integer> YIL;
    
    
    @FXML
    private TableColumn<Kayitlar_müsteri, String> TC;

    @FXML
    private TableColumn<Kayitlar_müsteri, String> TELNO;
    @FXML
    private TableColumn<Kayitlar_arac, Integer> ÜCRET;

    @FXML
    private TableColumn<Kayitlar_müsteri, String> İSİM;
   

    @FXML
    private TableColumn<Kayitlar_müsteri, String> ADRES;
    @FXML
    private Button btn_getir;

    @FXML
    private DatePicker datepicker1;

    @FXML
    private DatePicker datepicker2;

    @FXML
    private Label lbl_sonuc;

    @FXML
    private TableView<Kayitlar_arac> tablearac;

    @FXML
    private TableView<Kayitlar_müsteri> tablemüsteri;
    
    @FXML
    private Label lbl_toplam;

    @FXML
    private TextField txt_günsayısı;

    @FXML
    private TextField txt_isim;

    @FXML
    private TextField txt_plaka;

    @FXML
    private TextField txt_tc;

    @FXML
    private TextField txt_ücret;

    @FXML
    private TextField txt_marka;
    @FXML
    private TextField txt_soyisim;
    @FXML
    private Button btn_rapor;
    @FXML
    private Button btn_grafik;
   
  
    @FXML
    void btn_grafik_Clicked(ActionEvent event) {
    	 ObservableList<Kayitlar_arac> kayitlarListe = tablearac.getItems();

    	    CategoryAxis xAxis = new CategoryAxis();
    	    NumberAxis yAxis = new NumberAxis();
    	    BarChart<String, Number> grafik = new BarChart<>(xAxis, yAxis);

    	    XYChart.Series<String, Number> series = new XYChart.Series<>();
    	    series.setName("Ücretler");

    	    for (Kayitlar_arac kayit : kayitlarListe) {
    	        series.getData().add(new XYChart.Data<>(kayit.getPlaka(), kayit.getÜcret()));
    	    }

    	    grafik.getData().add(series);

    	    
    	    Stage stage = new Stage();
    	    Scene scene = new Scene(grafik, 600, 400);
    	    stage.setScene(scene);
    	    stage.setTitle("Ücret Grafiği");
    	    stage.show();
    }
    

    
    
    @FXML
    void btn_rapor_Clicked(ActionEvent event) {
    	double ucret = Double.parseDouble(txt_ücret.getText());
        int gunSayisi = Integer.parseInt(txt_günsayısı.getText());
        double toplam = ucret * gunSayisi;

        String rapor = "ÖDENECEK TUTAR: " + toplam +"₺"+ "\n"
                      + "TC: " + txt_tc.getText() + "\n"
                      + "İSİM: " + txt_isim.getText() + "\n"
                      + "SOYİSİM: " + txt_soyisim.getText()+"\n"
        +"PLAKA:"+txt_plaka.getText()+"\n"
        +"MARKA:"+txt_marka.getText()+"\n"+
        "ÖDEMENİZİ KREDİ KARTI VEYA HAVALE/EFT ŞEKLİNDE YAPABİLİRSİNİZ"
        +"\n"+
       "\n"+ "YAZDIR";
      

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Rapor");
        alert.setHeaderText(null);
        alert.setContentText(rapor);
        alert.showAndWait();
    }
    
    
    
    
    
    
    
    
    
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
			   tablemüsteri.setItems(kayitlarliste2);
			  
			   
			   } catch (Exception e) {
			// TODO: handle exception
				   System.out.println(e.getMessage().toString());
		}
		   
		   
		   
	   }
 

   @FXML
    void btn_getir_Clicked(ActionEvent event) {
	   LocalDate date1 = datepicker1.getValue();
	    LocalDate date2 = datepicker2.getValue();

	    if (date1 != null && date2 != null) {
	        long günsayısı = ChronoUnit.DAYS.between(date1, date2);
	        lbl_sonuc.setText("Aralarındaki gün sayısı: " + günsayısı);
	        txt_günsayısı.setText(String.valueOf(günsayısı));
	    } else {
	        lbl_sonuc.setText("Başlangıç ve bitiş tarihlerini seçiniz.");
	    }
	    
			
		}
   

    @FXML
    void tablearac_MouseClicked(MouseEvent event) {
    	Kayitlar_arac secilenArac = tablearac.getSelectionModel().getSelectedItem();

        if (secilenArac != null) {
            txt_plaka.setText(secilenArac.getPlaka());
            txt_ücret.setText(String.valueOf(secilenArac.getÜcret()));
            txt_marka.setText(secilenArac.getMarka());
        }
    }

    @FXML
    void tablemüsteri_MouseClicked(MouseEvent event) {
    	 Kayitlar_müsteri secilenMusteri = tablemüsteri.getSelectionModel().getSelectedItem();

    	    if (secilenMusteri != null) {
    	        txt_tc.setText(secilenMusteri.getTc());
    	        txt_isim.setText(secilenMusteri.getIsim());
    	        txt_soyisim.setText(secilenMusteri.getSoyisim());
    	    }
    }

    @FXML
    void initialize() {
    	DegerleriGetir2(tablemüsteri);
DegerleriGetir(tablearac);
    }

}

