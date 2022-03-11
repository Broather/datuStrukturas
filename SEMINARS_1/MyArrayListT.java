package dataStr.SEMINARS_1;

import java.util.Arrays;

public class MyArrayListT<Type> {
    private Type[] elements;
    private int counter = 0;
    private final int DEFAULT_SIZE = 10;
    private int size = DEFAULT_SIZE;

    /**
     * Noklusējuma konstuktors, izveido sarakstu ar DEFAULT_SIZE vietām
     */
    public MyArrayListT() {
        elements = (Type[]) new Object[size];
    }

    /**
     * Konstuktors, izveido sarakstu ar input_size vietām
     * 
     * @param input_size
     */
    public MyArrayListT(int input_size) {
        if (input_size > 0) {
            size = input_size;
        }
        elements = (Type[]) new Object[size];
    }

    /**
     * @return bool atkarībā no tā vai masīvs ir pilns
     */
    public boolean isFull() {
        if (counter == size)
            return true;
        else
            return false;

    }

    /**
     * @return bool atkarībā no tā vai masīvs ir tukšs
     */
    public boolean isEmpty() {
        if (counter == 0)
            return true;
        else
            return false;
    }

    /**
     * @return klases paramentru counter
     */
    public int getCounter() {
        return counter;
    }

    // private, jo tikai klases ietvaros lietosim
    /**
     * Dubulto masīva lielumu ja izmērs mazāks par 100, pertējā kadījumā palielina pus-otru reizi
     */
    private void resize() {
        if (size > 100) {
            size *= 1.5;
        } else {
            size *= 2;
        }
        Type[] temp = (Type[]) new Object[size];
        // pārkopē visus elementus uz temp
        for (int i = 0; i < counter; i++) {
            temp[i] = elements[i];
        }
        elements = temp;
    }

    /**
     * Pievieno elementu saraksta beigās, palielina izmēru ja tas nepieciešams
     * 
     * @param val
     */
    public void pushBack(Type val) {
        if (isFull()) {
            resize();
        }
        elements[counter++] = val;
    }

    /**
     * Pievieno elementu konkrētā indeksā. Ja pievienotais elements veido caurumus, tad tas tiek
     * pievienots saraksta beigās.
     * 
     * @param position
     * @param val
     */
    public void insert(Type val, int position) throws Exception {
        if (position < 0) {
            Exception exc = new Exception("Neatbilstosi ievadlita pozicija");
            throw exc;
        }
        if (isFull()) {
            resize();
        }

        if (position >= counter) {
            elements[counter] = val;
        } else {
            // for loop from last element to position
            for (int i = counter - 1; i >= position; i--) {
                elements[i + 1] = elements[i];
            }
            elements[position] = val;
            counter++;

        }
    }

    /**
     * Izdzēšs elementu konkrētā pozīcijā, ja mēģina dzēst elementu kas neeksistē, tad pēdējais
     * elements tiek izdzēsts
     * 
     * @param position
     * @throws Exception ja saraksts jau tukšs
     */
    public void remove(int position) throws Exception {
        if (isEmpty()) {
            Exception exc = new Exception("Saraksts jau ir tukss, neko nevar idzest");
            throw exc;
        }

        for (int i = position; i < counter - 1; i++) {
            elements[i] = elements[i + 1];
        }
        counter--;
    }

    /**
     * 
     * @param position
     * @return elementu kas ir position indeksā
     * @throws Exception
     */
    public Type retreve(int position) throws Exception {
        if (position < 0) {
            Exception exc = new Exception("Neatbilstosi ievadlita pozicija");
            throw exc;
        }
        return elements[position];
    }

    /**
     * @param val
     * @return masīvs ar elementu indeksiem kuri vienādi ar val
     */
    public int[] find(Type val) throws Exception {
        if (isEmpty()) {
            Exception exc = new Exception("Sarakstst ir tukšs, tajā neko nevar atrast");
            throw exc;
        }

        int occurence = 0;
        for (int i = 0; i < counter; i++) {
            if (elements[i].equals(val)) {
                occurence++;
            }
        }
        int[] result = new int[occurence];

        if (occurence == 0) {
            return result;
        }

        int iterTemp = 0;
        for (int i = 0; i < counter; i++) {
            if (elements[i].equals(val)) {
                result[iterTemp++] = i;
            }
        }

        return result;
    }

    /**
     * 
     * @param val
     * @return masīvs ar elementiem kuri seko elementam kas vienādi ar val
     * @throws Exception
     */
    public Type[] getNext(Type val) throws Exception {
        if (isEmpty()) {
            Exception exc = new Exception("Sarakstst ir tukšs, tajā neko nevar atrast");
            throw exc;
        }
        int[] positions = find(val);
        Type[] result = (Type[]) new Object[positions.length];
        for (int i = 0; i < positions.length; i++) {
            int tempPosition = positions[i];
            if (tempPosition < counter - 1) {
                result[i] = elements[tempPosition + 1];
            }
        }
        return result;

    }

    /**
     * ol' reliable Bubble sort
     */
    public void sort() {
        for (int i = 0; i < counter - 1; i++) {
            for (int j = 0; j < counter - i - 1; j++) {
                if (((Comparable) (elements[i])).compareTo(elements[j]) == -1) {
                    // swap elements[i] and elements[j]
                    Type temp = elements[i];
                    elements[i] = elements[j];
                    elements[j] = temp;
                }
            }
        }
    }

    /**
     * prints the elements
     */
    public void print() {
        System.out.println(Arrays.toString(elements));
    }

    /**
     * clears the elements
     */
    public void clear() {
        elements = (Type[]) new Object[size];
        counter = 0;
        // izsauc garbage collector
        System.gc();
    }
}
