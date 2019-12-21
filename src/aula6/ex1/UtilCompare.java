package aula6.ex1;

public class UtilCompare {
	public static <T> Comparable<T> findMax(Comparable<T> []a){
		int maxi = 0;
		for (int i = 0; i < a.length; i++) {
			if(a[i] != null && a[i].compareTo((T) a[maxi]) > 0)
				maxi = i;
		}
		return a[maxi];
	}
	
	public static <T> void sortArray(Comparable<T>[] a){
		Comparable<T> aux;
		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i; j < a.length; j++) {
				if(a[i].compareTo((T) a[j]) < 0) {
					aux = a[i];
					a[i] = a[j];
					a[j] = aux;
				}
			}
		}
	}
}
