package verini.bcs345.hwk.vet.presentation;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import verini.bcs345.hwk.vet.business.Visit;

/***
 * This class displays a Graphical User Interface using Java FX
 * 
 * @author mattverini
 * @version 1.0
 * @since 12/13/2018
 */

public class VetApplication extends Application {

	private VBox m_VBox;
	private VBox m_VBoxTab2;
	private Menu m_Menu;
	private MenuBar m_MenuBar;
	private Tab m_Tab1;
	private Tab m_Tab2;
	private TabPane m_TabPane;
	private GridPane m_GP;
	private Label m_Label1;
	private Label m_Label2;
	private Label m_Label3;
	private Label m_Label4;
	private Label m_Label5;
	private Label m_Label6;
	private Label m_Label7;
	private MenuItem m_OpenMI;
	private SeparatorMenuItem m_Separator1;
	private MenuItem m_SaveAsMI;
	private MenuItem m_SaveReportMI;
	private SeparatorMenuItem m_Separator2;
	private MenuItem m_ExportAsJSONMI;
	private SeparatorMenuItem m_Separator3;
	private MenuItem m_ExitMI;
	private ListView<String> m_ListView;
	private ObservableList<String> nameOL;

	Visit visit = new Visit();

	@Override
	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Vet Application");
		primaryStage.setHeight(500);
		primaryStage.setWidth(500);
		primaryStage.show();

		m_VBox = new VBox();

		m_Menu = new Menu("File");
		m_MenuBar = new MenuBar();
		m_MenuBar.getMenus().add(m_Menu);

		m_OpenMI = new MenuItem("Open...");
		m_SaveAsMI = new MenuItem("Save As...");
		m_SaveReportMI = new MenuItem("Save Report...");
		m_ExportAsJSONMI = new MenuItem("Export As JSON...");
		m_ExitMI = new MenuItem("Exit");

		m_Tab1 = new Tab("Overview");
		m_Tab1.setClosable(false);
		m_Tab2 = new Tab("Visit Procedure Data");
		m_Tab2.setClosable(false);

		m_TabPane = new TabPane();

		m_TabPane.getTabs().add(m_Tab1);
		m_TabPane.getTabs().add(m_Tab2);

		m_GP = new GridPane();
		m_Label1 = new Label("Veterinarian Name");
		m_Label2 = new Label("Pet Name");
		m_Label3 = new Label("Pet Species");
		m_Label4 = new Label("Pet Gender");
		m_Label5 = new Label("Total Procedure Amount");
		m_Label6 = new Label("Total Procedure Amount Covered");
		m_Label7 = new Label("Total Procedure Amount Due");
		TextField vetName = new TextField();
		vetName.setEditable(false);
		TextField petName = new TextField();
		petName.setEditable(false);
		TextField petSpecies = new TextField();
		petSpecies.setEditable(false);
		TextField petGender = new TextField();
		petGender.setEditable(false);
		TextField totalProcAmt = new TextField();
		totalProcAmt.setEditable(false);
		TextField totalProcAmtCovered = new TextField();
		totalProcAmtCovered.setEditable(false);
		TextField totalProcAmtDue = new TextField();
		totalProcAmtDue.setEditable(false);

		m_GP.setHgap(160);
		m_GP.setVgap(5);

		m_GP.add(m_Label1, 0, 1);
		m_GP.add(vetName, 1, 1);
		m_GP.add(m_Label2, 0, 2);
		m_GP.add(petName, 1, 2);
		m_GP.add(m_Label3, 0, 3);
		m_GP.add(petSpecies, 1, 3);
		m_GP.add(m_Label4, 0, 4);
		m_GP.add(petGender, 1, 4);
		m_GP.add(m_Label5, 0, 5);
		m_GP.add(totalProcAmt, 1, 5);
		m_GP.add(m_Label6, 0, 6);
		m_GP.add(totalProcAmtCovered, 1, 6);
		m_GP.add(m_Label7, 0, 7);
		m_GP.add(totalProcAmtDue, 1, 7);

		m_Tab1.setContent(m_GP);

		m_Separator1 = new SeparatorMenuItem();
		m_Separator2 = new SeparatorMenuItem();
		m_Separator3 = new SeparatorMenuItem();

		m_Menu.getItems().add(m_OpenMI);
		m_OpenMI.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				FileChooser fc = new FileChooser();
				fc.setTitle("Open Visit File");
				File file = fc.showOpenDialog(primaryStage);
				if (file == null) {
					return;
				}
				try {
					visit.Read(new Scanner(file));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				vetName.setText(visit.getVeterinarian());
				petName.setText(visit.getAppointment().getPet().getName());
				petSpecies.setText(visit.getAppointment().getPet().getSpecies());
				petGender.setText(visit.getAppointment().getPet().getGender());
				totalProcAmt.setText(visit.getTotalAmount() + "");
				totalProcAmtCovered.setText(visit.getTotalAmountCovered() + "");
				totalProcAmtDue.setText(visit.getTotalAmountDue() + "");
				for (int i = 0; i < visit.getVisitProcedure().length; i++) {
					nameOL.add(visit.getVisitProcedure()[i].toString() + "\n ");
					// nameOL.add("");
				}
			}
		});
		m_Menu.getItems().add(m_Separator1);
		m_Menu.getItems().add(m_SaveAsMI);
		m_SaveAsMI.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				FileChooser fc = new FileChooser();
				fc.setTitle("Save As Visit");
				File file = fc.showSaveDialog(primaryStage);
				if (file == null) {
					return;
				}
				try {
					visit.Write(new PrintStream(file));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		m_Menu.getItems().add(m_SaveReportMI);
		m_SaveReportMI.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				FileChooser fc = new FileChooser();
				fc.setTitle("Save Report");
				File file = fc.showSaveDialog(primaryStage);
				if (file == null) {
					return;
				}
				try {
					visit.Report(new PrintStream(file));
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		m_Menu.getItems().add(m_Separator2);
		m_Menu.getItems().add(m_ExportAsJSONMI);
		m_ExportAsJSONMI.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				FileChooser fc = new FileChooser();
				fc.setTitle("Export As JSON");
				File file = fc.showSaveDialog(primaryStage);
				if (file == null) {
					return;
				}
				try {
					@SuppressWarnings("resource")
					PrintStream ps = new PrintStream(file);
					ps.println(visit.GetJSON());
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		m_Menu.getItems().add(m_Separator3);
		m_Menu.getItems().add(m_ExitMI);
		m_ExitMI.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				System.exit(0);
			}
		});

		m_VBoxTab2 = new VBox();
		m_ListView = new ListView<>();
		nameOL = FXCollections.observableArrayList();
		m_ListView.setItems(nameOL);

		m_VBoxTab2.getChildren().add(m_ListView);
		m_Tab2.setContent(m_VBoxTab2);

		m_VBox.getChildren().add(m_MenuBar);
		m_VBox.getChildren().add(m_TabPane);

		Scene scene = new Scene(m_VBox, 500, 500);
		primaryStage.setScene(scene);

	}

}
