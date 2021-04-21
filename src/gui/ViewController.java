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

	@FXML // Anotação necessária para que possa ter interação com a view
	private ComboBox<Person> comboBoxPerson; // Atributo de referência para o Combo Box
	

	@FXML
	private Button btAll; // Atributo de referência para o Botão
	

	// Lista especial que já faz interação com a parte gráfica com a lista normal
	private ObservableList<Person> obsList;
	

	/*
	 * Método onbtAllAction() para que seja impresso todos os objetos do tipo Person
	 * quando for clicado no botão ALL.
	 */
	@FXML
	public void onbtAllAction() {
		for (Person person : comboBoxPerson.getItems()) {
			System.out.println(person);
		}
	}

	/*
	 * Método onComboBoxPersonAction() serve para que ao selecionar um item na combo
	 * box ocorra uma ação, nesse exemplo ao selecionar um item o mesmo irá ser
	 * impresso no console.
	 */
	@FXML
	public void onComboBoxPersonAction() {
		Person person = comboBoxPerson.getSelectionModel().getSelectedItem();
		System.out.println(person);

	}
	
	

	/*
	 * O método inicialize é um método da interface Initializable que é usado quando
	 * a classe controller terá qualquer interação com o usuário.
	 */
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		List<Person> list = new ArrayList<>();
		list.add(new Person(1, "Maria", "maria@gmail.com"));
		list.add(new Person(2, "Alex", "alex@gmail.com"));
		list.add(new Person(3, "Bob", "bob@gmail.com"));

		
		// Método para instanciar a ObservableList
		obsList = FXCollections.observableArrayList(list);

		
		// Método para carregar a ObservableList para a combo Box
		comboBoxPerson.setItems(obsList);

		
		/*
		 * Método para carregar na Combo Box somente o nome dos itens, pois sem isso
		 * carregará todo o toString da classe na Combo Box
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
	 * Após escrever todos os códigos necessários deve-se voltar na
	 * view(SceneBuilder) e fazer as associações tanto de id's quanto de actions e
	 * etc...
	 */

}
