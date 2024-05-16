package com.inventorymanagementsystem;

import com.inventorymanagementsystem.entity.*;
import com.inventorymanagementsystem.config.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
import org.controlsfx.control.textfield.TextFields;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

import static org.burningwave.core.assembler.StaticComponentContainer.Modules;

public class DashboardController implements Initializable {
    private double x;
    private double y;

    @FXML
    private Button billing_btn;

    @FXML
    private AnchorPane billing_pane;

    @FXML
    private Button customer_btn;
    
    @FXML
    private Label facture_num;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane customer_pane;

    @FXML
    private AnchorPane dasboard_pane;


    @FXML
    private Button purchase_btn;

    @FXML
    private AnchorPane purchase_pane;

    @FXML
    private Button sales_btn;

    @FXML
    private AnchorPane sales_pane;

    @FXML
    private Label user;

    @FXML
    private Label inv_num;

    private Connection connection;

    private Statement statement;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    @FXML
    private Button commande_ajt;

    @FXML
    private Button commande_efface;

    @FXML
    private DatePicker commande_date;

    @FXML
    private TextField commande_id_pd;

    @FXML
    private TextField commande_nom;
    
    @FXML
    private TextField commande_prenom;
    
    @FXML
    private TextField commande_addresse;
    
    @FXML
    private Label total_final;

    @FXML
    private TextField commande_tele;
    
    @FXML
    private DatePicker date_comm_livraison;

    @FXML
    private TextField commande_prix;

    @FXML
    private Button commande_print;

    @FXML
    private ComboBox<?> commande_quant;

    @FXML
    private Button commande_sauv;


    
    @FXML
    private TextField commande_total;

    @FXML
    private TableView<Commande> commande_table;

    @FXML
    private TextField billing_table_search;

    @FXML
    private Label final_amount;

    private  String invoiceList[]={"BX123456","ZX123456","AX123456"};

    private String quantityList[]={"1","2","3","4","5","6","7","8","9","10","20", "40","50","100", "1000"};

    @FXML
    private TableColumn<?, ?> col_commande_id_prd;

    @FXML
    private TableColumn<?, ?> col_commande_prix;

    @FXML
    private TableColumn<?, ?> col_commande_quant;

    @FXML
    private TableColumn<?, ?> col_commande_total;

    @FXML
    private Button cust_btn_add;

    @FXML
    private Button cust_btn_delete;

    @FXML
    private Button cust_btn_edit;

    @FXML
    private TableColumn<?, ?> cust_col_id;
    
    @FXML
    private TableColumn<?, ?> cust_col_prenom;
    
    @FXML
    private TableColumn<?, ?> cust_col_addresse;

    @FXML
    private TableColumn<?, ?> cust_col_name;

    @FXML
    private TableColumn<?, ?> cust_col_phone;

    @FXML
    private TextField clt_nom;

    @FXML
    private TextField pd_txt_name;
    
    @FXML
    private TextField pd_txt_price;
    
    @FXML
    private TextField pd_txt_quant;
    
    @FXML
    private TextField clt_telephone;
    
    @FXML
    private TextField clt_prenom;
    
    @FXML
    private TextField clt_addresse;

    @FXML
    private TextField customer_search;

    @FXML
    private TableView<Client> customer_table;

    @FXML
    private TableColumn<?, ?> sales_col_cust_name;

    @FXML
    private TableColumn<?, ?> sales_col_date_of_sales;

    @FXML
    private TableColumn<?, ?> sales_col_id;

    @FXML
    private TableColumn<?, ?> sales_col_inv_num;

    @FXML
    private TableColumn<?, ?> sales_col_quantity;

    @FXML
    private TableColumn<?, ?> sales_col_total_amount;

    @FXML
    private TableColumn<?, ?> sales_col_price;

    @FXML
    private TableColumn<?, ?> sales_col_item_num;

    @FXML
    private TableView<Sales> sales_table;

    @FXML
    private Label sales_total_amount;

    @FXML
    private Button product_btn_add;

    @FXML
    private Button purchase_btn_print;

    @FXML
    private Label purchase_total_amount;

    @FXML
    private TableColumn<?, ?> product_col_name;

    @FXML
    private TableColumn<?, ?> product_col_id;

    @FXML
    private TableColumn<?, ?> product_col_item_group;

    @FXML
    private TableColumn<?, ?> product_col_item_number;

    @FXML
    private TableColumn<?, ?> product_col_price;

    @FXML
    private TableColumn<?, ?> product_col_quantity;

    @FXML
    private TableView<Product> product_table;

    @FXML
    private Label dash_total_items_sold_this_month;

    @FXML
    private Label dash_total_purchase;

    @FXML
    private Label dash_total_sales_items_this_month_name;

    @FXML
    private Label dash_total_sales_this_month;

    @FXML
    private Label dash_total_sales_this_month_name;

    @FXML
    private Label dash_total_sold;

    @FXML
    private Label dash_total_stocks;

    @FXML
    private Button signout_btn;

    List<Product> productsList;

    public void onExit(){
        System.exit(0);
    }

    public void activateAnchorPane(){
        dashboard_btn.setOnMouseClicked(mouseEvent -> {
            dasboard_pane.setVisible(true);
            billing_pane.setVisible(false);
            customer_pane.setVisible(false);
            sales_pane.setVisible(false);
            purchase_pane.setVisible(false);
            dashboard_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.7),  rgba(255,106,239,0.7))");
            billing_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            customer_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            sales_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            purchase_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
        });
        billing_btn.setOnMouseClicked(mouseEvent -> {
            dasboard_pane.setVisible(false);
            billing_pane.setVisible(true);
            customer_pane.setVisible(false);
            sales_pane.setVisible(false);
            purchase_pane.setVisible(false);
            dashboard_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            billing_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.7),  rgba(255,106,239,0.7))");
            customer_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            sales_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            purchase_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
        });
        customer_btn.setOnMouseClicked(mouseEvent -> {
            dasboard_pane.setVisible(false);
            billing_pane.setVisible(false);
            customer_pane.setVisible(true);
            sales_pane.setVisible(false);
            purchase_pane.setVisible(false);
            dashboard_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            billing_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            customer_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.7),  rgba(255,106,239,0.7))");
            sales_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            purchase_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
        });
        sales_btn.setOnMouseClicked(mouseEvent -> {
            dasboard_pane.setVisible(false);
            billing_pane.setVisible(false);
            customer_pane.setVisible(false);
            sales_pane.setVisible(true);
            purchase_pane.setVisible(false);
            dashboard_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            billing_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            customer_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            sales_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.7),  rgba(255,106,239,0.7))");
            purchase_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
        });
        purchase_btn.setOnMouseClicked(mouseEvent -> {
            dasboard_pane.setVisible(false);
            billing_pane.setVisible(false);
            customer_pane.setVisible(false);
            sales_pane.setVisible(false);
            purchase_pane.setVisible(true);
            dashboard_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            billing_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            customer_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            sales_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.2),  rgba(255,106,239,0.2))");
            purchase_btn.setStyle("-fx-background-color:linear-gradient(to bottom right , rgba(121,172,255,0.7),  rgba(255,106,239,0.7))");
            });



    }

    public void setUsername(){
        user.setText(User.name.toUpperCase());
    }

    public void activateDashboard(){
        dasboard_pane.setVisible(true);
        billing_pane.setVisible(false);
        customer_pane.setVisible(false);
        sales_pane.setVisible(false);
        purchase_pane.setVisible(false);
    }

    public List<Product> getItemsList(){
        productsList=new ArrayList<>();
        connection= Database.getInstance().connectDB();
        String sql="SELECT * FROM products";
        try{
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            Product product;
            while (resultSet.next()){
                product=new Product(Integer.parseInt(resultSet.getString("id")),resultSet.getString("nom"),Integer.parseInt(resultSet.getString("quantity")),Double.parseDouble(resultSet.getString("price")));
                productsList.add(product);
            }
        }catch (Exception err){
            Alert alert=new Alert(Alert.AlertType.ERROR);
            alert.setHeight(500);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(err.getMessage());
            alert.showAndWait();
        }
        return productsList;
    }

    public void setInvoiceNum(){
        connection=Database.getInstance().connectDB();
        String sql="SELECT MAX(inv_num) AS inv_num FROM factures";

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            System.out.println("Result Set "+resultSet);
            while(resultSet.next()) {
                String result=resultSet.getString("inv_num");
                if (result == null) {
                    Invoice.commandeInvoiceNumber = "FAC-1";
                    facture_num.setText(Invoice.commandeInvoiceNumber);
                } else {
                    int invId = Integer.parseInt(result.substring(4));
                    invId++;
                    Invoice.commandeInvoiceNumber = "FAC-" + invId;
                    facture_num.setText(Invoice.commandeInvoiceNumber);
                }
            }
        }catch (Exception err){
            err.printStackTrace();
        }
    }
    public void setAutoCompleteItemNumber(){
        getItemsList();
        List<Integer> itemNumberList=productsList.stream().map(Product::getId).collect(Collectors.toList());
        ObservableList<Integer> observableItemList=FXCollections.observableArrayList(itemNumberList);
        TextFields.bindAutoCompletion(commande_id_pd,observableItemList);
    }

    public void comboBoxQuantity(){
        List<String> list=new ArrayList<>();
        for(String quantity:quantityList){
            list.add(quantity);
        }
        ObservableList comboList= FXCollections.observableArrayList(list);
        commande_quant.setItems(comboList);
    }
    public void checkForPriceandQuantity(){
        if(!commande_prix.getText().isBlank()&& !commande_quant.getSelectionModel().isEmpty()){
            commande_total.setText(String.valueOf(Integer.parseInt(commande_prix.getText())*Integer.parseInt(commande_quant.getValue().toString())+100));
        }else{
            commande_total.setText("0");
        }
    }
    public void getPriceOfTheItem(){
        try {
            Product product = productsList.stream().filter(prod -> String.valueOf(prod.getId()).equals(commande_id_pd.getText())).findAny().get();
            System.out.println("Price " + product.getPrice());
            commande_prix.setText(String.valueOf((int) product.getPrice()));
        }catch (Exception err){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Exception Item Number : "+err.getMessage());
            alert.showAndWait();
        }
    }

    public void onInputTextChanged(){
        commande_prix.setOnKeyReleased(event-> checkForPriceandQuantity());
        commande_prix.setOnKeyPressed(event-> checkForPriceandQuantity());
        commande_prix.setOnKeyTyped(event-> checkForPriceandQuantity());
        commande_quant.setOnAction(actionEvent -> checkForPriceandQuantity());
        commande_id_pd.setOnKeyPressed(actionEvent ->{
            if(actionEvent.getCode().equals(KeyCode.ENTER)) {
                getPriceOfTheItem();
            }
        });
    }

    public void addCommandeData(){
        if(commande_id_pd.getText().isBlank()||commande_quant.getSelectionModel().isEmpty()||commande_prix.getText().isBlank()||commande_total.getText().isBlank()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez les champs obligatoires , id prd, quantite, prix.");
            alert.showAndWait();
            return;
        }
        connection=Database.getInstance().connectDB();
        String sql="INSERT INTO commande(item_number,quantity,price,total_amount)VALUES(?,?,?,?)";
        
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,commande_id_pd.getText());
            preparedStatement.setString(2, commande_quant.getValue().toString());
            preparedStatement.setString(3, commande_prix.getText());
            preparedStatement.setString(4,commande_total.getText());

            int result=preparedStatement.executeUpdate();
            
            if(result>0){
               showCommandeData();
               commandeClearData();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez les champs obligatoires , id prd, quantite, prix.");
                alert.showAndWait();
            }
        }catch (Exception err){
            err.printStackTrace();
        }
    }

    public ObservableList<Commande> listBilligData(){
        ObservableList<Commande> billingList=FXCollections.observableArrayList();
        connection=Database.getInstance().connectDB();
        String sql="SELECT * FROM commande";
        try{
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);


              Commande commandeData;
              while (resultSet.next()){
              commandeData=new Commande(resultSet.getString("item_number"),Integer.parseInt(resultSet.getString("quantity")),Double.parseDouble(resultSet.getString("price")),Double.parseDouble(resultSet.getString("total_amount")));
              billingList.addAll(commandeData);
             }


        }catch (Exception err){
            err.printStackTrace();
        }
        return billingList;
    }

    public void calculateFinalAmount(){
        connection=Database.getInstance().connectDB();
        String sql="SELECT SUM(total_amount) AS final_amount FROM commande";
        try{
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            if(resultSet.next()){
                total_final.setText(resultSet.getString("final_amount"));
            }

        }catch (Exception err){
            err.printStackTrace();
        }

    }
    
    public void addDateShipping() {
    	connection = Database.getInstance().connectDB();
    	String sql = "INSERT INTO livraison(dateliv, id_commande) VALUES(?, ?)";
    	try {
    		preparedStatement = connection.prepareStatement(sql);
    		preparedStatement.setString(1, date_comm_livraison.getValue().toString());
    		preparedStatement.setString(2, commande_id_pd.getText());
    		int result = preparedStatement.executeUpdate();
    		if(result > 0) {
    			showCommandeData();
    			commandeClearData();
    		}else {
    			Alert alert = new Alert(Alert.AlertType.ERROR);
    			alert.setTitle("Error Message");
    			alert.setHeaderText(null);
    			alert.setContentText("Veuillez les champs obligatoires , date de livraison.");
    			alert.showAndWait();
    		}
    	}catch (Exception err) {
    		err.printStackTrace();
    	}
    	
    }

    public void showCommandeData(){
        ObservableList<Commande> billingList=listBilligData();
        col_commande_id_prd.setCellValueFactory(new PropertyValueFactory<>("NProduit"));
        col_commande_quant.setCellValueFactory(new PropertyValueFactory<>("Quantite"));
        col_commande_prix.setCellValueFactory(new PropertyValueFactory<>("Prix"));
        col_commande_total.setCellValueFactory(new PropertyValueFactory<>("Total"));

        commande_table.setItems(billingList);
        LocalDate date=LocalDate.now();
        commande_date.setValue(date);
        if(!billingList.isEmpty()){
         calculateFinalAmount();
        }else{
            total_final.setText("0.00");
        }

    }

    public void CommandeClearCustomerData(){
        commande_nom.setText("");
        commande_tele.setText("");
        commande_prenom.setText("");
        commande_addresse.setText("");
        
    }

    public void commandeClearData(){
        commande_id_pd.clear();
        commande_quant.setValue(null);
        commande_prix.setText("");
        commande_total.setText("");
        
        
        
    }

    public void selectCommandeTableData(){
        int num=commande_table.getSelectionModel().getSelectedIndex();
        Commande commandeData=commande_table.getSelectionModel().getSelectedItem();
        if(num-1 < -1){
            return;
        }
        commande_id_pd.setText(commandeData.getNProduit());
        commande_prix.setText(String.valueOf((int)commandeData.getPrix()));
        commande_total.setText(String.valueOf((int)commandeData.getTotal()));
    }
    public void updateSelectedCommandeData() {
        connection = Database.getInstance().connectDB();
        String sql = "UPDATE commande SET quantity=?,price=?,total_amount=? HERE item_number=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,commande_quant.getValue().toString());
            preparedStatement.setString(2, commande_prix.getText());
            preparedStatement.setString(3, commande_total.getText());
            preparedStatement.setString(4, commande_id_pd.getText());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                showCommandeData();
                commandeClearData();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez les champs obligatoires , id prd, quantite, prix.");
                alert.showAndWait();
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void deleteCommandeData(){
        connection = Database.getInstance().connectDB();
        String sql;
        try {
            if(commande_table.getSelectionModel().isEmpty()){
                sql = "DELETE FROM commande";
                preparedStatement = connection.prepareStatement(sql);
            }else{
                sql="DELETE FROM commande WHERE item_number=?";
                preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setString(1,commande_table.getSelectionModel().getSelectedItem().getNProduit());
            }
           int result = preparedStatement.executeUpdate();
            if (result > 0) {
                showCommandeData();
                commandeClearData();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("Aucun contenu dans la table..");
                alert.showAndWait();
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
    
    
    public boolean saveClientDetails(){
        if(commande_tele.getText().isBlank() || commande_nom.getText().isBlank() || commande_prenom.getText().isBlank() || commande_addresse.getText().isBlank() || date_comm_livraison.getValue().toString().isBlank()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Remplir le nom, prenom , addresse et le num de telephone");
            alert.showAndWait();
            return false;
        }
        connection = Database.getInstance().connectDB();
        String sql="SELECT * FROM clients WHERE PhoneNumber=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,commande_tele.getText());
            resultSet= preparedStatement.executeQuery();
            if (resultSet.next()) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("Client existe deja. Commande procédé");
                alert.showAndWait();
                return true;
            } else {
                String customerSql="INSERT INTO clients(Name,prenom, address,PhoneNumber) VALUES(?,?,?,?)";
                preparedStatement = connection.prepareStatement(customerSql);
                preparedStatement.setString(1,commande_nom.getText());
                preparedStatement.setString(2,commande_prenom.getText());
                preparedStatement.setString(3,commande_addresse.getText());
                preparedStatement.setString(4,commande_tele.getText());
                int result= preparedStatement.executeUpdate();
                if(result>0){
                    showClientData();
                    return true;
                }else{
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Client non enregisté. Veuillez saisir les données correctement");
                    alert.showAndWait();
                    return false;
                }
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
        return false;
    }
    public void saveInvoiceDetails(){
        // GET CUSTOMER ID FOR MAPPING INVOICE RECORDS
        connection=Database.getInstance().connectDB();
        String sql="SELECT id FROM clients WHERE PhoneNumber=?";
        String sql2 = "INSERT INTO livraison(dateliv, num_facture) VALUES(?, ?)";
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,commande_tele.getText());
            resultSet=preparedStatement.executeQuery();
            

            
            
            if(resultSet.next()){
                  String custId=resultSet.getString("id");
                  // GET BILLING TABLE DETAILS
                  String getBillingDetails="SELECT * FROM commande";
                  preparedStatement=connection.prepareStatement(getBillingDetails);
                  resultSet=preparedStatement.executeQuery();
                  // SAVE INVOICE DETAILS ALONG WITH CUSTOMER ID AND DATE IN SALES TABLE
                  int count=0;
                  while (resultSet.next()){
                      String salesDetailsSQL="INSERT INTO factures(inv_num,item_number,cust_id,price,quantity,total_amount,date) VALUES(?,?,?,?,?,?,?)";
                      preparedStatement=connection.prepareStatement(salesDetailsSQL);
                      preparedStatement.setString(1,facture_num.getText());
                      preparedStatement.setString(2,resultSet.getString("item_number"));
                      preparedStatement.setString(3,custId);
                      preparedStatement.setString(4,resultSet.getString("price"));
                      preparedStatement.setString(5,resultSet.getString("quantity"));
                      preparedStatement.setString(6,resultSet.getString("total_amount"));
                      preparedStatement.setString(7,commande_date.getValue().toString());
                      preparedStatement.executeUpdate();
                      count++;
                      

                  }
                  if(count>0){
                      CommandeClearCustomerData();
                      deleteCommandeData();
                      showSalesData();
                      preparedStatement = connection.prepareStatement(sql2);
                      preparedStatement.setString(1, date_comm_livraison.getValue().toString());
                      preparedStatement.setString(2, facture_num.getText());
                      preparedStatement.executeUpdate();
                      setInvoiceNum();
                      showDashboardData();
                      Alert alert = new Alert(Alert.AlertType.INFORMATION);
                      alert.setTitle("Message");
                      alert.setHeaderText(null);
                      alert.setContentText("Data est enregistré avec success");
                      alert.showAndWait();
                  }else{
                      Alert alert = new Alert(Alert.AlertType.ERROR);
                      alert.setTitle("Error Message");
                      alert.setHeaderText(null);
                      alert.setContentText("Aucune data est enrgistrer ");
                      alert.showAndWait();
                  }
            }else{
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Remplir correctement le nom et le num de telephone");
                alert.showAndWait();
            }
        }catch (Exception err){
            err.printStackTrace();
        }


    }

    public void commandeSave(){
        // Save Customer Details
        if(!saveClientDetails()) {
            return;
        }
        //Save Invoice Details in Sales Table and Reference Customer
        saveInvoiceDetails();

    }

    public void printBill(){
     connection=Database.getInstance().connectDB();
     String sql="SELECT * FROM `factures` s INNER JOIN clients c ON s.cust_id=c.id and s.inv_num=(SELECT MAX(inv_num) as inv_num FROM `sales`)";
     try{
         JasperDesign jasperDesign= JRXmlLoader.load(this.getClass().getClassLoader().getResourceAsStream("jasper-reports/Invoice.jrxml"));
         JRDesignQuery updateQuery=new JRDesignQuery();
         updateQuery.setText(sql);
         jasperDesign.setQuery(updateQuery);
         JasperReport jasperReport= JasperCompileManager.compileReport(jasperDesign);
         JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,null,connection);
         JasperViewer.viewReport(jasperPrint ,false);
     }catch (Exception err){
      err.printStackTrace();
     }
    }

    public void clientClearData(){
        clt_nom.setText("");
        clt_prenom.setText("");
        clt_telephone.setText("");
        clt_addresse.setText("");
    }
    public ObservableList<Client> listClientData(){
        ObservableList<Client> clientList=FXCollections.observableArrayList();
        connection=Database.getInstance().connectDB();
        String sql="SELECT * FROM clients";
        try{
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);


            Client client;
            while (resultSet.next()){
                client=new Client(Integer.parseInt(resultSet.getString("id")),resultSet.getString("name"),resultSet.getString("prenom"),resultSet.getString("phonenumber"), resultSet.getString("address"));
                clientList.addAll(client);
            }


        }catch (Exception err){
            err.printStackTrace();
        }
        return clientList;
    }
    public void showClientData(){
        ObservableList<Client> clientList=listClientData();
        cust_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        cust_col_name.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        cust_col_phone.setCellValueFactory(new PropertyValueFactory<>("Telephone"));
        cust_col_prenom.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        cust_col_addresse.setCellValueFactory(new PropertyValueFactory<>("Adresse"));
        customer_table.setItems(clientList);
    }
    public boolean checkForClientAvailability(){
        connection=Database.getInstance().connectDB();
        String sql="SELECT * FROM clients WHERE PhoneNumber=?";
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,clt_telephone.getText());
            resultSet=preparedStatement.executeQuery();
            if(resultSet.next()){
                Alert alert=new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("Client existe deja.");
                alert.showAndWait();
                return false;
            }else {
              return true;
            }
        }catch (Exception err){
            err.printStackTrace();
        }

        return false;
    }
    public void addClientData(){
        if(!checkForClientAvailability()){
            return;
        }
        connection=Database.getInstance().connectDB();
        String sql="INSERT INTO clients(Name,PhoneNumber, prenom, address)VALUES(?,?, ?, ?)";
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,clt_nom.getText());
            preparedStatement.setString(2,clt_telephone.getText());
            preparedStatement.setString(3,clt_prenom.getText());
            preparedStatement.setString(4,clt_addresse.getText());
            
            int result=preparedStatement.executeUpdate();
            if(result>0){
                showClientData();
                clientClearData();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez saisir les informations correctement");
                alert.showAndWait();
            }
        }catch (Exception err){
            err.printStackTrace();
        }
    }
    public void selectClientTableData(){
        int num=customer_table.getSelectionModel().getSelectedIndex();
        Client customerData=customer_table.getSelectionModel().getSelectedItem();
        if(num-1 < -1){
            return;
        }

        clt_nom.setText(customerData.getNom());
        clt_telephone.setText(customerData.getTelephone());
        clt_prenom.setText(customerData.getPrenom());
        clt_addresse.setText(customerData.getAdresse());
    }

    public void updateClientData(){
        if(clt_telephone.getText().isBlank() || clt_nom.getText().isBlank() || clt_prenom.getText().isBlank() || clt_addresse.getText().isBlank() ){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez saisir les coordonnees correctement .");
            alert.showAndWait();
            return;
        }
        connection = Database.getInstance().connectDB();
        String sql = "UPDATE clients SET Name=?, prenom=?, address=? WHERE PhoneNumber=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,clt_nom.getText());
            preparedStatement.setString(2, clt_prenom.getText());
            preparedStatement.setString(3, clt_addresse.getText());
            preparedStatement.setString(4,clt_telephone.getText());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                showClientData();
                clientClearData();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez saisir les coordonnees correctement  .");
                alert.showAndWait();
            }
        } catch (Exception err) {
            err.printStackTrace();
        }
    }

    public void deleteClientData(){
        if(customer_table.getSelectionModel().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Veuillez selectionnez le client voulu supprime.");
            alert.showAndWait();
            return;
        }
        connection = Database.getInstance().connectDB();
        String sql="DELETE FROM clients WHERE PhoneNumber=?";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,customer_table.getSelectionModel().getSelectedItem().getTelephone());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                showClientData();
                clientClearData();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Message");
                alert.setHeaderText(null);
                alert.setContentText("No data present in the customer table.");
                alert.showAndWait();
            }
        } catch (Exception err) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeight(500);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(err.getMessage());
            alert.showAndWait();
        }
    }
    public void printCustomersDetails(){
        connection=Database.getInstance().connectDB();
        String sql="SELECT * FROM clients";
        try{
            JasperDesign jasperDesign= JRXmlLoader.load(this.getClass().getClassLoader().getResourceAsStream("jasper-reports/clients.jrxml"));
            JRDesignQuery updateQuery=new JRDesignQuery();
            updateQuery.setText(sql);
            jasperDesign.setQuery(updateQuery);
            JasperReport jasperReport= JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,null,connection);
            JasperViewer.viewReport(jasperPrint ,false);
        }catch (Exception err){
            err.printStackTrace();
        }
    }
    public void getTotalSalesAmount(){
        connection=Database.getInstance().connectDB();
        String sql="SELECT SUM(total_amount) as total_sale_amount FROM factures";
        try{
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                String result=resultSet.getString("total_sale_amount");
                if (result == null) {
                    sales_total_amount.setText("0.00");
                }else{
                    sales_total_amount.setText(result);
                }
            }
        }catch (Exception err){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeight(500);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(err.getMessage());
            alert.showAndWait();
        }

    }
    public ObservableList<Sales> listSalesData(){
        ObservableList<Sales> salesList=FXCollections.observableArrayList();
        connection=Database.getInstance().connectDB();
        String sql="SELECT * FROM factures s INNER JOIN clients c ON s.cust_id=c.id";
        try{
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            Sales sale;
            while (resultSet.next()){
                sale=new Sales(Integer.parseInt(resultSet.getString("id")),resultSet.getString("inv_num"),Integer.parseInt(resultSet.getString("cust_id")),resultSet.getString("name"),Double.parseDouble(resultSet.getString("price")),Integer.parseInt(resultSet.getString("quantity")),Double.parseDouble(resultSet.getString("total_amount")),resultSet.getString("date"),resultSet.getString("item_number"));
                salesList.addAll(sale);
            }
        }catch (Exception err){
            err.printStackTrace();
        }
        return salesList;
    }
    public void showSalesData(){
        ObservableList<Sales> salesList=listSalesData();
        sales_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        sales_col_inv_num.setCellValueFactory(new PropertyValueFactory<>("inv_num"));
        sales_col_cust_name.setCellValueFactory(new PropertyValueFactory<>("custName"));
        sales_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        sales_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        sales_col_total_amount.setCellValueFactory(new PropertyValueFactory<>("total_amount"));
        sales_col_date_of_sales.setCellValueFactory(new PropertyValueFactory<>("date"));
        sales_col_item_num.setCellValueFactory(new PropertyValueFactory<>("item_num"));
        sales_table.setItems(salesList);

        getTotalSalesAmount();
    }
    public void printSalesDetails(){
        connection=Database.getInstance().connectDB();
        String sql="SELECT * FROM factures s INNER JOIN clients c ON s.cust_id=c.id";
        try{
            JasperDesign jasperDesign= JRXmlLoader.load(this.getClass().getClassLoader().getResourceAsStream("jasper-reports/sales_report.jrxml"));
            JRDesignQuery updateQuery=new JRDesignQuery();
            updateQuery.setText(sql);
            jasperDesign.setQuery(updateQuery);
            JasperReport jasperReport= JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,null,connection);
            JasperViewer.viewReport(jasperPrint ,false);
        }catch (Exception err){
            err.printStackTrace();
        }
    }
    public void getTotalPurchaseAmount(){
        connection=Database.getInstance().connectDB();
        String sql="SELECT * FROM products";
        try{
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                String nom=resultSet.getString("nom");
                String item_group=resultSet.getString("item_group");
                int quantity= Integer.parseInt(resultSet.getString("quantity"));
                double price=resultSet.getDouble("price");
                int id = Integer.parseInt(resultSet.getString("id"));
                //Product product=new Product(id,nom,item_group,quantity,price);
                
            }
        }catch (Exception err){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeight(500);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(err.getMessage());
            alert.showAndWait();
        }

    }
    public void printPurchaseDetails(){
        connection=Database.getInstance().connectDB();
        String sql="SELECT * FROM products";
        try{
            JasperDesign jasperDesign= JRXmlLoader.load(this.getClass().getClassLoader().getResourceAsStream("jasper-reports/purchase_report.jrxml"));
            JRDesignQuery updateQuery=new JRDesignQuery();
            updateQuery.setText(sql);
            jasperDesign.setQuery(updateQuery);
            JasperReport jasperReport= JasperCompileManager.compileReport(jasperDesign);
            JasperPrint jasperPrint= JasperFillManager.fillReport(jasperReport,null,connection);
            JasperViewer.viewReport(jasperPrint ,false);
        }catch (Exception err){
            err.printStackTrace();
        }
    }
    public ObservableList<Product> listProductData(){
        ObservableList<Product> productList=FXCollections.observableArrayList();
        connection=Database.getInstance().connectDB();
        String sql="SELECT * FROM products";
        try{
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            Product product;
            while (resultSet.next()){
                product=new Product(Integer.parseInt(resultSet.getString("id")),resultSet.getString("nom"),Integer.parseInt(resultSet.getString("quantity")),Double.parseDouble(resultSet.getString("price")));
                productList.addAll(product);
            }
        }catch (Exception err){
            err.printStackTrace();
        }
        
        return productList;
    }
    public void showProductData() {
        ObservableList<Product> productList = listProductData();
        System.out.println("Product List: " + productList);
        product_col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        product_col_name.setCellValueFactory(new PropertyValueFactory<>("nom"));
        product_col_quantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        product_col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        product_table.setItems(productList);
    }
    
	public void addProduct(){
        if(pd_txt_name.getText().isBlank()||pd_txt_quant.getText().isBlank()||pd_txt_price.getText().isBlank()){
            Alert alert=new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Message");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the mandatory data such as name, quantity and price.");
            alert.showAndWait();
            return;
        }
        connection=Database.getInstance().connectDB();
        String sql="INSERT INTO products(nom,quantity,price)VALUES(?,?,?)";
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,pd_txt_name.getText());
            preparedStatement.setString(2,pd_txt_quant.getText());
            preparedStatement.setString(3,pd_txt_price.getText());
            int result=preparedStatement.executeUpdate();
            if(result>0){
                showProductData();
            }else{
                Alert alert=new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill the mandatory data such as name, quantity and price.");
                alert.showAndWait();
            }
        }catch (Exception err){
            err.printStackTrace();}}



    public void getTotalSales(){
        connection=Database.getInstance().connectDB();
        String sql="SELECT SUM(quantity) as total_sale FROM factures";
        try{
            statement=connection.createStatement();
            resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                String result=resultSet.getString("total_sale");
                if (result == null) {
                    dash_total_sold.setText("0");
                }else{
                    dash_total_sold.setText(result);
                }
            }
        }catch (Exception err){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeight(500);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(err.getMessage());
            alert.showAndWait();
        }

    }

    public void getTotalStocks(){
        int totalPurchase=Integer.parseInt(dash_total_purchase.getText());
        int total_sold= Integer.parseInt(dash_total_sold.getText());
        int totalStockLeft=totalPurchase-total_sold;
        dash_total_stocks.setText(String.valueOf(totalStockLeft));
    }

    public void getSalesDetailsOfThisMonth(){
        LocalDate date=LocalDate.now();
        String monthName=date.getMonth().toString();
        connection=Database.getInstance().connectDB();
        String sql="SELECT SUM(total_amount) as total_sales_this_month FROM factures WHERE MONTHNAME(date)=?";
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,monthName);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String result=resultSet.getString("total_sales_this_month");
                if (result == null) {
                    dash_total_sales_this_month.setText("0.00");
                }else{
                    dash_total_sales_this_month.setText(result);
                }
                dash_total_sales_this_month_name.setText(monthName);
            }
        }catch (Exception err){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeight(500);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(err.getMessage());
            alert.showAndWait();
        }
    }
    public void getItemSoldThisMonth(){
        LocalDate date=LocalDate.now();
        String monthName=date.getMonth().toString();
        connection=Database.getInstance().connectDB();
        String sql="SELECT SUM(quantity) as total_items_sold_this_month FROM factures WHERE MONTHNAME(date)=?";
        try{
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,monthName);
            resultSet=preparedStatement.executeQuery();
            while (resultSet.next()){
                String result=resultSet.getString("total_items_sold_this_month");
                if (result == null) {
                    dash_total_items_sold_this_month.setText("0");
                }else{
                    dash_total_items_sold_this_month.setText(result);
                }
                dash_total_sales_items_this_month_name.setText(monthName);
            }
        }catch (Exception err){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeight(500);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(err.getMessage());
            alert.showAndWait();
        }
    }
    public void showDashboardData(){
     getTotalSales();
     getTotalStocks();
     getSalesDetailsOfThisMonth();
     getItemSoldThisMonth();
    }
    public void signOut(){
        signout_btn.getScene().getWindow().hide();
        try{
        Parent root = FXMLLoader.load(getClass().getResource("login-view.fxml"));
        Scene scene = new Scene(root);
        Stage stage=new Stage();
            root.setOnMousePressed((event)->{
                x=event.getSceneX();
                y=event.getSceneY();
            });
            root.setOnMouseDragged((event)->{
                stage.setX(event.getScreenX()-x);
                stage.setY(event.getScreenY()-y);
            });

            stage.initStyle(StageStyle.TRANSPARENT);
            stage.setScene(scene);
            stage.show();
        }catch (Exception err){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeight(500);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText(err.getMessage());
            alert.showAndWait();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Exports all modules to other modules
        Modules.exportAllToAll();

        setUsername();
        activateDashboard();

//      DASHBOARD PANE
        showDashboardData();

//      BILLING PANE
        setAutoCompleteItemNumber();
        comboBoxQuantity();
        setInvoiceNum();
        showCommandeData();

//      CUSTOMER PANE
        showClientData();

//      SALES PANE
        showSalesData();

//      Purchase Pane
        showProductData();
    }
}
