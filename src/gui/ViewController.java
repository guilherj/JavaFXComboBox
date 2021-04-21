package gui;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;
import model.entities.Person;

public class ViewController implements Initializable {

	@FXML // Anota��o necess�ria para que possa ter intera��o com a view
	private ComboBox<Person> comboBoxPerson; // Atributo de refer�ncia para o Combo Box
	

	@FXML
	private Button btAll; // Atributo de refer�ncia para o Bot�o
	

	// Lista especial que j� faz intera��o com a parte gr�fica com a lista normal
	private ObservableList<Person> obsList;
	

	/*
	 * M�todo onbtAllAction() para que seja impresso todos os objetos do tipo Person
	 * quando for clicado no bot�o ALL.
	 */
	@FXML
	public void onbtAllAction() {
		for (Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}

	/*
	 * M�todo onComboBoxPersonAction() serve para que ao selecionar um item na combo
	 * box ocorra uma a��o, nesse exemplo ao selecionar um item o mesmo ir� ser
	 * impresso no console.
	 */
	@FXML
	public void onComboBoxPersonAction() {
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);

	}
	
	

	/*
	 * O m�todo inicialize � um m�todo da interface Initializable que � usado quando
	 * a classe controller ter� qualquer intera��o com o usu�rio.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Maria", "maria@gmail.com"));
		list.add(new Person(2, "Alex", "alex@gmail.com"));
		list.add(new Person(3, "Bob", "bob@gmail.com"));

		
		// M�todo para instanciar a ObservableList
		obsList = FXCollections.observableArrayList(list);

		
		// M�todo para carregar a ObservableList para a combo Box
		comboBoxPerson.setItems(obsList);

		
		/*
		 * M�todo para carregar na Combo Box somente o nome dos itens, pois sem isso
		 * carregar� todo o toString da classe na Combo Box
		 */
		Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
			@Override
			protected void updateItem(Person item, boolean empty) {
				super.updateItem(item, empty);
				setText(empty ? "" : item.getName());
			}
		};
		comboBoxPerson.setCellFactory(factory);
		comboBoxPerson.setButtonCell(factory.call(null));

	}
	
	
	/*
	 * Ap�s escrever todos os c�digos necess�rios deve-se voltar na
	 * view(SceneBuilder) e fazer as associa��es tanto de id's quanto de actions e
	 * etc...
	 */

}
