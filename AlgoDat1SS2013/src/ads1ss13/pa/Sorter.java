package ads1ss13.pa;

/**
* Sorter Klasse in der die Methode {@link #quicksort(DoublyLinkedList, int)}
* implementiert werden soll.
* 
* <p>
* In dieser Klasse m&uuml;ssen Sie Ihren Code einf&uuml;gen und die Method
* {@link #quicksort(DoublyLinkedList, int)} implementieren.
* </p>
* 
* <p>
* Sie k&ouml;nnen beliebige neue Variablen und Methoden in dieser Klasse
* hinzuf&uuml;gen. 
* </p>
*/

public class Sorter {
	
	/**
	* Quicksort Implementierung
	* 
	* @param in Unsortierte Eingabefolge
	* @param numOfElements Gr&ouml;&szlig;e der Eingabefolge 
	* @return Sortiterte Eingabefolge
	*/
	public DoublyLinkedList quicksort(DoublyLinkedList in, int numOfElements) {
		
		sort(in, in.first, in.first.prev, in.first.prev, numOfElements);
		return in;
	}
	
	private void swap(ListElement A, ListElement B, DoublyLinkedList in){
		//next-zeiger.
		ListElement ntemp=A.next;
		A.next=B.next;
		B.next=ntemp;
		A.next.prev=A;
		B.next.prev=B;
		//prev-zeiger.
		ListElement ptemp=A.prev;
		A.prev=B.prev;
		B.prev=ptemp;
		A.prev.next=A;
		B.prev.next=B;
		
		if(A==in.first){
			in.first=B;
		}
		else if(B==in.first){
			in.first=A;
		}
		
	}
	
	private void sort(DoublyLinkedList in, ListElement kopf, ListElement ende, ListElement pivot, int numOfElements){
		
		if(numOfElements>1){
			//Partitionieren.
			int i=1;
			int j=numOfElements;
			ListElement A=kopf;
			ListElement B=ende;
			ListElement tmp=null;
			do{
				while(A.getKey()<pivot.getKey()){
					i++;
					A=A.next;
				}
				do{
					j--;
					B=B.prev;
				}while((i<j)&&(B.getKey()>pivot.getKey()));
				if(i<j){
					tmp=A;
					swap(A,B,in);
					A=B;
					B=tmp;
					if(B==kopf){
						kopf=A;
					}
				}
			}while(i<j);
			swap(A,pivot,in);
			if(A==kopf){
				tmp=kopf;
				kopf=ende;
				ende=tmp;
			}
			else{
				ende=A;
			}
			
			//rekursiv aufrufen.
			sort(in, kopf, pivot.prev, pivot.prev, i-1);
			sort(in, pivot.next, ende, ende, numOfElements-i);
		}
	}
}
