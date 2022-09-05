package com.example.universitymanagementlibrary;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.URL;
import java.nio.file.OpenOption;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.jar.JarFile;

public class HelloController implements Initializable {
    static Connection con=null;
    PreparedStatement pst=null;
    static ResultSet RS=null,RS1=null;
    static Statement st=null,st1=null;

    @FXML
    private Button btn_bookList;

    @FXML
    private Button btn_lib;

    @FXML
    private Button btn_stu;

    @FXML
    private Button btn_bookIssued;

    @FXML
    private Button btn_returnBooks;

    @FXML
    private Label welcomeText;

    @FXML
    private Label lbl_BList;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    @FXML
    private ImageView iview;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private ImageView btn_close;
    @FXML
    private ComboBox<?> comboBox;
    @FXML
    private TextField BookTb;

    @FXML
    private TextField PriceTb;

    @FXML
    private TextField QtyTb;

    @FXML
    private TextField AuthorTb;

    @FXML
    private Button saveBtn;

    @FXML
    private Button deleteBtn;

    @FXML
    private Button editBtn;

    @FXML
    private Button BrowserBtn;

    @FXML
    private ImageView BCover;
    @FXML
    private TableView<BookList_Users> pane;

    @FXML
    private TableColumn<BookList_Users, Integer> Book_ID;

    @FXML
    private TableColumn<BookList_Users, String> Book_Name;

    @FXML
    private TableColumn<BookList_Users, String> Author;

    @FXML
    private TableColumn<BookList_Users, Integer> Price;

    @FXML
    private TableColumn<BookList_Users, Integer> Quantity;

    @FXML
    private TableColumn<BookList_Users, Blob> Cover;

    ObservableList<BookList_Users> listM;
    int index=-1;

    @FXML
    public void initialize(){
        iview.setImage(new Image("C:/Users/mdkha/Documents/GitHub/Codeforces/UniversityManagement-library/src/main/icon/book_18px.png"));
        iview.setImage(new Image("C:/Users/mdkha/Documents/GitHub/Codeforces/UniversityManagement-library/src/main/icon/books_18px.png"));
        iview.setImage(new Image("C:/Users/mdkha/Documents/GitHub/Codeforces/UniversityManagement-library/src/main/icon/library_18px.png"));
        iview.setImage(new Image("C:/Users/mdkha/Documents/GitHub/Codeforces/UniversityManagement-library/src/main/icon/return_18px.png"));
        iview.setImage(new Image("C:/Users/mdkha/Documents/GitHub/Codeforces/UniversityManagement-library/src/main/icon/signature_18px.png"));
        iview.setImage(new Image("C:/Users/mdkha/Documents/GitHub/Codeforces/UniversityManagement-library/src/main/icon/students_18px.png"));
    }
    public void display(){
        Book_ID.setCellValueFactory(new PropertyValueFactory<BookList_Users, Integer>("BID"));
        Book_Name.setCellValueFactory(new PropertyValueFactory<BookList_Users, String>("BName"));
        Author.setCellValueFactory(new PropertyValueFactory<BookList_Users, String >("Author"));
        Price.setCellValueFactory(new PropertyValueFactory<BookList_Users, Integer>("Price"));
        Quantity.setCellValueFactory(new PropertyValueFactory<BookList_Users, Integer>("Qty"));
        Cover.setCellValueFactory(new PropertyValueFactory<BookList_Users, Blob>("Cover"));

        listM=getDataUsers();
        pane.setItems(listM);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        display();
    }
    @FXML
    private void handleButton1Action(ActionEvent event)throws IOException{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("BookList.fxml"));
        rootPane.getChildren().setAll(pane);

    }
    @FXML
    private void handleButton2Action(ActionEvent event)throws IOException{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Librarian.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    @FXML
    private void handleButton3Action(ActionEvent event)throws IOException{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("Students.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    @FXML
    private void handleButton4Action(ActionEvent event)throws IOException{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("BookIssued.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    @FXML
    private void handleButton5Action(ActionEvent event)throws IOException{
        AnchorPane pane= FXMLLoader.load(getClass().getResource("ReturnBooks.fxml"));
        rootPane.getChildren().setAll(pane);
    }
    public void handleClose(javafx.scene.input.MouseEvent event){
        if(event.getSource()==btn_close){
            System.exit(0);
        }
    }

    int inde=-1,key=0;
    int BookID;
    @FXML
    void SelectAction(MouseEvent event) {
        inde=pane.getSelectionModel().getSelectedIndex();
        if(inde<=-1){
            return;
        }
        key=Book_ID.getCellData(inde);
        BookTb.setText(Book_Name.getCellData(inde).toString());
        AuthorTb.setText(Author.getCellData(inde).toString());
        PriceTb.setText(Price.getCellData(inde).toString());
        QtyTb.setText(Quantity.getCellData(inde).toString());
    }
    public void Edit(){
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
            PreparedStatement Save=con.prepareStatement("UPDATE BookTbl values(?,?,?,?,?,?)");
            Save.setInt(1,BookID);
            Save.setString(2,BookTb.getText());
            Save.setString(3,AuthorTb.getText());
            Save.setInt(4,Integer.valueOf(PriceTb.getText()));
            Save.setInt(5,Integer.valueOf(QtyTb.getText()));

            AlertBox.display("News", "Table Updated");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public void Delete(){
        if(key==0){
            AlertBox.display("POPUP","Select a Book");
        }else{
            try{
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
                st=con.createStatement();
                System.out.println("Done1");
                RS=st.executeQuery("Delete From BookTbl Where BID="+key);
                System.out.println("Done2");
                AlertBox.display("PopUp","Book Deleted");
            }catch (Exception e){

            }
        }
    }
    private void countBook(){
        try{
            st1=con.createStatement();
            RS1=st1.executeQuery("Select Max(BID) from BookTbl");
            RS1.next();
            BookID=RS1.getInt(1)+1;
        }catch (Exception e){
            e.printStackTrace();
        }
    }
String imgpath;
    public void Browser_btn(ActionEvent event) {
        FileChooser fileChooser=new FileChooser();
        fileChooser.setTitle("Choose Cover");
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
        fileChooser.getExtensionFilters().clear();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files","*.jpg","*.gif","*.png","*.pdf"));
        File file=fileChooser.showOpenDialog(null);
        if(file!=null){
            imgpath=file.getAbsolutePath();
            BCover.setImage(new Image(file.toURI().toString()));
        }else{
            System.out.println("A file is invalid");
        }
    }
    public static ObservableList<BookList_Users> getDataUsers(){
        ObservableList<BookList_Users> list= FXCollections.observableArrayList();
        try{
            con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
            st=con.createStatement();
            RS=st.executeQuery("SELECT * FROM BookTbl");
            while(RS.next()){
                list.add(new BookList_Users(Integer.parseInt(RS.getString("BID")),Integer.parseInt(RS.getString("Price")),Integer.parseInt(RS.getString("Qty")),RS.getString("BName"),RS.getString("Author"),RS.getBlob("Cover")));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void Save_Btn(ActionEvent event){
        if(BookTb.getText().isEmpty()||AuthorTb.getText().isEmpty()||PriceTb.getText().isEmpty()||QtyTb.getText().isEmpty()){
            saveBtn.setOnAction(e->AlertBox.display("Warning","Missing Information"));
        }else{
            try{
                countBook();
                con= DriverManager.getConnection("jdbc:mysql://localhost:3306/librarydb","root","");
                PreparedStatement Save=con.prepareStatement("insert into BookTbl values(?,?,?,?,?,?)");
                Save.setInt(1,BookID);
                Save.setString(2,BookTb.getText());
                Save.setString(3,AuthorTb.getText());
                Save.setInt(4,Integer.valueOf(PriceTb.getText()));
                Save.setInt(5,Integer.valueOf(QtyTb.getText()));
                InputStream img=new FileInputStream(imgpath);
                Save.setBlob(6,img);
                int row=Save.executeUpdate();
                AlertBox.display("POPUP","Book Added");
                display();
//                BookTb.setText("");
//                AuthorTb.setText("");
//                PriceTb.setText("");
//                QtyTb.setText("");
//                con.close();

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

