package dataStr.SEMINARS_1;

import java.util.Arrays;

public class MyArrayList {
    private int[] elements;
    private int counter = 0;
    private final int DEFAULT_SIZE = 10;
    private int size = DEFAULT_SIZE;

    /**
     * Noklusējuma konstuktors, izveido sarakstu ar DEFAULT_SIZE vietām
     */
    public MyArrayList() {
        elements = new int[size];
    }

    /**
     * Konstuktors, izveido sarakstu ar input_size vietām
     * 
     * @param input_size
     */
    public MyArrayList(int input_size) {
        if (input_size > 0) {
            size = input_size;
        }
        elements = new int[size];
    }

    /**
     * @return bool atkarībā no tā vai masīvs ir pilns
     */
    public boolean is_full() {
        if (counter == size)
            return true;
        else
            return false;

    }

    /**
     * @return bool atkarībā no tā vai masīvs ir tukšs
     */
    public boolean is_empty() {
        if (counter == 0)
            return true;
        else
            return false;
    }

    /**
     * @return klases paramentru counter
     */
    public int get_counter() {
        return counter;
    }

    // private, jo tikai klases ietvaros lietosim
    /**
     * Dubulto masīva lielumu ja izmērs mazāks par 100, pertējā kadījumā palielina
     * pus-otru reizi
     */
    private void resize() {
        if (size > 100) {
            size *= 1.5;
        } else {
            size *= 2;
        }
        int[] temp = new int[size];
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
    public void push_back(int val) {
        if (is_full()) {
            resize();
        }
        elements[counter++] = val;
    }

    /**
     * Pievieno elementu konkrētā indeksā. Ja pievienotais elements veido caurumus,
     * tad tas tiek
     * pievienots saraksta beigās.
     * 
     * @param position
     * @param val
     */
    public void insert(int position, int val) throws Exception {
        if (position < 0) {
            Exception exc = new Exception("Neatbilstosi ievadlita pozicija");
            throw exc;
        }
        if (is_full()) {
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
     * Izdzēšs elementu konkrētā pozīcijā, ja mēģina dzēst elementu kas neeksistē,
     * tad pēdējais
     * elements tiek izdzēsts
     * 
     * @param position
     * @throws Exception ja saraksts jau tukšs
     */
    public void remove(int position) throws Exception {
        if (is_empty()) {
            Exception exc = new Exception("Saraksts jau ir tukss, neko nevar idzest");
            throw exc;
        }

        for (int i = position; i < counter - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[counter - 1] = 0;
        counter--;
    }

    public int retreve(int position) throws Exception {
        if (position < 0) {
            Exception exc = new Exception("Neatbilstosi ievadlita pozicija");
            throw exc;
        }
        return elements[position];
    }

    /**
     * @param val
     * @return index of first occurance of val. If val not found, returns -1
     */
    public int[] find(int val) throws Excepiton {
        if (is_empty()) {
            Exception exc = new Exception("Sarakstst ir tukšs, tajā neko nevar atrast");
            throw exc;
        }

        int occurence = 0;
        for (int i = 0; i < counter; i++) {
            if (elements[i] == val) {
                occurence++;
            }
        }
        int[] temp = new int[occurence];

        if (occurence == 0) {
            return temp;
        }

        int iterTemp = 0;
        for (int i = 0; i < counter; i++) {
            if (elements[i] == val) {
                temp[iterTemp++] = val;
            }
        }

        return temp;
    }

    public int get_next(int val) {
        // TODO: Izveidot funkciju, kas kā argumentu saņem elementu un atgriež nākamo
        // elementu
        // (veikt nepieciešamās pārbaudes);
        int a = 0;
        return a;
    }

    public void sort() {
        for (int i = 0; i < counter - 1; i++) {
            for (int j = 0; j < counter - i - 1; j++) {
                if (elements[j] > elements[j + 1]) {
                    // swap elements[j+1] and elements[j]
                    int temp = elements[j];
                    elements[j] = elements[j + 1];
                    elements[j + 1] = temp;
                }
            }
        }
    }

    public void print() {
        System.out.println(Arrays.toString(elements));
    }

    public void clear() {
        int[] temp = new int[size];
        elements = temp;
    }
}
