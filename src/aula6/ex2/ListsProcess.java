package aula6.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ListsProcess {

	public static<E> List<E> filter(List<E> lista, Predicate<E> tester) {
			List<E> tmp = new ArrayList<E>();
			for (E p : lista) {
				if (tester.test(p)) {
					tmp.add(p);
				}
			}
		return tmp;
	}
}