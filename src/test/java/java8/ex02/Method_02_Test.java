package java8.ex02;

import java.util.List;

import org.junit.Test;

import java8.data.Data;
import java8.data.Person;

/**
 * Exercice 02 - Redéfinition
 */
public class Method_02_Test {

	// tag::IDao[]
	interface IDao {
		List<Person> findAll();

		// TODO créer une méthode String format()
		// TODO la méthode retourne une chaîne de la forme [<nb_personnes>
		// persons]
		// TODO exemple de résultat : "[14 persons]", "[30 persons]"

		public default String format() {
			int nb_personne = findAll().size();
			// for (val: )
			String formattage = "[" + nb_personne + " persons]";
			return formattage;
		}
	}
	// end::IDao[]

	// tag::DaoA[]
	class DaoA implements IDao {

		List<Person> people = Data.buildPersonList(20);

		@Override
		public List<Person> findAll() {
			return people;
		}

		// TODO redéfinir la méthode String format()
		// TODO la méthode retourne une chaîne de la forme DaoA[<nb_personnes>
		// persons]
		// TODO exemple de résultat : "DaoA[14 persons]", "DaoA[30 persons]"
		// TODO l'implémentation réutilise la méthode format() de l'interface

		public String format() {
			int nb_personne = findAll().size();
			String formattage = "DaoA[" + nb_personne + " persons]";

			return formattage;
		}

	}
	// end::DaoA[]

	@Test
	public void test_daoA_format() throws Exception {

		DaoA daoA = new DaoA();

		// TODO invoquer la méthode format() pour que le test soit passant
		String result = daoA.format();

		assert "DaoA[20 persons]".equals(result);
	}
}
